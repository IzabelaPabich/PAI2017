package pl.ftims.pai.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ftims.pai.central.CentralDao;
import pl.ftims.pai.entities.Product;
import pl.ftims.pai.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    private final CentralDao centralDao;

    @Autowired
    public ProductService(ProductRepository productRepository, CentralDao centralDao) {
        this.productRepository = productRepository;
        this.centralDao = centralDao;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional
    @Scheduled(cron = "0 34 20 * * *")
    public void updateProductsList() {
        log.info("Updating products");
        List<Product> productsFromCentral = centralDao.getProductsFromCentral();
        productRepository.deleteAll();
        productRepository.save(productsFromCentral);
    }
}

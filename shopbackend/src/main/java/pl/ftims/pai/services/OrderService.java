package pl.ftims.pai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ftims.pai.dtos.NewOrderData;
import pl.ftims.pai.entities.Order;
import pl.ftims.pai.entities.Product;
import pl.ftims.pai.repositories.OrderRepository;
import pl.ftims.pai.repositories.ProductRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public Order createOrder(NewOrderData orderData) {
        Product productToOrder = productRepository.findOne(orderData.getProductId());

        if (productToOrder == null) {
            throw new IllegalStateException("Product does not exist");
        }

        Order newOrder = new Order();
        newOrder.setQuantity(orderData.getQuantity());
        newOrder.setOrderedProduct(productToOrder);
        return orderRepository.save(newOrder);
    }
}

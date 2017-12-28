package pl.ftims.pai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ftims.pai.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

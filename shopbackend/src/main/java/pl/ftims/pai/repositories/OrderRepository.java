package pl.ftims.pai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ftims.pai.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

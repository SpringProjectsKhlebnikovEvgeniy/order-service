package sprojects.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sprojects.productservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

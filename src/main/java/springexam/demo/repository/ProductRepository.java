package springexam.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springexam.demo.entity.Product;
import springexam.demo.entity.Sale;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}


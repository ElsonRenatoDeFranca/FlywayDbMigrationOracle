package com.flyway.migrationoracle.repository;

import com.flyway.migrationoracle.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByid(Long cartId);
}

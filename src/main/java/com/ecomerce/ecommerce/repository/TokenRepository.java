package com.ecomerce.ecommerce.repository;

import com.ecomerce.ecommerce.model.AuthenticationToken;
import com.ecomerce.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {

    AuthenticationToken findByUser(User user);
}

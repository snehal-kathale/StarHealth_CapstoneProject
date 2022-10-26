package com.sh.api.eshop.shopify.repository;


import com.sh.api.eshop.shopify.entity.AuthenticationToken;
import com.sh.api.eshop.shopify.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {
    AuthenticationToken findTokenByUser(User user);
    AuthenticationToken findTokenByToken(String token);
}

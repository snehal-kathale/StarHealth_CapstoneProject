package com.sh.api.eshop.shopify.repository;

import com.sh.api.eshop.shopify.entity.Cart;
import com.sh.api.eshop.shopify.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);

    List<Cart> deleteByUser(User user);

}


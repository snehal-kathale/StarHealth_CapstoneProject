package com.sh.api.eshop.shopify.repository;

import com.sh.api.eshop.shopify.entity.Order;
import com.sh.api.eshop.shopify.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Integer> {
    List<Order> findAllByUserOrderByCreatedDateDesc(User user);

}

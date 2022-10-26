package com.sh.api.eshop.shopify.repository;

import com.sh.api.eshop.shopify.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItem,Integer> {
}

package com.sh.api.eshop.shopify.repository;


import com.sh.api.eshop.shopify.entity.User;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, ID> {

    List<User> findAll();

    User findByEmail(String email);

    User findUserByEmail(String email);
}

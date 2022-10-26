package com.sh.api.eshop.shopify.service.imp;

import java.util.List;
import javax.transaction.Transactional;
import com.sh.api.eshop.shopify.entity.WishList;
import com.sh.api.eshop.shopify.repository.WishListRepository;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class WishListService {

    private final WishListRepository wishListRepository;

    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    public void createWishlist(WishList wishList) {
        wishListRepository.save(wishList);
    }

    public List<WishList> readWishList(Integer userId) {
        return wishListRepository.findAllByUserIdOrderByCreatedDateDesc(userId);
    }
}

package com.sh.api.eshop.shopify.controller;


import com.sh.api.eshop.shopify.Dto.product.ProductDto;
import com.sh.api.eshop.shopify.common.ApiResponse;
import com.sh.api.eshop.shopify.entity.Product;
import com.sh.api.eshop.shopify.entity.User;
import com.sh.api.eshop.shopify.entity.WishList;
import com.sh.api.eshop.shopify.service.imp.AuthenticationService;
import com.sh.api.eshop.shopify.service.imp.ProductService;
import com.sh.api.eshop.shopify.service.imp.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/wishlist")
public class WishListController {

        @Autowired
        private WishListService wishListService;

        @Autowired
        private AuthenticationService authenticationService;

        @GetMapping("/{token}")
        public ResponseEntity<List<ProductDto>> getWishList(@PathVariable("token") String token) {
                int user_id = authenticationService.getUser(token).getId();
                List<WishList> body = wishListService.readWishList(user_id);
                List<ProductDto> products = new ArrayList<ProductDto>();
                for (WishList wishList : body) {
                        products.add(ProductService.getDtoFromProduct(wishList.getProduct()));
                }

                return new ResponseEntity<List<ProductDto>>(products, HttpStatus.OK);
        }

        @PostMapping("/add")
        public ResponseEntity<ApiResponse> addWishList(@RequestBody Product product, @RequestParam("token") String token) {
                authenticationService.authenticate(token);
                User user = authenticationService.getUser(token);
                WishList wishList = new WishList(user, product);
                wishListService.createWishlist(wishList);
                return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Add to wishlist"), HttpStatus.CREATED);

        }


}

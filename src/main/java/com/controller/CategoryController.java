package com.controller;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milind.model.User;
import com.service.CategoryService;
import com.service.UserService;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;


    @PostMapping("/admin/category")
    public ResponseEntity<Category> createCategory(@RequestBody Category category,
    @RequestHeader("Authorization") String jwt)throws Exception{
        User user=userService.findUserByJwtToken(jwt);
        Category createdCategory=categoryService.createCategory(category,getName(), user.getId());

        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);


    }

    @PostMapping("/category/restaurant")
    public ResponseEntity<List<Category>> getRestaurantCategory(
    @RequestHeader("Authorization") String jwt)throws Exception{
        User user=userService.findUserByJwtToken(jwt);
        List<Category> Categories=categoryService.findCategoryByRestaurantId( user.getId());

        return new ResponseEntity<>(Categories, HttpStatus.CREATED);

    }




}

package com.test.boot.controller;

import com.test.boot.DAO.Products;
import com.test.boot.DAO.User;
import com.test.boot.Model.ProductsEntity;
import com.test.boot.Model.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @Autowired
    User user;

    @Autowired
    Products products;


    @RequestMapping("/front")
    public String front(Model model) {
        UsersEntity usersEntity = user.findByNameAndPassword("roma", "roma");
        System.out.println(usersEntity.getName() + "  " + usersEntity.getIdRole());
        Iterable<ProductsEntity> list = products.findAll();
        list.forEach(productsEntity -> System.out.println(productsEntity));
        model.addAttribute("user", usersEntity);

//        UserDao user = new UserHiberDao();
//        UserdbEntity userdbEntity = user.selectByLoginPassword("roma", "roma");
//        System.out.println(userdbEntity.getName());
        return "front";
    }

}

package com.test.boot;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application   {
    private static final Logger log = Logger.getLogger(Application.class);



    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

  /*  @Transactional
    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n1.findAll()...");
        for (UserdbEntity customer : userDao.findAll()) {
            System.out.println(customer);
        }
    }*/

}

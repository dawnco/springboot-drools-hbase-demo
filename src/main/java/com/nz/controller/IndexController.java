package com.nz.controller;

import com.example.demo.hbase.HBaseService;
import com.nz.entity.Discount;
import com.nz.entity.Order;
import com.nz.service.OrderDiscountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

    private Logger log = LoggerFactory.getLogger(IndexController.class);

    private OrderDiscountService orderDiscountService;

    @Autowired
    public void setOrderDiscountService(OrderDiscountService orderDiscountService){
        this.orderDiscountService = orderDiscountService;
    }

//    public IndexController(OrderDiscountService orderDiscountService){
//        this.orderDiscountService =
//    }

    @ResponseBody
    @RequestMapping("/")
    public String index() {
        return "Hello World!";
    }

    @ResponseBody
    @RequestMapping("/nz")
    public String nz(HttpServletRequest request) {
        Order order = new Order();
        String age = request.getParameter("age") != null ? request.getParameter("age") : "0";
        String gender = request.getParameter("gender") != null ? request.getParameter("gender") : "0";
        String amount = request.getParameter("amount") != null ? request.getParameter("amount") : "0";

        log.info("----------------------");
        log.info(age);
        log.info(gender);
        log.info(amount);


        order.age = Integer.parseInt(age);
        order.gender = Integer.parseInt(gender);
        order.amount = Integer.parseInt(amount);
        Discount discount = orderDiscountService.getDiscount(order);
        return "Hello World! " + discount.getDiscount();
    }


}

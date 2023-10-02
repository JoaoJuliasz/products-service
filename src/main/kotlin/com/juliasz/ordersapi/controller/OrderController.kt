package com.juliasz.ordersapi.controller

import com.juliasz.ordersapi.model.Product
import com.juliasz.ordersapi.service.OrderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("challenge-backend")
class OrderController(
    val orderService: OrderService
) {

    @GetMapping("/item")
    fun getProducts(
        @RequestParam begindate: String,
        @RequestParam finaldate: String
    ): List<Product> {
        return orderService.getProducts(begindate, finaldate)
    }

}
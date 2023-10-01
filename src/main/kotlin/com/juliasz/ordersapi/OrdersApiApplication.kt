package com.juliasz.ordersapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OrdersApiApplication

fun main(args: Array<String>) {
    runApplication<OrdersApiApplication>(*args)
}

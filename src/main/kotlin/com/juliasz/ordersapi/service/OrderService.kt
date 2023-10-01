package com.juliasz.ordersapi.service

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.juliasz.ordersapi.model.Product
import com.juliasz.ordersapi.repository.OrderRepository
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject


@Service
class OrderService(
    val orderRepository: OrderRepository
) : InitializingBean {
    private val BASE_URL = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9"

    @Autowired
    private lateinit var restTemplate: RestTemplate

    override fun afterPropertiesSet() {
        fetchProducts()
    }

    private fun fetchProducts() {
        val mapper = jacksonObjectMapper()
        val result = restTemplate.getForObject<String>(BASE_URL)
        val typeReference = mapper.typeFactory.constructCollectionType(List::class.java, Product::class.java)
        val products: List<Product> = mapper.readValue(result, typeReference)
        orderRepository.saveProducts(products)
    }

    fun getProducts(begin: String, end: String): List<Product> = orderRepository.getProducts(begin, end)

}
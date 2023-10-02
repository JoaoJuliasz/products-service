package com.juliasz.ordersapi.repository

import com.juliasz.ordersapi.model.Dimension
import com.juliasz.ordersapi.model.Product
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class OrderRepositoryTest {

    private val orderRepository = OrderRepository()

    @BeforeEach
    fun setup() {
        val mockProducts = listOf(
            Product("Printer", "1", "2016-10-05T14:30:37.040Z", Dimension(10.5, 10.5, 10.5, 10.5)),
            Product("Fifa2017", "1", "2016-10-06T14:30:37.040Z", Dimension(10.5, 10.5, 10.5, 10.5)),
            Product("Notebook", "1", "2016-10-07T14:30:37.040Z", Dimension(10.5, 10.5, 10.5, 10.5)),
            Product("Tablet", "1", "2016-10-08T14:30:37.040Z", Dimension(10.5, 10.5, 10.5, 10.5))
        )
        orderRepository.saveProducts(mockProducts)
    }

    @Test
    fun shouldReturnOneValue() {
        val foundProducts = orderRepository.getProducts("05-10-2016", "05-10-2016")
        Assertions.assertThat(foundProducts.size).isEqualTo(1)
    }

    @Test
    fun shouldReturnThreeValues() {
        val foundProducts = orderRepository.getProducts("05-10-2016", "07-10-2016")
        Assertions.assertThat(foundProducts.size).isEqualTo(3)
    }

    @Test
    fun shouldReturnEmptyList() {
        val foundProducts = orderRepository.getProducts("05-10-2017", "07-10-2017")
        Assertions.assertThat(foundProducts.size).isEqualTo(0)
    }
}
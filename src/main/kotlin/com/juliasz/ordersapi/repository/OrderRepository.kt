package com.juliasz.ordersapi.repository

import com.juliasz.ordersapi.model.Product
import org.springframework.stereotype.Repository
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Repository
class OrderRepository {

    private final val orderMap = mutableListOf<Product>()

    fun saveProducts(products: Collection<Product>) {
        orderMap.addAll(products)
    }

    fun getProducts(begin: String, end: String): List<Product> {
        val (formattedBegin, formattedEnd) = formattedDates(begin, end)
        val filteredValues = orderMap.filter {
            val instant = Instant.parse(it.date)
            val productDate = instant.atZone(ZoneId.systemDefault()).toLocalDate()
            productDate >= formattedBegin && productDate <= formattedEnd
            }
        return filteredValues
    }

    fun formattedDates(begin: String, end: String): Pair<LocalDate, LocalDate> {
        val formattedBegin = dateFormatter(begin)
        val formattedEnd = dateFormatter(end)

        return formattedBegin to formattedEnd
    }

    fun dateFormatter(date: String): LocalDate {
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        return LocalDate.parse(date, formatter)
    }

}
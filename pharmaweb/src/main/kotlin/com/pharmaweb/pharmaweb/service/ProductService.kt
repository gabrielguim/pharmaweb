package com.pharmaweb.pharmaweb.service

import com.pharmaweb.pharmaweb.model.Product
import com.pharmaweb.pharmaweb.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService() {

    @Autowired
    lateinit private var repository: ProductRepository

    fun getAll() : List<Product> {
        fun ClosedRange<Int>.random() =
                Random().nextInt(endInclusive - start) +  start

        // Product Mock
        val products: MutableList<Product> = mutableListOf()
        for (i in 0..30) {
            val dep = (1..10).random()
            val cat = (1..10).random()
            repository.save(Product("${i}", "name ${i}", "desc ${i}",
                    "https://i0.wp.com/farmaceuticodigital.com/wp-content/uploads/2016/05/medicamentos2.jpg",
                    "dep ${dep}", "cat ${cat}", i * 1f))
        }

        return products;
    }

    fun register(product: Product) = repository.save(product)

    fun searchByText(textToSeach: String) = repository.searchByText(textToSeach)

    fun groupBy(group: String) = repository.findAll().groupBy {
        if (group.equals("category")) { it.category }
        else { it.department }
    }

    fun findById(productId: String): ResponseEntity<Product> {
        return repository.findById(productId).map { product ->
            ResponseEntity.ok(product)
        }.orElse(ResponseEntity.notFound().build())
    }

    fun alter(productId: String, newProduct: Product): ResponseEntity<Product> {
        return repository.findById(productId).map {
            val updatedProduct: Product = it.copy(name = newProduct.name,
                                                  department = newProduct.department,
                                                  category = newProduct.category,
                                                  price = newProduct.price)

            ResponseEntity.ok().body(repository.save(updatedProduct))
        }.orElse(ResponseEntity.notFound().build())
    }

    fun delete(productId: String): ResponseEntity<Void> {
        return repository.findById(productId).map { product  ->
            repository.delete(product)

            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}
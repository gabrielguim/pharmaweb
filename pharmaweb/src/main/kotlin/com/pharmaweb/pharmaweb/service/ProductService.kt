package com.pharmaweb.pharmaweb.service

import com.pharmaweb.pharmaweb.model.Product
import com.pharmaweb.pharmaweb.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.text.Normalizer

@Service
class ProductService() {

    @Autowired
    lateinit private var repository: ProductRepository

    fun getAll() = repository.findAll().toList()

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
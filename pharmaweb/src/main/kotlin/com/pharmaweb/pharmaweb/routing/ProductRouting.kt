package com.pharmaweb.pharmaweb.routing

import com.pharmaweb.pharmaweb.model.Product
import com.pharmaweb.pharmaweb.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/products")
class ProductRouting {

    @Autowired
    lateinit var productService: ProductService

    @GetMapping
    fun getAll() : List<Product> {

        // Product Mock
        val products: MutableList<Product> = mutableListOf()
        for (i in 0..10) {
            if (i % 2 == 0) {
                productService.register(Product("${i}", "name ${i}", "desc 1", "url ${i}", "dep ${i}", "cat ${i}", i * 1f))
            } else {
                productService.register(Product("${i}", "name ${i}", "desc ${i}", "url ${i}", "dep 1", "cat ${i}", i * 1f))
            }
        }

        return productService.getAll()
    }

    @PostMapping
    fun register(@Valid @RequestBody product: Product) = productService.register(product)

    @GetMapping("/")
    fun searchByText(@RequestParam("q") textToSearch: String) = productService.searchByText("%${textToSearch.toLowerCase()}%")

    @GetMapping("/group/")
    fun groupBy(@RequestParam("by") group: String) = productService.groupBy(group)

    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") productId: String) = productService.findById(productId)

    @PutMapping("/{id}")
    fun alter(@PathVariable(value = "id") productId: String,
              @Valid @RequestBody newProduct: Product) = productService.alter(productId, newProduct)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value = "id") productId: String) = productService.delete(productId)

}
package com.pharmaweb.pharmaweb.routing

import com.pharmaweb.pharmaweb.model.Product
import com.pharmaweb.pharmaweb.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/products")
class ProductRouting {

    @Autowired
    lateinit var productService: ProductService

    @GetMapping
    fun getAll() : List<Product> {

        fun ClosedRange<Int>.random() =
                Random().nextInt(endInclusive - start) +  start

        // Product Mock
        val products: MutableList<Product> = mutableListOf()
        for (i in 0..30) {
            val dep = (1..10).random()
            val cat = (1..10).random()
            productService.register(Product("${i}", "name ${i}", "desc ${i}",
                    "https://media.alienwarearena.com/media/1327-a.jpg",
                    "dep ${dep}", "cat ${cat}", i * 1f))
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
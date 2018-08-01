package com.pharmaweb.pharmaweb.routing

import com.pharmaweb.pharmaweb.model.Product
import com.pharmaweb.pharmaweb.service.ProductService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/products")
@Api(value = "Product Endpoint", description = "Product CRUD operations")
class ProductRouting {

    @Autowired
    lateinit var productService: ProductService

    @ApiOperation(value = "Returns all the registered products")
    @GetMapping
    fun getAll() = productService.getAll()

    @ApiOperation(value = "Registers a new given product")
    @PostMapping
    fun register(@Valid @RequestBody product: Product) = productService.register(product)

    @ApiOperation(value = "Returns a list of products that have in their attributes the given text")
    @GetMapping("/")
    fun searchByText(@RequestParam("q") textToSearch: String) = productService.searchByText("%${textToSearch.toLowerCase()}%")

    @ApiOperation(value = "Returns a list of grouped products, it can be by category or department")
    @GetMapping("/group/")
    fun groupBy(@RequestParam("by") group: String) = productService.groupBy(group)

    @ApiOperation(value = "Returns a single product that has the given id")
    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") productId: String) = productService.findById(productId)

    @ApiOperation(value = "Alters a single product using the new given product that has the given id")
    @PutMapping("/{id}")
    fun alter(@PathVariable(value = "id") productId: String,
              @Valid @RequestBody newProduct: Product) = productService.alter(productId, newProduct)

    @ApiOperation(value = "Deletes a single product that has the given id")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value = "id") productId: String) = productService.delete(productId)

}
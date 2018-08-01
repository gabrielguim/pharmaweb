package com.pharmaweb.pharmaweb.routing

import com.pharmaweb.pharmaweb.model.Druggist
import com.pharmaweb.pharmaweb.service.DruggistService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/druggists")
@Api(value = "Druggist Endpoint", description = "Druggist CRUD operations")
class DruggistRouting {

    @Autowired
    lateinit var druggistService: DruggistService

    @ApiOperation(value = "Returns all the registered druggists")
    @GetMapping
    fun getAll() = druggistService.getAll()

    @ApiOperation(value = "Registers a new given druggist")
    @PostMapping
    fun register(@Valid @RequestBody druggist: Druggist) = druggistService.register(druggist)

    @ApiOperation(value = "Returns a single druggist that has the given id")
    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") druggistId: String) = druggistService.findById(druggistId)

    @ApiOperation(value = "Alters a single druggist using the new given druggists that has the given id")
    @PutMapping("/{id}")
    fun alter(@PathVariable(value = "id") druggistId: String,
              @Valid @RequestBody newDruggist: Druggist) = druggistService.alter(druggistId, newDruggist)

    @ApiOperation(value = "Deletes a single druggist that has the given id")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value = "id") druggistId: String) = druggistService.delete(druggistId)

}
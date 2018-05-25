package com.pharmaweb.pharmaweb.routing

import com.pharmaweb.pharmaweb.model.Druggist
import com.pharmaweb.pharmaweb.service.DruggistService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/druggists/")
class DruggistRouting {

    @Autowired
    lateinit var druggistService: DruggistService

    @GetMapping
    fun getAll() = druggistService.getAll()

    @PostMapping
    fun register(@Valid @RequestBody druggist: Druggist) = druggistService.register(druggist)

    @GetMapping("{id}")
    fun findById(@PathVariable druggistId: Long) = druggistService.findById(druggistId)

    @PutMapping("{id}")
    fun alter(@PathVariable druggistId: Long,
              @Valid @RequestBody newDruggist: Druggist) = druggistService.alter(druggistId, newDruggist)

    @DeleteMapping("{id}")
    fun delete(@PathVariable druggistId: Long) = druggistService.delete(druggistId)

}
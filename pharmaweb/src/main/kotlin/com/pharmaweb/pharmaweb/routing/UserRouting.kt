package com.pharmaweb.pharmaweb.routing

import com.pharmaweb.pharmaweb.model.User
import com.pharmaweb.pharmaweb.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/users")
class UserRouting {

    @Autowired
    lateinit var userService: UserService

    @GetMapping
    fun getAll() = userService.getAll()

    @PostMapping
    fun register(@Valid @RequestBody user: User) = userService.register(user)

    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") userId: Long) = userService.findById(userId)

    @PutMapping("/{id}")
    fun alter(@PathVariable(value = "id") userId: Long,
              @Valid @RequestBody newUser: User) = userService.alter(userId, newUser)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value = "id") userId: Long) = userService.delete(userId)

}
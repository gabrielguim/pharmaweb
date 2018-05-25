package com.pharmaweb.pharmaweb.service

import com.pharmaweb.pharmaweb.model.User
import com.pharmaweb.pharmaweb.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit private var repository: UserRepository

    fun getAll() = repository.findAll().toList()

    fun register(user: User) = repository.save(user)

    fun findById(userId: Long): ResponseEntity<User> {
        return repository.findById(userId).map { article ->
            ResponseEntity.ok(article)
        }.orElse(ResponseEntity.notFound().build())
    }

    fun alter(userId: Long, newUser: User): ResponseEntity<User> {
        return repository.findById(userId).map {
            val updatedUser: User = it.copy(fullName = newUser.fullName,
                                            email = newUser.email,
                                            address = newUser.address,
                                            phone = newUser.phone)

            ResponseEntity.ok().body(repository.save(updatedUser))
        }.orElse(ResponseEntity.notFound().build())
    }

    fun delete(userId: Long): ResponseEntity<Void> {
        return repository.findById(userId).map { article  ->
            repository.delete(article)

            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}
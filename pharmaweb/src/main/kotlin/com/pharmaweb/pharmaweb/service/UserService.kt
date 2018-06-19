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

    fun findById(userId: String): ResponseEntity<User> {
        return repository.findById(userId).map { user ->
            ResponseEntity.ok(user)
        }.orElse(ResponseEntity.notFound().build())
    }

    fun alter(userId: String, newUser: User): ResponseEntity<User> {
        return repository.findById(userId).map {
            val updatedUser: User = it.copy(fullName = newUser.fullName,
                                            email = newUser.email,
                                            address = if (newUser.address.isEmpty()) it.address else  newUser.address,
                                            phone = if (newUser.phone.isEmpty()) it.phone else  newUser.phone,
                                            registrationToken = if (newUser.registrationToken.isEmpty()) it.registrationToken else  newUser.registrationToken)

            ResponseEntity.ok().body(repository.save(updatedUser))
        }.orElse(ResponseEntity.notFound().build())
    }

    fun delete(userId: String): ResponseEntity<Void> {
        return repository.findById(userId).map { user  ->
            repository.delete(user)

            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}
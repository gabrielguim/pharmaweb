package com.pharmaweb.pharmaweb.service

import com.pharmaweb.pharmaweb.model.Druggist
import com.pharmaweb.pharmaweb.repository.DruggistRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class DruggistService() {

    @Autowired
    lateinit private var repository: DruggistRepository

    fun getAll() = repository.findAll().toList()

    fun register(druggist: Druggist) = repository.save(druggist)

    fun findById(druggistId: String): ResponseEntity<Druggist> {
        return repository.findById(druggistId).map { druggist ->
            ResponseEntity.ok(druggist)
        }.orElse(ResponseEntity.notFound().build())
    }

    fun alter(userId: String, newDruggist: Druggist): ResponseEntity<Druggist> {
        return repository.findById(userId).map {
            val updatedDruggist: Druggist = it.copy(fullName = newDruggist.fullName,
                                            email = newDruggist.email,
                                            crf = newDruggist.crf,
                                            registrationToken = if (newDruggist.registrationToken.isEmpty()) it.registrationToken else  newDruggist.registrationToken)

            ResponseEntity.ok().body(repository.save(updatedDruggist))
        }.orElse(ResponseEntity.notFound().build())
    }

    fun delete(druggistId: String): ResponseEntity<Void> {
        return repository.findById(druggistId).map { druggist  ->
            repository.delete(druggist)

            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}
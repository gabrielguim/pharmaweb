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

    fun findById(druggistId: Long): ResponseEntity<Druggist> {
        return repository.findById(druggistId).map { article ->
            ResponseEntity.ok(article)
        }.orElse(ResponseEntity.notFound().build())
    }

    fun alter(userId: Long, newDruggist: Druggist): ResponseEntity<Druggist> {
        return repository.findById(userId).map {
            val updatedDruggist: Druggist = it.copy(fullName = newDruggist.fullName,
                                            email = newDruggist.email,
                                            crf = newDruggist.crf)

            ResponseEntity.ok().body(repository.save(updatedDruggist))
        }.orElse(ResponseEntity.notFound().build())
    }

    fun delete(druggistId: Long): ResponseEntity<Void> {
        return repository.findById(druggistId).map { article  ->
            repository.delete(article)

            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}
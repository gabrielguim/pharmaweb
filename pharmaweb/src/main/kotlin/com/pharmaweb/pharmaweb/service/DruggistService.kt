package com.pharmaweb.pharmaweb.service

import com.google.firebase.messaging.FirebaseMessaging
import com.pharmaweb.pharmaweb.model.Druggist
import com.pharmaweb.pharmaweb.repository.DruggistRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DruggistService() {

    @Autowired
    lateinit private var repository: DruggistRepository

    fun getAll() = repository.findAll().toList()

    @Transactional
    fun register(druggist: Druggist) {
        repository.save(druggist)

        FirebaseMessaging.getInstance()
                .subscribeToTopic(listOf(druggist.registrationToken),
                            "/topics/prescriptions")
    }

    fun findById(druggistId: String): ResponseEntity<Druggist> {
        return repository.findById(druggistId).map { druggist ->
            ResponseEntity.ok(druggist)
        }.orElse(ResponseEntity.notFound().build())
    }

    @Transactional
    fun alter(druggistId: String, newDruggist: Druggist): ResponseEntity<Druggist> {
        return repository.findById(druggistId).map {
            val updatedDruggist: Druggist = it.copy(fullName = newDruggist.fullName,
                                            email = newDruggist.email,
                                            crf = newDruggist.crf,
                                            registrationToken = if (newDruggist.registrationToken.isEmpty()) it.registrationToken else newDruggist.registrationToken)

            FirebaseMessaging.getInstance()
                    .unsubscribeFromTopic(listOf(it.registrationToken),
                            "/topics/prescriptions")

            FirebaseMessaging.getInstance()
                    .unsubscribeFromTopic(listOf(updatedDruggist.registrationToken),
                            "/topics/prescriptions")

            ResponseEntity.ok().body(repository.save(updatedDruggist))
        }.orElse(ResponseEntity.notFound().build())
    }

    @Transactional
    fun delete(druggistId: String): ResponseEntity<Void> {
        return repository.findById(druggistId).map { druggist  ->
            repository.delete(druggist)

            FirebaseMessaging.getInstance()
                    .unsubscribeFromTopic(listOf(druggist.registrationToken),
                            "/topics/prescriptions")

            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}
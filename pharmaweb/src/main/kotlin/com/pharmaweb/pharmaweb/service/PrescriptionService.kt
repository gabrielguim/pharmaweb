package com.pharmaweb.pharmaweb.service

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.google.firebase.messaging.Notification
import com.pharmaweb.pharmaweb.model.Prescription
import com.pharmaweb.pharmaweb.repository.PrescriptionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PrescriptionService {

    @Autowired
    lateinit private var repository: PrescriptionRepository

    fun getAll() = repository.findAll().toList()

    @Transactional
    fun register(prescription: Prescription) {
        val mapper = jacksonObjectMapper()

        repository.save(prescription)

        val message = Message.builder()
                .setNotification(Notification("Pharmaweb - Nova Receita!", "Uma nova receita foi enviada para análise"))
                .putData("prescription", mapper.writeValueAsString(prescription))
                .setTopic("/topics/prescriptions") // send notification to a specific topic :)
                .build()

        // send notification
        FirebaseMessaging.getInstance().send(message)
    }

    fun findById(prescriptionId: String): ResponseEntity<Prescription> {
        return repository.findById(prescriptionId).map { prescription ->
            ResponseEntity.ok(prescription)
        }.orElse(ResponseEntity.notFound().build())
    }

    @Transactional
    fun alter(prescriptionId: String, newPrescription: Prescription): ResponseEntity<Prescription> {
        return repository.findById(prescriptionId).map {
            val updatedPrescription: Prescription = it.copy(status = newPrescription.status,
                                            date = newPrescription.date,
                                            imageUrl = newPrescription.imageUrl,
                                            customer = newPrescription.customer)

            val mapper = jacksonObjectMapper()

            val message = Message.builder()
                    .setNotification(Notification("Pharmaweb - Receita Avaliada!", "Verifique o resultado da avaliação da sua receita"))
                    .putData("prescription", mapper.writeValueAsString(updatedPrescription))
                    .setToken(updatedPrescription.customer.registrationToken)
                    .build()

            FirebaseMessaging.getInstance().send(message)

            ResponseEntity.ok().body(repository.save(updatedPrescription))
        }.orElse(ResponseEntity.notFound().build())
    }

    fun delete(prescriptionId: String): ResponseEntity<Void> {
        return repository.findById(prescriptionId).map { prescription  ->
            repository.delete(prescription)

            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}
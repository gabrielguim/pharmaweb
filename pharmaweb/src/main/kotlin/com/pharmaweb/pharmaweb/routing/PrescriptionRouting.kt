package com.pharmaweb.pharmaweb.routing

import com.pharmaweb.pharmaweb.model.Prescription
import com.pharmaweb.pharmaweb.service.PrescriptionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/prescriptions")
class PrescriptionRouting {

    @Autowired
    lateinit var prescriptionService: PrescriptionService

    @GetMapping
    fun getAll() = prescriptionService.getAll()

    @PostMapping
    fun register(@Valid @RequestBody prescription: Prescription) = prescriptionService.register(prescription)

    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") customerId: String) = prescriptionService.findById(customerId)

    @PutMapping("/{id}")
    fun alter(@PathVariable(value = "id") customerId: String,
              @Valid @RequestBody newPrescription: Prescription) = prescriptionService.alter(customerId, newPrescription)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value = "id") customerId: String) = prescriptionService.delete(customerId)

}
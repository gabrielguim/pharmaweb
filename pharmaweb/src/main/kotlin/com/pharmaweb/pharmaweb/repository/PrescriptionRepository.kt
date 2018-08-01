package com.pharmaweb.pharmaweb.repository

import com.pharmaweb.pharmaweb.model.Prescription
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PrescriptionRepository : CrudRepository<Prescription, String>

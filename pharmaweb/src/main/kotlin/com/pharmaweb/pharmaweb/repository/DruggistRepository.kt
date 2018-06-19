package com.pharmaweb.pharmaweb.repository

import com.pharmaweb.pharmaweb.model.Druggist
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DruggistRepository : JpaRepository<Druggist, String>

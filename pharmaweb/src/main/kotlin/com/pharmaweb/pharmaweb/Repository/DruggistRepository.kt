package com.pharmaweb.pharmaweb.repository

import com.pharmaweb.pharmaweb.model.Druggist
import org.springframework.data.jpa.repository.JpaRepository

interface DruggistRepository : JpaRepository<Druggist, Long>

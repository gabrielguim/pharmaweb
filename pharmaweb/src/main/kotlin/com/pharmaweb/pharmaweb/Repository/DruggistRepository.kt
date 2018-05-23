package com.pharmaweb.pharmaweb.Repository

import com.pharmaweb.pharmaweb.Model.Druggist
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DruggistRepository : ReactiveCrudRepository<Druggist, String>
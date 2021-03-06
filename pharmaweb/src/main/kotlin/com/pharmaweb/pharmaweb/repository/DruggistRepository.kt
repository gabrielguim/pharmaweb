package com.pharmaweb.pharmaweb.repository

import com.pharmaweb.pharmaweb.model.Druggist
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DruggistRepository : CrudRepository<Druggist, String>

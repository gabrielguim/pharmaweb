package com.pharmaweb.pharmaweb.repository

import com.pharmaweb.pharmaweb.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>

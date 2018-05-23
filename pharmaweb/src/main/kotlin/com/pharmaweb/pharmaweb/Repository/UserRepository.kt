package com.pharmaweb.pharmaweb.Repository

import com.pharmaweb.pharmaweb.Model.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : ReactiveCrudRepository<User, String>
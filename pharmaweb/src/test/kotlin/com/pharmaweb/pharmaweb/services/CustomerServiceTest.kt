package com.pharmaweb.pharmaweb.services

import com.pharmaweb.pharmaweb.PharmawebApplicationTests
import com.pharmaweb.pharmaweb.config.FirebaseConfiguration
import com.pharmaweb.pharmaweb.model.Customer
import com.pharmaweb.pharmaweb.repository.CustomerRepository
import com.pharmaweb.pharmaweb.service.CustomerService
import org.apache.http.HttpStatus
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired

class CustomerServiceTest : PharmawebApplicationTests() {

    @Autowired
    lateinit private var service: CustomerService

    @Autowired
    lateinit private var repository: CustomerRepository

    @Before
    fun beforeTest(){
        repository.deleteAll()
    }

    @Test
    fun getAllHavingNoCustomers() {
        Assert.assertTrue(service.getAll().isEmpty())
    }

    @Test
    fun getAllHavingOneCustomer() {
        service.register(Customer("uid1", "Nome 1", "email1@email.com", "registrationToken"))
        Assert.assertEquals(1, service.getAll().size)
    }

    @Test
    fun getAllHavingManyCustomers() {
        service.register(Customer("uid1", "Nome 1", "email1@email.com", "registrationToken1"))
        service.register(Customer("uid2", "Nome 2", "email2@email.com", "registrationToken2"))
        service.register(Customer("uid3", "Nome 3", "email3@email.com", "registrationToken3"))
        service.register(Customer("uid4", "Nome 4", "email4@email.com", "registrationToken4"))

        Assert.assertEquals(4, service.getAll().size)
    }

    @Test
    fun register() {
        service.register(Customer("uid1", "Nome 1", "email1@email.com", "registrationToken1"))
        Assert.assertEquals(1, service.getAll().size)
    }

    @Test
    fun findByIdHavingOne() {
        service.register(Customer("uid1", "Nome 1", "email1@email.com", "registrationToken1"))
        service.register(Customer("uid2", "Nome 2", "email2@email.com", "registrationToken2"))
        service.register(Customer("uid3", "Nome 3", "email3@email.com", "registrationToken3"))

        val logger = LoggerFactory.getLogger(CustomerServiceTest::class.java)
        logger.info("" + service.findById("uid1").statusCode)

        Assert.assertEquals(HttpStatus.SC_OK, service.findById("uid1").statusCodeValue)
    }

    @Test
    fun findByIdHavingNoOne() {
        service.register(Customer("uid1", "Nome 1", "email1@email.com", "registrationToken1"))
        service.register(Customer("uid2", "Nome 2", "email2@email.com", "registrationToken2"))
        service.register(Customer("uid3", "Nome 3", "email3@email.com", "registrationToken3"))

        Assert.assertEquals(HttpStatus.SC_NOT_FOUND, service.findById("uid5").statusCodeValue)
    }

    @Test
    fun alter() {
        service.register(Customer("uid1", "Nome 1", "email1@email.com", "registrationToken1"))

        Assert.assertTrue(service.findById("uid1").body!!.uid.equals("uid1"))

        service.alter("uid1", Customer("uid1", "Nome Teste 1", "emailteste1@email.com"))

        Assert.assertEquals("Nome Teste 1", service.findById("uid1").body!!.fullName)
    }

    @Test
    fun delete() {
        Assert.assertTrue(service.getAll().isEmpty())

        service.register(Customer("uid1", "Nome 1", "email1@email.com", "registrationToken1"))

        Assert.assertEquals(1, service.getAll().size)

        service.delete("uid1")

        Assert.assertTrue(service.getAll().isEmpty())
    }
}
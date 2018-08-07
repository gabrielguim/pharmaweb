package com.pharmaweb.pharmaweb.repositories

import com.pharmaweb.pharmaweb.PharmawebApplicationTests
import com.pharmaweb.pharmaweb.model.Product
import com.pharmaweb.pharmaweb.repository.ProductRepository
import com.pharmaweb.pharmaweb.services.CustomerServiceTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired

class ProductRepositoryTest: PharmawebApplicationTests() {

    @Autowired
    lateinit private var repository: ProductRepository

    @Before
    fun beforeTest() {
        repository.deleteAll()

        repository.save(Product("Codigo 1", "Produto 1", "Descricao 1", "imagem_url1.jpg", "Departamento 1", "Categoria 1", 0f))
        repository.save(Product("Codigo 2", "Produto 2", "Descricao 2", "imagem_url2.jpg", "Departamento 2", "Categoria 2", 0f))
        repository.save(Product("Codigo 3", "Produto 3", "Descricao 3", "imagem_url3.jpg", "Departamento 3", "Categoria 3", 0f))
        repository.save(Product("Codigo 4", "Produto 4", "Descricao 4", "imagem_url4.jpg", "Departamento 1", "Categoria 4", 0f))
        repository.save(Product("Codigo 5", "Produto 5", "Descricao 5", "imagem_url5.jpg", "Departamento 5", "Categoria 5", 0f))
    }

    @Test
    fun testSearchByTextHavingOne() {
        val result = repository.searchByText("produto 1")

        Assert.assertTrue(result.size == 1 &&
                            result.first().code.equals("Codigo 1"))
    }

    @Test
    fun testSearchByTextHavingMany() {
        val result = repository.searchByText("departamento 1")
        Assert.assertEquals(2, result.size)
    }

    @Test
    fun testSearchByTextHavingNoOne() {
        val result = repository.searchByText("Produto 8")
        Assert.assertTrue(result.isEmpty())
    }

}
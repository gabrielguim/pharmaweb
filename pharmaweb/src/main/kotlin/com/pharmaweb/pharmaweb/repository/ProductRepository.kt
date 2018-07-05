package com.pharmaweb.pharmaweb.repository

import com.pharmaweb.pharmaweb.model.Product
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : CrudRepository<Product, String> {

    @Query(nativeQuery = true, value = """
        SELECT *
        FROM product p
        WHERE lower(p.name) LIKE :text
           OR lower(p.category) LIKE :text
           OR lower(p.code) LIKE :text
           OR lower(p.department) LIKE :text
    """)
    fun searchByText(@Param("text") text: String): MutableList<Product>

}

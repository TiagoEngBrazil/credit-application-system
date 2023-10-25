package me.dio.creditapplicationsystem.Dto

import me.dio.creditapplicationsystem.entity.Customer
import java.math.BigDecimal
import java.math.BigInteger

data class CustomerUpdateDto(
    val firstName: String,
    val LasttName: String,
    val income: BigDecimal,
    val zipCode: String,
    val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.LasttName
        customer.income = this.income
        customer.adress.zipCode = this.zipCode
        customer.adress.street = this.street

        return customer
    }
}

package me.dio.creditapplicationsystem.Dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.creditapplicationsystem.entity.Customer
import java.math.BigDecimal
import java.math.BigInteger

data class CustomerUpdateDto(
    @field:NotEmpty(message = "invalid input") val firstName: String,
    @field:NotEmpty(message = "invalid input") val LasttName: String,
    @field:NotNull(message = "invalid input") val income: BigDecimal,
    @field:NotEmpty(message = "invalid input") val zipCode: String,
    @field:NotEmpty(message = "invalid input") val street: String
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
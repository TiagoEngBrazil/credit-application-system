package me.dio.creditapplicationsystem.Dto

import me.dio.creditapplicationsystem.entity.Customer
import java.math.BigDecimal

data class CustomerView(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val icome: BigDecimal,
    val email: String,
    val zipCode: String,
    val street: String,
) {

    constructor(customer: Customer): this (
        firstName = customer.firstName,
        lastName = customer.lastName,
        cpf = customer.cpf,
        icome = customer.income,
        email = customer.email,
        zipCode = customer.adress.zipCode,
        street = customer.adress.street
        )
}
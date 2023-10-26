package me.dio.creditapplicationsystem.Dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.creditapplicationsystem.entity.Address
import me.dio.creditapplicationsystem.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "invalid input") val firstName: String,
    @field:NotEmpty(message = "invalid input") val lastName: String,
    @field:CPF(message = "this invalid cpf") val cpf: String,
    @field:NotNull(message = "invalid input") val income: BigDecimal,
    @field:Email(message = "invalid email")
    @field:NotEmpty(message = "invalid input") val email: String,
    @field:NotEmpty(message = "invalid input") val password: String,
    @field:NotEmpty(message = "invalid input") val zipCode: String,
    @field:NotEmpty(message = "invalid input") val street: String
) {

    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        adress = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}

package me.dio.creditapplicationsystem.sevice

import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.entity.Customer
import java.util.UUID

interface IcreditService {
    fun save(credit: Credit): Credit
    fun  findAllByCustomer(customerId: Long): List<Credit>

    fun findCreditCode(customerId: Long, creditCode: UUID): Credit
}
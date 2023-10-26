package me.dio.creditapplicationsystem.sevice

import me.dio.creditapplicationsystem.entity.Credit
import java.util.UUID

interface IcreditService {
    fun save(credit: Credit): Credit
    fun  findAllByCustomer(customerId: Long): List<Credit>

    fun findByCreditCode(customerId: Long, creditCode: UUID): Credit
}
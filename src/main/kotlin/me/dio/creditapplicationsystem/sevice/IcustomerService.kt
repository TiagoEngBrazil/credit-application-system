package me.dio.creditapplicationsystem.sevice

import me.dio.creditapplicationsystem.entity.Customer

interface IcustomerService {
    fun save(customer: Customer): Customer

    fun findById(id: Long): Customer

    fun delete(id: Long)
}
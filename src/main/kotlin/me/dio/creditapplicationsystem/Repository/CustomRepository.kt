package me.dio.creditapplicationsystem.Repository

import me.dio.creditapplicationsystem.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomRepository: JpaRepository<Customer, Long> {
}
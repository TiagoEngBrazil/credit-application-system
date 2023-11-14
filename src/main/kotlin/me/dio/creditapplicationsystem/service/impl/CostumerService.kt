package me.dio.creditapplicationsystem.service.impl

import me.dio.creditapplicationsystem.Exception.BusinessException
import me.dio.creditapplicationsystem.entity.Customer
import me.dio.creditapplicationsystem.repository.CustomerRepository
import me.dio.creditapplicationsystem.service.IcustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository) : IcustomerService {
    override fun save(customer: Customer): Customer = this.customerRepository.save(customer)


    override fun findById(id: Long): Customer = this.customerRepository.findById(id).orElseThrow {
            throw BusinessException("Id $id not found")
        }


    override fun delete(id: Long){
        val customer: Customer = this.findById(id)
        this.customerRepository.delete(customer)
    }
}
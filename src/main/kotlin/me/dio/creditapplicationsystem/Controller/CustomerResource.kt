package me.dio.creditapplicationsystem.Controller

import me.dio.creditapplicationsystem.Dto.CustomerDto
import me.dio.creditapplicationsystem.Dto.CustomerView
import me.dio.creditapplicationsystem.Dto.CustomerUpdateDto
import me.dio.creditapplicationsystem.entity.Customer
import me.dio.creditapplicationsystem.sevice.impl.CustomerService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/customers")
class CustomerResource(
    private val customerService: CustomerService
) {

    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CustomerDto): String {
        val savedCostumer = this.customerService.save(customerDto.toEntity())

        return ("Customer ${savedCostumer.email} saved!")
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): CustomerView {
        val customer: Customer = this.customerService.findById(id)

        return CustomerView(customer)
    }

    @DeleteMapping
    fun deletecustomer(@PathVariable id: Long) = this.customerService.delete(id)

    @PatchMapping
    fun updateCustomer(
        @RequestParam(value = "customerId") id: Long,
        @RequestBody customerUpdateDto: CustomerUpdateDto
    ): CustomerView {

        val customer: Customer = this.customerService.findById(id)

        val custumerUdateDto: Customer = customerUpdateDto.toEntity(customer)
        val customerUpdated: Customer = this.customerService.save(customer)

        return CustomerView(customerUpdated)
    }
}
package me.dio.creditapplicationsystem.Controller

import me.dio.creditapplicationsystem.Dto.CreditDto
import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.sevice.impl.CreditService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/credits")
class CrediteResource(
    val creditService: CreditService
) {

    @PostMapping
    fun saveCredite(@RequestBody creditDto: CreditDto): String {
        val credit: Credit = this.creditService.save(creditDto.toEntity())
        return "Credit ${credit.creditCode} - Customer ${credit.customer?.firstName} saved!"
    }
}
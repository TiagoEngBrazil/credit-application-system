package me.dio.creditapplicationsystem.Controller

import me.dio.creditapplicationsystem.Dto.CreditDto
import me.dio.creditapplicationsystem.Dto.CreditView
import me.dio.creditapplicationsystem.Dto.CreditViewList
import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.sevice.impl.CreditService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CrediteResource(
    val creditService: CreditService
) {

    @PostMapping
    fun saveCredite(@RequestBody creditDto: CreditDto): ResponseEntity<String> {
        val credit: Credit = this.creditService.save(creditDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Credit ${credit.creditCode} - Customer ${credit.customer?.firstName} saved!")
    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long): ResponseEntity<List<CreditViewList>> {
        val creditViewList: List<CreditViewList> = this.creditService.findAllByCustomer(customerId).stream()
            .map { credit: Credit -> CreditViewList(credit) }
            .collect(Collectors.toList())

        return ResponseEntity.status(HttpStatus.OK).body(creditViewList)
    }

    @GetMapping("/creditCode")
    fun finByCreditCode(
        @RequestParam(value = "customerId") customerId: Long,
        @PathVariable creditCode: UUID
    ): ResponseEntity<CreditView> {
        val credit: Credit = this.creditService.findByCreditCode(customerId, creditCode)

        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
    }
}
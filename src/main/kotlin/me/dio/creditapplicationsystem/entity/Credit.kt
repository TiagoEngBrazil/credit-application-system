package me.dio.creditapplicationsystem.entity

import me.dio.creditapplicationsystem.enummeration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

data class Credit (
    val creditCode: UUID = UUID.randomUUID(),
    val crediteValue: BigDecimal = BigDecimal.ZERO,
    val dayFristInstallment: LocalDate,
    val numberOfInstallment: Int = 0,
    val status: Status = Status.IN_PROGRESS,
    val costumer: Costumer? = null,
    val id: Long? = null
    )

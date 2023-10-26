package me.dio.creditapplicationsystem.Exception

data class BusinessException(override val message: String?) : RuntimeException(message) {

}

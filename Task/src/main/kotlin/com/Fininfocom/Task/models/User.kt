package com.Fininfocom.Task.models

import javax.validation.constraints.PositiveOrZero
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

data class User(

    @field:NotNull(message = "ID is required")
    val id: Long = 0,

    @field:NotBlank(message = "Name is required")
    @field:Pattern(regexp = "^[a-zA-Z]+\$", message = "Name should only contain characters")
    var name: String? = null,

    @field:NotBlank(message = "Profession is required")
    @field:Pattern(regexp = "^[a-zA-Z]+\$", message = "Profession should only contain characters")
    var profession: String? = null,

    @field:PositiveOrZero(message = "Salary must be a non-negative number")
    var salaray: Double = 0.0
)
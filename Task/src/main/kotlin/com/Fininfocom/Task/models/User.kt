package com.Fininfocom.Task.models

import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.PositiveOrZero

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,

    @field:NotBlank(message = "Name is required")
    @field:Pattern(regexp = "^[a-zA-Z]+\$", message = "Name should only contain characters")
    @Column(name = "name")
    var name: String? = null,

    @field:NotBlank(message = "Profession is required")
    @field:Pattern(regexp = "^[a-zA-Z]+\$", message = "Profession should only contain characters")
    @Column(name = "profession")
    var profession: String? = null,

    @field:PositiveOrZero(message = "Salary must be a non-negative number")
    @Column(name = "salary")
    var salary: Double = 0.0
)
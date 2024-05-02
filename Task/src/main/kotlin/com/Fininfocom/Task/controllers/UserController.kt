package com.Fininfocom.Task.controllers

import com.Fininfocom.Task.responseHandling.models.Response
import com.Fininfocom.Task.models.User
import com.Fininfocom.Task.services.UserServices
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("api/users")
class UserController(val userServices: UserServices) {

    @GetMapping
    fun getAllUsers(): List<User> = userServices.getAllUsers()

    @GetMapping("/{id}")
    fun userById(@PathVariable id: Long): User = userServices.userById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveUser(@Valid @RequestBody user: User): Response<User> = userServices.saveUser(user)

    @PutMapping("/{id}")
    fun updateUser(@Valid @PathVariable id: Long ,@RequestBody user: User): Response<User> = userServices.updateUser(id,user)

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): Response<User> = userServices.deleteUser(id)
 }
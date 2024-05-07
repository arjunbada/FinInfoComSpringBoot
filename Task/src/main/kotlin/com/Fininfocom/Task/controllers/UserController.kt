package com.Fininfocom.Task.controllers

import com.Fininfocom.Task.models.User
import com.Fininfocom.Task.responseHandling.models.Response
import com.Fininfocom.Task.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("api/users")
class UserController(val userServices: UserService) {

    @GetMapping
    fun getAllUsers(): List<User> = userServices.getAllUsers()

    @GetMapping("/id/{id}")
    fun getUserById(@PathVariable id: Long): User = userServices.getUserById(id)

    @GetMapping("/salary/{salary}")
    fun getUsersBySalary(@PathVariable salary: Double): List<User> = userServices.getUsersBySalary(salary)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveUser(@Valid @RequestBody user: User): Response<User> = userServices.saveUser(user)

    @PutMapping("/{id}")
    fun updateUser(@Valid @PathVariable id: Long ,@RequestBody user: User): Response<User> = userServices.updateUser(id,user)

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): Response<User> = userServices.deleteUser(id)
 }
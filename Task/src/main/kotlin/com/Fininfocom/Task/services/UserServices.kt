package com.Fininfocom.Task.services

import com.Fininfocom.Task.models.User
import com.Fininfocom.Task.repository.UserRepository
import com.Fininfocom.Task.responseHandling.ValidationException
import com.Fininfocom.Task.responseHandling.models.Response
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(private val userRepository: UserRepository) {

    @Transactional
    fun getAllUsers(): List<User> = userRepository.findAll()

    @Transactional
    fun getUserById(id: Long): User = userRepository.findById(id)
        .orElseThrow { ValidationException("User with ID $id not found") }

    @Transactional
    fun getUsersBySalary(salary: Double):List<User> {
        if (salary < 0){
            throw ValidationException("amount $salary should not be negative")
        }
        return userRepository.getUsersBySalary(salary)
    }

    @Transactional
    fun saveUser(user: User): Response<User> {
        val savedUser = userRepository.save(user)
        return Response(true, "Inserted Successfully", savedUser)
    }

    @Transactional
    fun updateUser(id: Long, updatedUser: User): Response<User> {
        if (!userRepository.existsById(id)) {
            throw ValidationException("User with ID $id not found")
        }
        updatedUser.id = id
        val modifiedUser = userRepository.save(updatedUser)
        return Response(true, "Updated Successfully", modifiedUser)

    }

    @Transactional
    fun deleteUser(id: Long):Response<User> {
        if (!userRepository.existsById(id)) {
            throw ValidationException("User with ID $id not found")
        }
        userRepository.deleteById(id)
        return Response(true, "user $id deleted Successfully")
    }
}




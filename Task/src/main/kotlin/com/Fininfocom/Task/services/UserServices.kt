package com.Fininfocom.Task.services

import com.Fininfocom.Task.responseHandling.models.Response
import com.Fininfocom.Task.responseHandling.ValidationException
import com.Fininfocom.Task.models.User
import com.Fininfocom.Task.repository.mockData.UserMock
import org.springframework.stereotype.Service

@Service
class UserServices(val userMock: UserMock) {

    fun getAllUsers(): List<User> {
        return userMock.getAllUsers()
    }

    fun userById(empId: Long): User {
        return userMock.userById(empId)
    }

    fun saveUser(user: User): Response<User> {
        if (userMock.getAllUsers().any { it.id == user.id }) {
            throw ValidationException("User with ID ${user.id} already exists")
        }
        return userMock.saveUser(user)
    }

    fun updateUser(empId: Long,user: User):Response<User>{
        userMock.getAllUsers().find { it.id == empId } ?: throw ValidationException("User with ID ${empId} not exists")
        return userMock.updateUser(empId,user)
    }

    fun deleteUser(empId: Long):Response<User>{
        userMock.getAllUsers().find { it.id == empId } ?: throw ValidationException("User with ID ${empId} not exists")
        return userMock.deleteUser(empId)
    }
}

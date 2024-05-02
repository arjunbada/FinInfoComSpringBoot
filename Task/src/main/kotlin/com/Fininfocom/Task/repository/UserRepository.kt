package com.Fininfocom.Task.repository

import com.Fininfocom.Task.responseHandling.models.Response
import com.Fininfocom.Task.models.User

interface UserRepository  {

    fun getAllUsers():List<User>

    fun userById(empId:Long):User

    fun saveUser(user: User): Response<User>

    fun updateUser(empId:Long, user: User): Response<User>

    fun deleteUser(empId: Long): Response<User>
}
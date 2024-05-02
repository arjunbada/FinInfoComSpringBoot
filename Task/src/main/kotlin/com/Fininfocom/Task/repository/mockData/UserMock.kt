package com.Fininfocom.Task.repository.mockData

import com.Fininfocom.Task.responseHandling.models.Response
import com.Fininfocom.Task.models.User
import com.Fininfocom.Task.repository.UserRepository
import org.springframework.stereotype.Repository

@Repository
class UserMock : UserRepository {
    var users = mutableListOf(
        User(1, "Arjun", "Junior Software Engineer", 36275.00),
        User(2, "Bharath", "Teacher", 6275.50),
        User(3, "Hemanth", "Police constable", 33500.50)
    )

    override fun getAllUsers(): List<User> {
        return users
    }

    override fun userById(empId: Long): User {
        return users.find { user -> empId == user.id } ?: throw NoSuchElementException("User with ID $empId not found")
    }

    override fun saveUser(user: User): Response<User> {
        users.add(user)
        return Response(true, "Data Successfully Added", user)
    }

    override fun updateUser(empId: Long, user: User): Response<User> {
        users[empId.toInt() -1] = user
        return Response(true, "Data Successfully Updated", user)
    }

    override fun deleteUser(empId: Long): Response<User> {
        users.removeAt(empId.toInt() -1)
        return Response(true, "Data Successfully Deleted",)
    }
}

package com.Fininfocom.Task.repository

import com.Fininfocom.Task.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.salary > :salary ORDER BY u.id ASC")
    fun getUsersBySalary(salary: Double): List<User>

}
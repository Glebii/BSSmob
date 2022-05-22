package DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun registerUser(user: User)


    @Update
    fun updateUserInfo(user: User)


//    @Query("SELECT * FROM users WHERE email LIKE :email AND password LIKE :password")
//    suspend fun login(email : String , password : String)


}
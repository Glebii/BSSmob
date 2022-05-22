package DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun registerUser(user: User)

    @Query("SELECT * FROM users ORDER BY id ASC")
    fun getAllUsers(): LiveData<List<User>>

    @Update
    fun updateUserInfo(user: User)




}
package Repository

import DAO.UserDao
import androidx.lifecycle.LiveData
import model.User

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.getAllUsers()

    suspend fun addUser(user: User){
        userDao.registerUser(user)
    }

}
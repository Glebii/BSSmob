package Repository

import DAO.UserDao
import android.content.Context
import androidx.lifecycle.LiveData
import model.User

class UserRepository(private val userDao: UserDao) {




    suspend fun addUser(user: User){
        userDao.registerUser(user)
    }
//
//    suspend fun getLoginDetails(email:String, password:String){
//            userDao.login(email,password)
//    }


}
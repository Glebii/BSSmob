package Database

import DAO.UserDao
import Repository.UserRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import model.User

class UserViewModel(application: Application):AndroidViewModel(application) {


    private val repository:UserRepository
    init {
        val userDao = AppDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)

    }
    fun addUser(user: User){
        viewModelScope.launch (Dispatchers.IO){
            repository.addUser(user)
        }
    }
//    fun loginUser(email : String , password : String){
//        viewModelScope.launch (Dispatchers.IO){
//            repository.getLoginDetails(email , password)
//        }
//    }
}

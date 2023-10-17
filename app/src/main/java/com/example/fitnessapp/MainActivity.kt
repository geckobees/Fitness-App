package com.example.fitnessapp

import android.app.Application
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.SimpleAdapter.ViewBinder
import androidx.activity.ComponentActivity
import androidx.fragment.app.FragmentController
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import kotlinx.coroutines.selects.select


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)





    }
}


@Entity
data class User(
    @PrimaryKey val uuid: Int,
    @ColumnInfo(name = "user_name") val username: String?,
    @ColumnInfo(name = "password") val password: String?

)
@Dao
interface UserAccess {
    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM user")
    fun search(user : User)
}
@Database(entities = [User :: class], version = 1)
abstract class AppDB : RoomDatabase() {
    abstract fun userDao(): UserAccess
}




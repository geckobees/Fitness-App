package com.example.fitnessapp

import android.app.Application
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import com.example.fitnessapp.ui.theme.FitnessAppTheme
import kotlinx.coroutines.selects.select


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        val button = findViewById<Button>(R.id.button_id)
        val username = findViewById<EditText>(R.id.username)
        val signup = findViewById<Button>(R.id.signup)

        signup.setOnClickListener(){

        }
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




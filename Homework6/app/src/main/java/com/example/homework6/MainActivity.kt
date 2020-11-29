package com.example.homework6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.homework6.database.AppDatabase
import com.example.homework6.database.Car
import com.example.homework6.database.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val insertButton = findViewById<Button>(R.id.insertData)
        val getCarsButton = findViewById<Button>(R.id.getOwnersCars)
        val deleteButton = findViewById<Button>(R.id.deleteData)

//        insertButton.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                AppDatabase.getDatabase(this@MainActivity).userDao().insertAll(
                    User(1, "Marcus", "Rashford"),
                    User(2, "Bruno", "Fernandes")
                )
//            }

            GlobalScope.launch(Dispatchers.IO) {
                AppDatabase.getDatabase(this@MainActivity).carDao().insertAll(
                    Car(1, 1 ,"BMW", "M5"),
                    Car(2, 1, "BMW", "M3"),
                    Car(3, 2,"Mitsubishi", "pajero"),
                    Car(4, 1, "Toyota", "camry"),
                    Car(5, 2, "Toyota", "prius"),
                    Car(6, 1, "Hyundai", "sonata"),
                    Car(7, 2, "Nissan", "skyline")
                )
            }

            GlobalScope.launch(Dispatchers.IO) {
                print(AppDatabase.getDatabase(this@MainActivity).userDao().getAll())
            }
        }
        getCarsButton.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                AppDatabase.getDatabase(this@MainActivity).userDao().getUsersWithCars()
            }
        }
        deleteButton.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                AppDatabase.getDatabase(this@MainActivity).userDao().deleteData()
                AppDatabase.getDatabase(this@MainActivity).carDao().deleteData()
            }
        }
    }
}
package com.example.homework7

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    private lateinit var btRun1: Button
    private lateinit var btRun2: Button
    private lateinit var btStop: Button
    private lateinit var firstJob: Job
    private lateinit var secondJob: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btRun1 = findViewById(R.id.btRun1)
        btRun2 = findViewById(R.id.btRun2)
        btStop = findViewById(R.id.btStop)

        btRun1.setOnClickListener {
            firstJob = coroutineScope.launch {
                btRun1.isEnabled = false
                val count = executeFirstJob()
                Toast.makeText(this@MainActivity, " First job Finished: $count", Toast.LENGTH_SHORT).show()
                btRun1.isEnabled = true
            }
        }

        btRun2.setOnClickListener {
            secondJob = coroutineScope.launch {
                btRun2.isEnabled = false
                val count = executeSecondJob()
                Toast.makeText(this@MainActivity, "Second job Finished: $count", Toast.LENGTH_SHORT).show()
                btRun2.isEnabled = true
            }
        }

        btStop.setOnClickListener {
            if (this::firstJob.isInitialized) {
                firstJob.cancel()
            }
            if (this::secondJob.isInitialized) {
                secondJob.cancel()
            }
        }
    }

    private suspend fun executeFirstJob(): Long {
        return withContext(Dispatchers.Default) {
            Log.d(TAG, "first job is starting")

            val max = 3 * 1000000

            var iterationsCount: Long = 0
            for (i in 1..max) {
                if (!this.isActive) {
                    Log.d(TAG, "First Job is not active anymore")
                    break
                }
                iterationsCount++
            }
            Log.d(TAG, "First Job completed with iteration $iterationsCount")

            iterationsCount
        }
    }

    private suspend fun executeSecondJob(): Long {
        return withContext(Dispatchers.Default) {
            Log.d(TAG, "Second job is starting")

            val max = 3 * 1000000

            var iterationsCount: Long = 0
            for (i in 1..max) {
                if (!this.isActive) {
                    Log.d(TAG, "Second job is not active anymore")
                    break
                }
                iterationsCount++
            }
            Log.d(TAG, " Second job completed with iteration $iterationsCount")

            iterationsCount
        }
    }

    override fun onStop() {
        super.onStop()
        if (this::firstJob.isInitialized) {
            firstJob.cancel()
        }
        if (this::secondJob.isInitialized) {
            secondJob.cancel()
        }
    }


    companion object {
        const val TAG = "MainActvity"
    }
}
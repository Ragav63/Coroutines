package com.example.coroutineskotlin

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.coroutineskotlin.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var counter:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.countBtn.setOnClickListener {
            binding.countNumber.text = counter++.toString()
        }


        binding.downloadBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                for (i in 1..1000000){
                    Log.i("TAG","Downloading $i in ${Thread.currentThread().name}")
                }
            }

        }
    }
}
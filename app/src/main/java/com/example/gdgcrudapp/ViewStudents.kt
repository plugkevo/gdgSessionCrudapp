package com.example.gdgcrudapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gdgcrudapp.databinding.ActivityMainBinding
import com.example.gdgcrudapp.databinding.ActivityViewStudentsBinding

class ViewStudents : AppCompatActivity() {

    private lateinit var binding: ActivityViewStudentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityViewStudentsBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}
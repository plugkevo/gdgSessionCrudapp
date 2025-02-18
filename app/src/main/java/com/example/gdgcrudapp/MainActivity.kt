package com.example.gdgcrudapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gdgcrudapp.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firestore
        firestore = FirebaseFirestore.getInstance()

        binding.btnSubmit.setOnClickListener {
            submitStudentData()
        }
    }

    private fun submitStudentData() {
        val fullName = binding.etFName.text.toString().trim()
        val phoneNo = binding.etPhoneNo.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val regNo = binding.etRegNo.text.toString().trim()

        if (fullName.isEmpty() || phoneNo.isEmpty() || email.isEmpty() || regNo.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val studentData = hashMapOf(
            "fullName" to fullName,
            "phoneNo" to phoneNo,
            "email" to email,
            "regNo" to regNo
        )

        firestore.collection("students")
            .add(studentData)
            .addOnSuccessListener {
                Toast.makeText(this, "Student registered successfully!", Toast.LENGTH_SHORT).show()
                clearInputFields()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
    }

    private fun clearInputFields() {
        binding.etFName.text.clear()
        binding.etPhoneNo.text.clear()
        binding.etEmail.text.clear()
        binding.etRegNo.text.clear()
    }
}

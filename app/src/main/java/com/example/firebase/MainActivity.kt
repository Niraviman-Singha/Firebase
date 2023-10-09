package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebase.databinding.ActivityMainBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.registerBtn.setOnClickListener {
            if (binding.emailET.text.toString() == "" || binding.passwordET.text.toString() ==""){

                Toast.makeText(this@MainActivity,"Please enter all the information",Toast.LENGTH_SHORT).show()
            }
            else{
                Firebase.auth.createUserWithEmailAndPassword(binding.emailET.text.toString(), binding.passwordET.text.toString()).addOnCompleteListener {
                    if(it.isSuccessful){
                        binding.emailET.text?.clear()
                        binding.passwordET.text?.clear()
                        Toast.makeText(this@MainActivity,"User Registered",Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(this@MainActivity,it.exception?.localizedMessage,Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }
}
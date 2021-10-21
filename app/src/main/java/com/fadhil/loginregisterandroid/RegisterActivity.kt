package com.fadhil.loginregisterandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.fadhil.loginregisterandroid.databinding.ActivityMainBinding
import com.fadhil.loginregisterandroid.databinding.ActivityRegisterBinding
import com.fadhil.loginregisterandroid.model.ResponseRegister
import com.fadhil.loginregisterandroid.network.ConfigNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    var binding : ActivityRegisterBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.button?.setOnClickListener {

            val name = binding?.editTextTextPersonName?.text.toString()
            val email = binding?.editTextTextEmailAddress?.text.toString()
            val phone = binding?.editTextNumber?.text.toString()
            val password = binding?.editTextTextPassword?.text.toString()
            val school = binding?.editTextTextPersonName2?.text.toString()

            ConfigNetwork().configRetrofit().register(name,email,password,school,phone)

                .enqueue(object : Callback<ResponseRegister> {
                    override fun onResponse(
                        call: Call<ResponseRegister>,
                        response: Response<ResponseRegister>
                    ) {
                        val success = response.body()?.isSuccess

                        if(success == true ){
                            Toast.makeText(this@RegisterActivity, response.body()?.message, Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@RegisterActivity, response.body()?.message, Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
                        Toast.makeText(this@RegisterActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }
}
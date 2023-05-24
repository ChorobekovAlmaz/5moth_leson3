package com.example.a5moth_leson3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.PixelCopy.request
import com.example.a5moth_leson3.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var adapter = PixaAdapter(arrayListOf())
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        inUitCliker()
    }

    private fun inUitCliker() {
        with(binding) {
            changePandeBtn.setOnClickListener() {
                ++page
                request()

            }
            okBtn.setOnClickListener {
                page = 1
                adapter.list.clear()
                request()
            }
        }
    }

    private fun ActivityMainBinding.request() {
        RetrofitServices().api.searchImage(keyWord.text.toString(), page = page)
            .enqueue(object : Callback<PixabayModel> {
                override fun onResponse(
                    call: Call<PixabayModel>,
                    response: Response<PixabayModel>
                ) {
                    if (response.isSuccessful) {
                        adapter.list.addAll(response.body()?.hits!!)
                        imageRecycel.adapter = adapter

                        Log.e("ololo", "onResponse: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<PixabayModel>, t: Throwable) {
                    Log.e("ololo", "onFailure: ${t.message}")

                }

            })
    }
}
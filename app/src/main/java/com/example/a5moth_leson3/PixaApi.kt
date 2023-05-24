package com.example.a5moth_leson3

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface PixaApi {

    @GET("api/")
    fun searchImage(
        @Query("q") keyWord: String,
        @Query("page") page: Int = 1,
        @Query("per_page") per_page: Int = 3,
        @Query("key") key: String = "36715023-fa962ccaefe4158e4fc90e1ff",
    ): Call<PixabayModel>
}
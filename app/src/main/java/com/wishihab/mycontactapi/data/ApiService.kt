package com.wishihab.mycontactapi.data

import com.wishihab.mycontactapi.model.RandomUser
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/api")
    fun getRandomUser(@Query("results")quantity:Int = 1):retrofit2.Call<RandomUser>
}
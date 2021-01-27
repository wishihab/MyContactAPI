package com.wishihab.mycontactapi.repo

import android.util.Log
import com.wishihab.mycontactapi.data.ApiService
import com.wishihab.mycontactapi.model.RandomUser
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object RandomUserRepo {
    private val randomUserService:ApiService

    init{
        val retrofit = Retrofit.Builder().baseUrl("https://randomuser.me")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()

        randomUserService = retrofit.create(ApiService::class.java)
    }

    fun getRandomUsers(quantity:Int=1): RandomUser? {

        var randomUsers:RandomUser? = null

        if(quantity>=1){
            val call = randomUserService.getRandomUser(quantity)
            val response = call.execute()
            randomUsers = response.body()

        }else{
            Log.e(RandomUserRepo::class.qualifiedName,"[ERROR] the quantity parameter must be 1 or more")
        }

        return randomUsers

    }

}
package com.wishihab.mycontactapi.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wishihab.mycontactapi.R
import com.wishihab.mycontactapi.model.RandomUserAdapter
import com.wishihab.mycontactapi.repo.RandomUserRepo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddContact: AppCompatActivity() {


    private lateinit var userList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setTitle("Add Contact")

        val randomUserAdapter = RandomUserAdapter(null)
        val viewLayout = LinearLayoutManager(this)

        userList = findViewById<RecyclerView>(R.id.recycleListadd).apply {
            layoutManager = viewLayout
            adapter = randomUserAdapter
        }

    }

    override fun onStart() {
        super.onStart()
        GlobalScope.launch {
            var randomUser = RandomUserRepo.getRandomUsers(5)
            var adapter = userList.adapter as RandomUserAdapter

            if(adapter.randomUser == null){
                adapter.randomUser = randomUser
            }else{
                adapter?.randomUser?.results?.addAll(randomUser?.results?.toMutableList()!!)
            }

            val handler = Handler(Looper.getMainLooper())
            handler.post{
                adapter.notifyDataSetChanged()
            }
        }

    }

}
package com.wishihab.mycontactapi.model

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT
import com.squareup.picasso.Picasso
import com.wishihab.mycontactapi.R
import com.wishihab.mycontactapi.view.MainActivity

class RandomUserAdapter(var randomUser:RandomUser?): RecyclerView.Adapter<RandomUserAdapter.RandomUserViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomUserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user_layout,parent,false)
        return RandomUserViewHolder(view)
    }

    @SuppressLint("ShowToast")
    override fun onBindViewHolder(holder: RandomUserViewHolder, position: Int) {
        val user = randomUser?.results?.get(position)

        holder.userName.text = "${user?.name?.tittle} ${user?.name?.first} ${user?.name?.last}"
        holder.userEmail.text = user?.email
        holder.userPhone.text = user?.phone
        holder.userCell.text = user?.nationality
        Picasso.get().load(user?.picture?.large).into(holder.userAvatar);

        holder.userAvatar.setOnClickListener {
            MainActivity().addList(randomUser, position)

        }


    }

    override fun getItemCount(): Int {
        return randomUser?.results?.size ?: 0
    }

    class RandomUserViewHolder(view: View): RecyclerView.ViewHolder(view){
        val userAvatar: ImageView = view.findViewById(R.id.item_imageview_user_avatar)
        val userName: TextView = view.findViewById(R.id.item_textview_user_name)
        val userPhone: TextView = view.findViewById(R.id.item_textview_user_phone)
        val userCell: TextView = view.findViewById(R.id.item_textview_user_cell)
        val userEmail: TextView = view.findViewById(R.id.item_textview_user_email)


    }


}
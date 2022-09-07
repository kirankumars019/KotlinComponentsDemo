package com.mrk.kotlincomponentsdemo.mvvm_repository.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mrk.kotlincomponentsdemo.databinding.AdapterMvvmWithRepositoryBinding
import com.mrk.kotlincomponentsdemo.retrofit.model.UserModel

class MVVMWithRepositoryAdapter: RecyclerView.Adapter<MVVMWithRepositoryAdapter.MyViewHolder>() {

    var users = mutableListOf<UserModel.Data>()
    lateinit var context :Context

    fun setMovieList(users: List<UserModel.Data>){
        this.users =users.toMutableList()
        notifyDataSetChanged()
    }

    class MyViewHolder(val binding: AdapterMvvmWithRepositoryBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        context = parent.context
        val binding = AdapterMvvmWithRepositoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val movie = users[position]
        holder.binding.name.text = movie.first_name.toString()
        
        Glide.with(context)
            .load(movie?.avatar)
            .into(holder.binding.imageview);
    }

    override fun getItemCount(): Int = users.size
}
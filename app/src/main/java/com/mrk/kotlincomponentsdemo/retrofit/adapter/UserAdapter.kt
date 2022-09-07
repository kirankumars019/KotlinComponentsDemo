package com.mrk.kotlincomponentsdemo.retrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mrk.kotlincomponentsdemo.databinding.ActivityApiCallBinding
import com.mrk.kotlincomponentsdemo.databinding.AdapterRetrofitUserBinding
import com.mrk.kotlincomponentsdemo.retrofit.model.UserModel

class UserAdapter(val userModel: UserModel?, val articleArrayList: ArrayList<UserModel>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(val binding: AdapterRetrofitUserBinding) :
        RecyclerView.ViewHolder(binding.root)

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            AdapterRetrofitUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = userModel?.data?.get(position)

        item?.let {
            holder.binding.name.text = it?.first_name

            Glide.with(context)
                .load(it?.avatar)
                .into(holder.binding.imageview);
        }
    }

    override fun getItemCount(): Int = userModel?.data?.size?: 0
}
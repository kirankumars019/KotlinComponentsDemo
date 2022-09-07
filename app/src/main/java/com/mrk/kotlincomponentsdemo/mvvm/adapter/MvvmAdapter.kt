package com.mrk.kotlincomponentsdemo.mvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mrk.kotlincomponentsdemo.databinding.AdapterMvvmBinding
import com.mrk.kotlincomponentsdemo.databinding.FragmentMvvmBinding
import com.mrk.kotlincomponentsdemo.retrofit.model.UserModel

class MvvmAdapter(private val model: List<UserModel.Data>?) : RecyclerView.Adapter<MvvmAdapter.ViewHolder>() {

    private lateinit var context: Context
    private lateinit var binding: AdapterMvvmBinding

    class ViewHolder(val binding: AdapterMvvmBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        binding = AdapterMvvmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = model?.get(position)

        binding.name.text = item?.first_name

        Glide.with(context)
            .load(item?.avatar)
            .into(binding.imageview)
    }

    override fun getItemCount(): Int = model?.size ?: 0

}
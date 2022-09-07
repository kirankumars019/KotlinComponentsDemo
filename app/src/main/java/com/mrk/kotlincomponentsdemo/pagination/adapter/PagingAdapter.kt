package com.mrk.kotlincomponentsdemo.pagination.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mrk.kotlincomponentsdemo.databinding.AdapterPaginationBinding
import com.mrk.kotlincomponentsdemo.mvvm_repository.adapter.MVVMWithRepositoryAdapter
import com.mrk.kotlincomponentsdemo.pagination.model.ContentModule
import com.mrk.kotlincomponentsdemo.retrofit.model.UserModel

class PagingAdapter: PagingDataAdapter<ContentModule, PagingAdapter.ViewHolder>(CALLBACk) {

    private lateinit var binding: AdapterPaginationBinding
    private  var TAG = "PagingAdapter"
    private lateinit var context: Context
    companion object{
        var item = 1
    }

    init {
        Log.e(TAG, "PagingAdapter called: ", )
    }

    class ViewHolder( val binding: AdapterPaginationBinding): RecyclerView.ViewHolder(binding.root)

    object CALLBACk: DiffUtil.ItemCallback<ContentModule>(){
        override fun areItemsTheSame(oldItem: ContentModule, newItem: ContentModule): Boolean {
           return oldItem.cloudinaryImagePublicId == newItem.cloudinaryImagePublicId
        }

        override fun areContentsTheSame(oldItem: ContentModule, newItem: ContentModule): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        Log.e(TAG, "onCreateViewHolder called: ", )
        context = parent.context
        val binding = AdapterPaginationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.e(TAG, "onBindViewHolder called: ", )

        getItem(position)?.let {

            Log.e(TAG, "onBindViewHolder getPagingData $it", )
            holder.binding.name.text = it.name + item
            item++

            val baseUrl =
                "https://res.cloudinary.com/mrktestcloud/image/upload/c_fit,h_640,q_auto,w_640/v1/"

            Glide.with(context)
                .load(baseUrl+it.cloudinaryImagePublicId)
                .into(holder.binding.imageview)
        }
    }




}
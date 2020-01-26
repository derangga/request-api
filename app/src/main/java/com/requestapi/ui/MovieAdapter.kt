package com.requestapi.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.requestapi.R
import com.requestapi.model.Movies
import com.requestapi.network.ApiUrl
import kotlinx.android.synthetic.main.adapter_main.view.*

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var userList: List<Movies> = emptyList()
    private lateinit var context: Context

    fun setDataList(userList: List<Movies>){
        this.userList = userList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_main, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(userList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItem(data: Movies){
            val url = "${ApiUrl.IMG_POSTER}${data.posterPath}"
            Glide.with(context)
                .load(url)
                .error(R.drawable.no_image)
                .into(itemView.poster_img)

            itemView.poster_title.text = data.title
            itemView.poster_rate.text = data.voteAverage.toString()
        }
    }
}
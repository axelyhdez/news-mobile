package com.example.news_mobile.Data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.news_mobile.Model.NewsModel
import com.example.news_mobile.R
import com.squareup.picasso.Picasso


class NewsAdapter (val News:List<NewsModel>): RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    //Holder
    class NewsHolder(val view: View):RecyclerView.ViewHolder(view){
        fun render(News:NewsModel){
            view.findViewById<TextView>(R.id.TituloNews).text=News.title
            view.findViewById<TextView>(R.id.DescripcionNews).text=News.description
            Picasso.get().load(News.urlToImage).into(view.findViewById<ImageView>(R.id.ImageNew))
        }
    }

    //Metodos Adapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NewsHolder(layoutInflater.inflate(R.layout.item_new,parent,false))
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.render(News[position])
    }


    override fun getItemCount(): Int {
        return News.size
    }

}
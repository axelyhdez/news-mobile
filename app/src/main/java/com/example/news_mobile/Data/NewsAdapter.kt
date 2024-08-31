package com.example.news_mobile.Data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.news_mobile.Model.Articles
import com.example.news_mobile.Model.NewsModel
import com.example.news_mobile.R
import com.squareup.picasso.Picasso


class NewsAdapter (val News:List<Articles>): RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    //Holder
    class NewsHolder(val view: View):RecyclerView.ViewHolder(view){
        fun render(News:Articles){
            view.findViewById<TextView>(R.id.TituloNews).text=News.title
            view.findViewById<TextView>(R.id.DescripcionNews).text=News.description
            if (News.urlToImage!=""){
                Picasso.get().load(News.urlToImage).into(view.findViewById<ImageView>(R.id.ImageNew))
            }else{
                val imageEmpty="https://s2.qwant.com/thumbr/474x424/6/8/18cd9a79802ca646f4964469235aa1df1f04be90d9ae37a213133ba3397fc6/th.jpg?u=https%3A%2F%2Ftse.mm.bing.net%2Fth%3Fid%3DOIP.NwiZS9yjjNjb6lCfIz889AHaGo%26pid%3DApi&q=0&b=1&p=0&a=0"
                Picasso.get().load(imageEmpty).into(view.findViewById<ImageView>(R.id.ImageNew))
            }
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
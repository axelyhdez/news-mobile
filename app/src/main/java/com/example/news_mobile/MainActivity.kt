package com.example.news_mobile

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.news_mobile.Data.NewsAdapter
import com.example.news_mobile.Data.RetrofitServiceFactory
import com.example.news_mobile.Model.Articles
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    var news: List<Articles> = listOf(
        Articles("Paralympics 2024: What you need to know about classification",
            "How each of the 22 sports are classified at the Paris Paralympics.",
            "https://ichef.bbci.co.uk/news/1024/branded_sport/a96e/live/9f2f4930-6093-11ef-8c32-f3c2bc7494c6.jpg"
        ),
        Articles("Are these sports in the Olympics, Paralympics or both?",
            "Test your knowledge on how well you know the sports featured in the Paralympics and Olympics.",
            "https://ichef.bbci.co.uk/news/1024/branded_sport/6ac9/live/117d9b70-61a4-11ef-8c32-f3c2bc7494c6.jpg"),
        Articles("King appoints composer as Master of his music",
            "She is best known for her work on the 2012 Paralympics, " +
                    "the Proms and the COP26 summit.",
            "https://ichef.bbci.co.uk/news/1024/branded_news/eeb0/live/bdf0a860-6286-11ef-8c32-f3c2bc7494c6.jpg")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        Thread.sleep(2000)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val service = RetrofitServiceFactory.getNewsRetro()

        lifecycleScope.launch {
            val newsApi = service.getNews()
            val datos=newsApi.articles
            if (datos != null) {
                initRecycler(datos)
            }
        }
    }

    fun initRecycler(datos: List<Articles>){
        lateinit var RecyclerNews : RecyclerView
        RecyclerNews=findViewById(R.id.recyclerNews)
        RecyclerNews.layoutManager = LinearLayoutManager(this)
        val adapter = NewsAdapter(datos)
        RecyclerNews.adapter=adapter
    }




}
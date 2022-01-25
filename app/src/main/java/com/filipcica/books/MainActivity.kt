package com.filipcica.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request=ServiceBuilder.buildService(FakerEndpoints::class.java)
        val call=request.getBooks()

        call.enqueue(object :Callback<ResponseData> {
            override fun onResponse(call: Call<ResponseData>,response:Response<ResponseData>){
                if (response.isSuccessful){
                    findViewById<RecyclerView>(R.id.books).apply {
                        layoutManager=LinearLayoutManager(this@MainActivity)
                        adapter=BookRecyclerAdapter(response.body()!!.data)
                    }
                }
            }
            override fun onFailure(call: Call<ResponseData>,t:Throwable){
                Log.d("FAIL",t.message.toString())
            }

        })
    }
}
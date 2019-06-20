package com.sahabatdeveloper.dottest.network

import com.sahabatdeveloper.dottest.model.Model
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("ListData.json")
    fun getData(): Observable<Model.DataResponse>

    /**
     * Companion object to create the ApiService
     */
    companion object Factory {
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://gist.githubusercontent.com/yoesuv/0c274f3314cefd40f66e6ed83f08acc6/raw/8b0c6eb6a95cde6db904f5a0eddba280aef96680/")
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}
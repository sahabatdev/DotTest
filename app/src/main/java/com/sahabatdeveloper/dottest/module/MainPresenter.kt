package com.sahabatdeveloper.dottest.module

import android.util.Log
import com.sahabatdeveloper.dottest.model.Model
import com.sahabatdeveloper.dottest.network.ApiService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenter(private var mView: MainView?) {
    fun getDataImage(){
        mView?.onShowLoading()
        ApiService.create().getData()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
            result ->
                mView?.onHideLoading()
                mView?.onSuccessGetData(result.data)
            },
            { error ->
                mView?.onHideLoading()
                error.printStackTrace()
            })
    }
}
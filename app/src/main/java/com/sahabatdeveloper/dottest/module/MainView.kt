package com.sahabatdeveloper.dottest.module

import com.sahabatdeveloper.dottest.model.Model

interface MainView {
    fun onShowLoading()
    fun onHideLoading()
    fun onSuccessGetData(listData : List<Model.Data>)
    fun onMessage(message : String?)
}
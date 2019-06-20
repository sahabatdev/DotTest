package com.sahabatdeveloper.dottest.model

object Model{
    data class Data (val content: String, val id: Int, val media: List<String>, val title: String, val type: String)
    data class DataResponse (val status: Boolean,val data: List<Data>)
}

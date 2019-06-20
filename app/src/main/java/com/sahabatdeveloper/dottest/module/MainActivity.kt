package com.sahabatdeveloper.dottest.module

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sahabatdeveloper.dottest.R
import com.sahabatdeveloper.dottest.model.Model

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var mPresenter: MainPresenter
    private lateinit var pDialog: ProgressDialog
    private lateinit var rvDataImage: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter = MainPresenter(this)
        pDialog = ProgressDialog(this)
        pDialog.setMessage("Loading ke Server")
        pDialog.setCanceledOnTouchOutside(false)
        rvDataImage = findViewById(R.id.rv_data_image)

        mPresenter.getDataImage()
    }

    override fun onShowLoading() {
        pDialog.show()
    }

    override fun onHideLoading() {
        pDialog.hide()
    }

    override fun onSuccessGetData(listData: List<Model.Data>) {
        rvDataImage.layoutManager = LinearLayoutManager(this)
        rvDataImage.setHasFixedSize(true)
        rvDataImage.adapter = DataImageAdapter(this, listData)
    }

    override fun onMessage(message: String?) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}

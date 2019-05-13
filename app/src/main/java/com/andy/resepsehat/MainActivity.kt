package com.andy.resepsehat

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    private var dataItem: MutableList<DataItem?>? = null
    private var pd: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Kita buat object dari Listnya dulu ya

        dataItem = mutableListOf()

        //tampilin progress dialog
        pd = ProgressDialog.show(this@MainActivity, "Tunggu", "Sedan memanggil data resep", false, false)


        //Kita panggil Retrofitnya dulu

        Config.getService().daftarResep()
            .enqueue(object : Callback<Response> {
                override fun onFailure(call: Call<Response>, t: Throwable) {
                    pd?.dismiss()
                    Toast.makeText(this@MainActivity, "Opps Ada Yang salah ${t.message}", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                    //yang ini kalo status HTTP code 200
                    pd?.dismiss()
                    if (response.isSuccessful) {
                        dataItem = response.body()?.data

                        //set ke adapter
                        val adapter = ResepMakanAdapter(dataItem, this@MainActivity)

                        //yang buat bentuk recyclerview jadi 2 kolom
                        rvResep.layoutManager = GridLayoutManager(this@MainActivity, 2)

                        //set ke recyclerview
                        rvResep.adapter = adapter
                    }
                    //kalo yang ini selain 200
                    else {
                        Toast.makeText(this@MainActivity, "Asiyapp.. Terjadi Kesalahan", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

            })
    }
}

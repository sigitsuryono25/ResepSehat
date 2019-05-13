package com.andy.resepsehat

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_resep_makan_adapter.view.*

class ResepMakanAdapter(private var data: MutableList<DataItem?>?, private var context: Context) :
    RecyclerView.Adapter<ResepMakanAdapter.ViewHolder>() {

    //lokasi folder upload gambar
    private val URL_GAMBAR = "http://andy.lauwba.com/assets/upload/"


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context)
        val l = view.inflate(R.layout.activity_resep_makan_adapter, null)
        return ViewHolder(l)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val dataItem = data?.get(p1)

        //set gambar ke imageview pake Glide
        Glide.with(context)
            .load("${URL_GAMBAR}${dataItem?.gambarSehat}")
            .apply(RequestOptions().centerCrop())
            .into(p0.gambar)

        //set judul ke textView judul
        p0.judul.text = dataItem?.namaSehat
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val container: CardView = item.container
        val gambar: ImageView = item.gambar
        val judul: TextView = item.judulResep
    }
}

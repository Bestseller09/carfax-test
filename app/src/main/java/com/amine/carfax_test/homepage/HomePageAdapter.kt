package com.amine.carfax_test.homepage

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amine.carfax_test.R
import com.amine.carfax_test.network.model.ListingsModel
import com.bumptech.glide.Glide
import com.google.gson.Gson

class HomePageAdapter : RecyclerView.Adapter<HomePageAdapter.MyViewHolder>() {

    var carListData = mutableListOf<ListingsModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_row, parent, false )
        return MyViewHolder(inflater)

    }

    override fun onBindViewHolder(holder: HomePageAdapter.MyViewHolder, position: Int) {
        Log.e("BookList",""+Gson().toJson(carListData))
        holder.bind(carListData[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addData(mutableList: MutableList<ListingsModel>) {
        carListData = mutableList
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return carListData.size
    }

    class   MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val year = view.findViewById<TextView>(R.id.year)
        val make = view.findViewById<TextView>(R.id.make)
        val model = view.findViewById<TextView>(R.id.model)
        val trim = view.findViewById<TextView>(R.id.trim)
        val price = view.findViewById<TextView>(R.id.price)
        val mileage = view.findViewById<TextView>(R.id.mileage)
        val city = view.findViewById<TextView>(R.id.city)
        val state = view.findViewById<TextView>(R.id.state)
        val thumbImageView = view.findViewById<ImageView>(R.id.thumbImageView)

        fun bind(data: ListingsModel){
            year.text = data.year.toString()
            make.text = data.make
            model.text = data.model
            trim.text = data.trim
            price.text = data.currentPrice.toString()
            mileage.text = data.mileage.toString()
            city.text = data.dealer?.city
            state.text = data.dealer?.state

            val url  = data.images?.firstPhoto?.large
            Glide.with(thumbImageView)
                .load(url)
//                .circleCrop()
                .into(thumbImageView)
        }
    }
}
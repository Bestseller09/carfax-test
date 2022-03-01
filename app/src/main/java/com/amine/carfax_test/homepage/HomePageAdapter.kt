package com.amine.carfax_test.homepage

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amine.carfax_test.FragmentsUtil
import com.amine.carfax_test.MainActivity
import com.amine.carfax_test.R
import com.amine.carfax_test.details.DetailsFragment
import com.amine.carfax_test.models.ListingsModel
import com.bumptech.glide.Glide
import com.google.gson.Gson
import kotlinx.android.synthetic.main.recycler_list_row.view.*
import java.text.NumberFormat
import java.util.*

class HomePageAdapter : RecyclerView.Adapter<HomePageAdapter.MyViewHolder>() {

    var carListData = mutableListOf<ListingsModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_row, parent, false )
        return MyViewHolder(inflater)

    }

    override fun onBindViewHolder(holder: HomePageAdapter.MyViewHolder, position: Int) {
        Log.d("HomePageAdapter",""+Gson().toJson(carListData))
        holder.bind(carListData[position])
        holder.layout_top.isClickable()
        holder.layout_top.isFocusable()

        holder.layout_top.setOnClickListener(View.OnClickListener { view: View? ->
            val bundle = Bundle()
            bundle.putString("photo", carListData[position].images?.firstPhoto?.large)
            bundle.putString("year", carListData[position].year.toString())
            bundle.putString("make", carListData[position].make)
            bundle.putString("model", carListData[position].model)
            bundle.putString("trim", carListData[position].trim)
            carListData[position].currentPrice?.let { bundle.putInt("price", it) }
            carListData[position].mileage?.let { bundle.putInt("mileage", it) }
            bundle.putString("city", carListData[position].dealer?.city)
            bundle.putString("state", carListData[position].dealer?.state)
            bundle.putString("interior_color", carListData[position].interiorColor)
            bundle.putString("exterior_color", carListData[position].exteriorColor)
            bundle.putString("drive_type", carListData[position].drivetype)
            bundle.putString("transmission", carListData[position].transmission)
            bundle.putString("engine", carListData[position].engine)
            bundle.putString("body_style", carListData[position].bodytype)
            bundle.putString("phone", carListData[position].dealer?.phone)
            val frag = DetailsFragment()
            frag.arguments = bundle
            FragmentsUtil.addSubscreen(frag, DetailsFragment.tag())
        })
        holder.btn_call.setOnClickListener(View.OnClickListener { view: View? ->
            MainActivity.makePhoneCall(carListData[position].dealer?.phone as String)
        })
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

        val year = view.year
        val make = view.make
        val model = view.model
        val trim = view.trim
        val price = view.price
        val mileage = view.mileage
        val city = view.city
        val state = view.state
        val thumbImageView = view.thumbImageView
        val layout_top = view.layout_top
        var btn_call = view.btn_call

        fun bind(data: ListingsModel){
            year.text = data.year.toString()
            make.text = data.make
            model.text = data.model
            trim.text = data.trim
            price.text = "$ " + NumberFormat.getNumberInstance(Locale.US).format(data.currentPrice)
            mileage.text = data.mileage.toString() + " mi"
            city.text = data.dealer?.city
            state.text = data.dealer?.state

            val url  = data.images?.firstPhoto?.large
            Glide.with(thumbImageView)
                .load(url)
                .into(thumbImageView)


        }
    }
}
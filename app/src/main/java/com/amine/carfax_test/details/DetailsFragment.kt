package com.amine.carfax_test.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.amine.carfax_test.FragmentsUtil
import com.amine.carfax_test.MainActivity.Companion.makePhoneCall
import com.amine.carfax_test.R
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import java.text.NumberFormat
import java.util.*

class DetailsFragment : Fragment() {
//    private var rootView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.details_fragment, container, false)
        val btn_btn = activity?.findViewById<MaterialButton>(R.id.btn_back)
        val btn_call = rootView.findViewById<Button>(R.id.btn_call)
        btn_btn?.visibility = View.VISIBLE
        val args = this.arguments
        val yearTextView : TextView = rootView.findViewById(R.id.year)
        val makeTextView : TextView = rootView.findViewById(R.id.make)
        val modelTextView : TextView = rootView.findViewById(R.id.model)
        val trimTextView : TextView = rootView.findViewById(R.id.trim)
        val priceTextView : TextView = rootView.findViewById(R.id.price)
        val mileageTextView : TextView = rootView.findViewById(R.id.mileage)
        val locationTextView : TextView = rootView.findViewById(R.id.location_value)
        val exteriorTextView : TextView = rootView.findViewById(R.id.exterior_color_value)
        val interiorTextView : TextView = rootView.findViewById(R.id.interior_color_value)
        val driveTypeTextView : TextView = rootView.findViewById(R.id.driver_type_value)
        val transmissionTextView : TextView = rootView.findViewById(R.id.transmission_value)
        val engineTextView : TextView = rootView.findViewById(R.id.engine_value)
        val bodyStyleTextView : TextView = rootView.findViewById(R.id.body_style_value)
        val bannerImage : ImageView = rootView.findViewById(R.id.bannerImage)
        val inputYear = args?.get("year")
        yearTextView.text = inputYear.toString()
        val url  = args?.get("photo")
        Glide.with(bannerImage)
            .load(url)
            .into(bannerImage)
        val inputMake = args?.get("make")
        makeTextView.text = inputMake.toString()
        val inputModel = args?.get("model")
        modelTextView.text = inputModel.toString()
        val inputTrim = args?.get("trim")
        trimTextView.text = inputTrim.toString()
        val priceTrim = args?.get("price")
        priceTextView.text = "$ " + NumberFormat.getNumberInstance(Locale.US).format(priceTrim)
        val inputMileage = args?.get("mileage")
        mileageTextView.text = inputMileage.toString() + " mi"
        val inputCity = args?.get("city")
        val inputState = args?.get("state")
        locationTextView.text = inputCity.toString() + ", " + inputState
        val inputInterior = args?.get("interior_color")
        interiorTextView.text = inputInterior.toString()
        val inputExtrior = args?.get("exterior_color")
        exteriorTextView.text = inputExtrior.toString()
        val inputDrive = args?.get("drive_type")
        driveTypeTextView.text = inputDrive.toString()
        val inputTransmission = args?.get("transmission")
        transmissionTextView.text = inputTransmission.toString()
        val inputEngine = args?.get("engine")
        engineTextView.text = inputEngine.toString()
        val inputBody = args?.get("body_style")
        bodyStyleTextView.text = inputBody.toString()
        val inputPhone = args?.get("phone")

        if (btn_btn != null) {
            btn_btn.setOnClickListener(View.OnClickListener { view: View? ->
                 FragmentsUtil.setBackPopStack(this)
            })
        }

        if (btn_call != null) {
            btn_call.setOnClickListener(View.OnClickListener { view: View? ->
                Log.d("Details", inputPhone.toString())
                makePhoneCall(inputPhone as String)
            })
        }

        return rootView
    }


    companion object {
        fun tag(): String {
            return FragmentsUtil.FRAGMENTS.CARDETAILS.getFragmentTag()
        }
    }
}
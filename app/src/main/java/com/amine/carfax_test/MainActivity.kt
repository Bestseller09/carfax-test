package com.amine.carfax_test

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.amine.carfax_test.homepage.HomePageFragment
import okhttp3.internal.Internal.instance

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        ApplicationActivity.overwrite(this)
        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)

        /*-----remove the system bars ------*/
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        FragmentsUtil.addSubscreen(HomePageFragment(), HomePageFragment.tag())
    }
    companion object {

        fun makePhoneCall(number: String) {
            lateinit  var appContext: Context
            val REQUEST_CALL = 1
            if (number.trim { it <= ' ' }.length > 0) {

                if (ContextCompat.checkSelfPermission(
                        ApplicationActivity.get()!!,
                        Manifest.permission.CALL_PHONE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        ApplicationActivity.get()!!,
                        arrayOf(Manifest.permission.CALL_PHONE),
                        REQUEST_CALL
                    )
                } else {
                    val dial = "tel:$number"
                    val phoneIntent = Intent(Intent.ACTION_CALL, Uri.parse(dial))
                    phoneIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

                    ApplicationActivity.get()?.applicationContext?.let { startActivity(it, phoneIntent, null) }
                }
            }
        }
    }

}
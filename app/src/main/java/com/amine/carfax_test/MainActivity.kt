package com.amine.carfax_test

import android.os.Bundle
import android.view.View
import android.view.View.OnSystemUiVisibilityChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.amine.carfax_test.homepage.HomePageFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        ApplicationActivity.overwrite(this)
        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)

        /*-----remove the system bars ------*/
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        FragmentsUtil.addSubscreen(HomePageFragment(), HomePageFragment.tag())
    }

}
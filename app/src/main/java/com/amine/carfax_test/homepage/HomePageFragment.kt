package com.amine.carfax_test.homepage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.amine.carfax_test.FragmentsUtil
import com.amine.carfax_test.R
import com.google.gson.Gson


class HomePageFragment : Fragment() {
    lateinit var viewModel: HomePageViewModel
    lateinit var carListAdapter: HomePageAdapter
    private var rootView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.home_page_fragment, container, false)
        viewModel = ViewModelProvider(this).get(HomePageViewModel::class.java)

        initViews(rootView)
        startObserver()

        loadAPIData()
        return rootView
    }

    private fun initViews(view: View?) {
        view?.findViewById<RecyclerView>(R.id.recyclerView)?.apply {
            layoutManager = LinearLayoutManager(context)
            val decoration = DividerItemDecoration(context, StaggeredGridLayoutManager.VERTICAL)
            addItemDecoration(decoration)
            carListAdapter = HomePageAdapter()
            adapter = carListAdapter
        }
    }

    private fun startObserver() {
        viewModel.carList.observe(viewLifecycleOwner, {
            if (it != null) {

                Log.i("AAAA", "startObserver: "+Gson().toJson(it))
                //update adapter...
                carListAdapter.carListData = it.listings?.toMutableList() ?: mutableListOf()
                carListAdapter.addData(it.listings?.toMutableList() ?: mutableListOf())
            }
        })
    }


    fun loadAPIData() {
        Log.d("viewModel", "" + viewModel)

        viewModel.makeApiCall()
    }

    companion object {
        fun tag(): String {
            return FragmentsUtil.FRAGMENTS.HOME.fragmentTag
        }
    }
}
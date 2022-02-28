package com.amine.carfax_test.homepage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.amine.carfax_test.FragmentsUtil
import com.amine.carfax_test.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.home_page_fragment.*


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
        // instantiate viewmodel
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
        view?.findViewById<SwipeRefreshLayout>(R.id.swipeRefreshLayout)?.setOnRefreshListener {
            Log.d("HomePageFragment", "SWIPE")
            swipeRefreshLayout.isRefreshing = false
            loadAPIData()
        }
    }

    private fun startObserver() {
        viewModel.carList.observe(viewLifecycleOwner) {
            if (it != null) {

                Log.d("HomePageFragment", "startObserver: " + Gson().toJson(it))
                //update adapter...
                carListAdapter.carListData = it.listings?.toMutableList() ?: mutableListOf()
                carListAdapter.addData(it.listings?.toMutableList() ?: mutableListOf())
            }
        }
        viewModel.carLoadError.observe(viewLifecycleOwner) {
                //update adapter...
            list_error.visibility = if(it) View.VISIBLE else View.GONE
        }
        viewModel.loading.observe(viewLifecycleOwner) {
            loading_view.visibility = if(it) View.VISIBLE else View.GONE
            if (it) {
                list_error.visibility = View.GONE
                recyclerView.visibility = View.GONE
            }

        }
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
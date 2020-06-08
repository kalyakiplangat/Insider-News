package com.thekalya.insidernews.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.thekalya.insidernews.R
import com.thekalya.insidernews.adapters.ArticlesAdapter
import com.thekalya.insidernews.databinding.FragmentHomeBinding
import com.google.android.gms.ads.MobileAds

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false)

        val viewModelFactory = HomeViewModelFactory()
        val viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.articles.observe(this, Observer {
            binding.recyclerView.adapter = ArticlesAdapter(this.context!!, it)
        })

        MobileAds.initialize(this.context){}


        return binding.root
    }

}

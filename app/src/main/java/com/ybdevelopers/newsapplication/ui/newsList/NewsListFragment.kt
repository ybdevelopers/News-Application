package com.ybdevelopers.newsapplication.ui.newsList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ybdevelopers.newsapplication.R
import com.ybdevelopers.newsapplication.adapters.NewsAdapter
import com.ybdevelopers.newsapplication.data.remote.RetrofitHelper
import com.ybdevelopers.newsapplication.data.remote.api.APIInterface
import com.ybdevelopers.newsapplication.databinding.FragmentNewsListBinding
import com.ybdevelopers.newsapplication.repository.APIRepository
import com.ybdevelopers.newsapplication.viewModel.NewsViewModel
import com.ybdevelopers.newsapplication.viewModel.NewsViewModelFactory

class NewsListFragment : Fragment() {
    private lateinit var binding: FragmentNewsListBinding
    private lateinit var newsViewModel: NewsViewModel
    private val newsAdapter by lazy { NewsAdapter(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news_list, container, false)
        apiCall()
        return binding.root
    }

    private fun apiCall() {
        val apiInterface = RetrofitHelper.getInstance().create(APIInterface::class.java)
        val apiRepository = APIRepository(apiInterface)
        newsViewModel = ViewModelProvider(
            this,
            NewsViewModelFactory(apiRepository, getString(R.string.API_KEY))
        )[NewsViewModel::class.java]
        newsViewModel.newsList.observe(viewLifecycleOwner, {
            for (element in it.articles) {
                newsAdapter.addItem(element)
            }
            binding.rvNewsList.adapter = newsAdapter
            Log.e("API Response:", "${it.articles.toString()}")
        })
    }
}
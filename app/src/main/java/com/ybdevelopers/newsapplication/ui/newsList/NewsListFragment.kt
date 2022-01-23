package com.ybdevelopers.newsapplication.ui.newsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ybdevelopers.newsapplication.R
import com.ybdevelopers.newsapplication.adapters.NewsAdapter
import com.ybdevelopers.newsapplication.data.remote.RetrofitHelper
import com.ybdevelopers.newsapplication.data.remote.api.APIInterface
import com.ybdevelopers.newsapplication.databinding.FragmentNewsListBinding
import com.ybdevelopers.newsapplication.model.Article
import com.ybdevelopers.newsapplication.repository.APIRepository
import com.ybdevelopers.newsapplication.viewModel.NewsViewModel
import com.ybdevelopers.newsapplication.viewModel.NewsViewModelFactory
import timber.log.Timber


class NewsListFragment : Fragment() {
    private lateinit var binding: FragmentNewsListBinding
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var linearLayoutManager: LinearLayoutManager
    private val newsAdapter by lazy { NewsAdapter() }
    private val newsListPagination: MutableList<Article> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news_list, container, false)
        val apiInterface = RetrofitHelper.getInstance().create(APIInterface::class.java)
        val apiRepository = APIRepository(apiInterface)
        newsViewModel = ViewModelProvider(
            this,
            NewsViewModelFactory(apiRepository, getString(R.string.API_KEY))
        )[NewsViewModel::class.java]
        apiCall()
        binding.rvNewsList.addOnScrollListener(addPagination())
        return binding.root
    }

    private fun addPagination() = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            if (dy > 0) { //check for scroll down

                binding.rvNewsList.layoutManager?.let {
                    linearLayoutManager = binding.rvNewsList.layoutManager as LinearLayoutManager
                    val visibleItemCount = linearLayoutManager.childCount
                    val totalItemCount = linearLayoutManager.itemCount
                    val pastVisibleItems = linearLayoutManager.findFirstVisibleItemPosition()

                    if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                        newsViewModel.newsPage++
                        newsViewModel.getNewsAPI(10)
                    }
                }
            }

        }
    }

    private fun apiCall() {
        newsViewModel.newsList.observe(viewLifecycleOwner, {
            if (newsViewModel.newsPage == 1) {
                newsListPagination.clear()
                newsListPagination.addAll(it.articles)
            } else {
                newsListPagination.addAll(it.articles)
            }
            newsAdapter.addItems(newsListPagination)
//            binding.rvNewsList.smoothScrollToPosition(it.articles.size - 10)
        })
        binding.rvNewsList.adapter = newsAdapter

        newsAdapter.listener = { _, newsPositionData, _ ->
            val actionData = NewsListFragmentDirections.actionNewsListFragmentToNewsDetailFragment(
                newsPositionData
            )
            findNavController().navigate(actionData)
        }
    }
}
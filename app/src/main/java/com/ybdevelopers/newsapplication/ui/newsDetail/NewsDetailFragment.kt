package com.ybdevelopers.newsapplication.ui.newsDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ybdevelopers.newsapplication.R
import com.ybdevelopers.newsapplication.databinding.FragmentNewsDetailBinding

class NewsDetailFragment : Fragment() {
    private lateinit var binding: FragmentNewsDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news_detail, container, false)
        arguments?.let {
            val argsData = NewsDetailFragmentArgs.fromBundle(it)
            binding.articleData = argsData.articleModel
        }
        binding.ivClose.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }
}
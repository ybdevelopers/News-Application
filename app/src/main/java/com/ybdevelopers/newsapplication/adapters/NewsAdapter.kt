package com.ybdevelopers.newsapplication.adapters

import android.content.Context
import androidx.recyclerview.widget.SortedList
import androidx.recyclerview.widget.SortedListAdapterCallback
import com.bumptech.glide.Glide
import com.ybdevelopers.newsapplication.R
import com.ybdevelopers.newsapplication.databinding.ItemNewsListBinding
import com.ybdevelopers.newsapplication.model.Article

class NewsAdapter(private val context: Context) :
    BaseRecyclerViewAdapter<Article, ItemNewsListBinding>() {
    override fun getLayout() = R.layout.item_news_list

    override fun BaseViewHolder<ItemNewsListBinding>.bindData(
        item: Article?,
        position: Int
    ) {
        binding.apply {
            if (item?.urlToImage!!.isNotEmpty())
                Glide.with(context).load(item.urlToImage).into(ivNews)
            article = item
        }
    }

    override fun initSortedList() = SortedList(
        Article::class.java, object : SortedListAdapterCallback<Article>(this) {
            override fun compare(o1: Article, o2: Article) =
                o1.title.compareTo(o2.title)

            override fun areContentsTheSame(oldItem: Article, newItem: Article) =
                oldItem.title == newItem.title

            override fun areItemsTheSame(item1: Article, item2: Article) =
                item1 == item2

        }
    )
}
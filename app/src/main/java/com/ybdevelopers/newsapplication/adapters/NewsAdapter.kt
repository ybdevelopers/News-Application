package com.ybdevelopers.newsapplication.adapters

import androidx.recyclerview.widget.SortedList
import androidx.recyclerview.widget.SortedListAdapterCallback
import com.ybdevelopers.newsapplication.R
import com.ybdevelopers.newsapplication.databinding.ItemNewsListBinding
import com.ybdevelopers.newsapplication.model.Article

class NewsAdapter :
    BaseRecyclerViewAdapter<Article, ItemNewsListBinding>() {
    override fun getLayout() = R.layout.item_news_list

    override fun BaseViewHolder<ItemNewsListBinding>.bindData(
        item: Article?,
        position: Int
    ) {
        binding.apply {
            root.setOnClickListener {
                item?.let { it1 -> listener?.invoke(it, it1, position) }
            }
            if ((position + 1) % 6 == 0) {
                item?.urlToImage = ""
                article = item
            } else {
                article = item
            }
        }
    }

    override fun initSortedList() = SortedList(
        Article::class.java, object : SortedListAdapterCallback<Article>(this) {
            override fun compare(o1: Article, o2: Article) = 0

            override fun areContentsTheSame(oldItem: Article, newItem: Article) =
                oldItem.publishedAt == newItem.publishedAt

            override fun areItemsTheSame(item1: Article, item2: Article) =
                item1 == item2

        }
    )
}
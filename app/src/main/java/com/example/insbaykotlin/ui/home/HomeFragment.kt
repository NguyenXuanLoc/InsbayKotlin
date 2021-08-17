package com.example.insbaykotlin.ui.home

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.insbaykotlin.R
import com.example.insbaykotlin.common.ext.ctx
import com.example.insbaykotlin.common.ext.setImage
import com.example.insbaykotlin.data.model.FeedModel
import com.example.insbaykotlin.widget.PaginationScrollListener
import com.example.pview.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment<HomeView, HomePresenter>(), HomeView {
    private var createAt: String = ""
    private var hasMoreData = true
    private var isLoading = false
    private val feeds by lazy { ArrayList<FeedModel>() }
    private val adapter by lazy { FeedAdapter(parentActivity, feeds) {} }

    private val paginationScrollListener by lazy {
        object : PaginationScrollListener(rclKFeed.layoutManager as LinearLayoutManager?) {
            override fun loadMoreItems() {
                isLoading = true
                rclKFeed.post {
                    adapter.addLoadingView()
                }
                presenter.getKFeed(createAt)
            }

            override fun isLastPage(): Boolean {
                return !hasMoreData
            }

            override fun isLoading(): Boolean {
                return isLoading
            }
        }
    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun initView(): HomeView {
        return this
    }

    override fun initPresenter(): HomePresenter {
        return HomePresenter(ctx!!)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initWidgets() {
        rclKFeed.adapter = adapter
        rclKFeed.layoutManager =
            LinearLayoutManager(parentActivity, LinearLayoutManager.VERTICAL, false)
        rclKFeed.setHasFixedSize(true)
        setPaginationLayoutManager()
        presenter.getKFeed()
    }

    private fun setPaginationLayoutManager() {
        paginationScrollListener.setLayoutManager(rclKFeed.layoutManager as LinearLayoutManager)
        rclKFeed.addOnScrollListener(paginationScrollListener)
    }

    override fun loadKFeedSuccess(models: List<FeedModel>, nextPage: String) {
        isLoading = false
        if (createAt.isEmpty()) {
            feeds.clear()
        } else adapter.removeLoadingView()
        createAt = nextPage
        feeds.addAll(models)
        adapter.notifyDataSetChanged()
    }

}
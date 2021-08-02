package com.example.insbaykotlin.ui.search

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.insbaykotlin.R
import com.example.insbaykotlin.common.ext.ctx
import com.example.insbaykotlin.common.ext.gone
import com.example.insbaykotlin.data.model.OutfitsModel
import com.example.insbaykotlin.data.model.UsersModel
import com.example.insbaykotlin.widget.PaginationScrollListener
import com.example.pview.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : BaseFragment<SearchView, SearchPresenter>(), SearchView {
    private var currentPageLooks = 0
    private var hasMoreDataLooks = true
    private var isLoadingLooks = false
    private val looks by lazy { ArrayList<OutfitsModel>() }

    private var currentPageTvStar = 0
    private var hasMoreDataTvStar = true
    private var isLoadingTvStar = false
    private val tvStars by lazy { ArrayList<UsersModel>() }
    private val tvStarAdapter by lazy {
        SearchTvStarAdapter(parentActivity, tvStars, { it ->

        })
    }
    private val lookAdapter by lazy {
        SearchLookAdapter(parentActivity, looks, { it ->
        })
    }

    private val paginationTvStarScrollListener by lazy {
        object : PaginationScrollListener(rclTvStar.layoutManager as LinearLayoutManager,20) {
            override fun loadMoreItems() {
                isLoadingTvStar = true
                currentPageTvStar++;
                rclTvStar.post {
                    tvStarAdapter.addLoadingView()
                }

            }

            override fun isLastPage(): Boolean {
                return !hasMoreDataTvStar
            }

            override fun isLoading(): Boolean {
                return isLoadingTvStar
            }

        }
    }
    private val paginationLooksScrollListener by lazy {
        object : PaginationScrollListener(rclLook.layoutManager as LinearLayoutManager) {
            override fun loadMoreItems() {
                isLoadingLooks = true
                currentPageLooks++
                rclLook.post {
                    lookAdapter.addLoadingView()
                }
                presenter.searchLook(currentPageLooks.toString())
            }

            override fun isLastPage(): Boolean {
                return !hasMoreDataLooks
            }

            override fun isLoading(): Boolean {
                return isLoadingLooks
            }

        }
    }

    companion object {
        fun newInstance(): SearchFragment {
            return SearchFragment()
        }
    }

    override fun initView(): SearchView {
        return this
    }

    override fun initPresenter(): SearchPresenter {
        return SearchPresenter(ctx!!)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_search
    }

    override fun initWidgets() {
        rclLook.adapter = lookAdapter
        rclLook.layoutManager = LinearLayoutManager(ctx, LinearLayoutManager.HORIZONTAL, false)
        rclLook.setHasFixedSize(true)

        rclTvStar.adapter = tvStarAdapter
        rclTvStar.layoutManager = LinearLayoutManager(ctx, LinearLayoutManager.HORIZONTAL, false)
        rclTvStar.setHasFixedSize(true)
        setPaginationLayoutManager()
        rclLook.addOnScrollListener(paginationLooksScrollListener)
        rclTvStar.addOnScrollListener(paginationTvStarScrollListener)

        rclProducts.adapter = lookAdapter
        rclProducts.layoutManager = LinearLayoutManager(ctx, LinearLayoutManager.HORIZONTAL, false)
        rclProducts.setHasFixedSize(true)

        presenter.searchLook(currentPageLooks.toString())
        presenter.searchTvStar()
    }

    private fun setPaginationLayoutManager() {
        paginationLooksScrollListener.setLayoutManager(rclLook.layoutManager as LinearLayoutManager)
        paginationTvStarScrollListener.setLayoutManager(rclTvStar.layoutManager as LinearLayoutManager)
    }

    override fun loadOutfitSuccess(model: List<OutfitsModel>) {
        pbLooks.gone()
        pbProducts.gone()
        isLoadingLooks = false;
        if (currentPageLooks == 0) {
            looks.clear()

        } else {
            lookAdapter.removeLoadingView()
        }
        looks.addAll(model)

        lookAdapter.notifyDataSetChanged()
    }

    override fun loadTvStarSuccess(model: List<UsersModel>) {
        pbTvStar.gone()
        isLoadingTvStar = false
        if (currentPageTvStar == 0) {
            tvStars.clear()
        } else {
            tvStarAdapter.removeLoadingView()
        }
        tvStars.addAll(model)
        tvStarAdapter.notifyDataSetChanged()
    }

    override fun onSendDataSuccess() {
    }
}
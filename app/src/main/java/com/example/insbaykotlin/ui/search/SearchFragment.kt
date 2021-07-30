package com.example.insbaykotlin.ui.search

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.insbaykotlin.R
import com.example.insbaykotlin.common.ext.ctx
import com.example.insbaykotlin.data.model.OutfitsModel
import com.example.insbaykotlin.widget.PaginationScrollListener
import com.example.pview.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_search.*
import org.jetbrains.anko.toast

class SearchFragment : BaseFragment<SearchView, SearchPresenter>(), SearchView {
    private var currentPage = 0
    private var hasMoreData = true
    private var isLoading = false
    private val paginationScrollListener by lazy {
        object : PaginationScrollListener(rclLook.layoutManager as LinearLayoutManager) {
            override fun loadMoreItems() {
                isLoading = true
                currentPage++
                rclLook.post {
//                    adapter.addLoadingView()
                }
//                getContacts(false)
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
        presenter.searchLook(currentPage.toString())
    }

    override fun loadOutfitSuccess(model: List<OutfitsModel>) {
        ctx?.toast("Load Outfit SIZE: ${model.size}}")
    }

    override fun onSendDataSuccess() {
    }
}
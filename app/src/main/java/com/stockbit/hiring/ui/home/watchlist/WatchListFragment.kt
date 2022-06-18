package com.stockbit.hiring.ui.home.watchlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.stockbit.common.base.BaseFragment
import com.stockbit.common.base.BaseViewModel
import com.stockbit.hiring.databinding.FragmentWatchlistBinding
import com.stockbit.repository.utils.Resource
import org.koin.android.viewmodel.ext.android.viewModel

class WatchListFragment : BaseFragment() {

    private var _binding: FragmentWatchlistBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<WatchListViewModel>()
    private val watchListAdapter = WatchListAdapter()

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWatchlistBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchCryptoData()

        with(binding.rvWatchlist) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = watchListAdapter
        }

        binding.refreshLayout.setOnRefreshListener {
            fetchCryptoData()
        }
    }

    private fun fetchCryptoData(){
        viewModel.cryptoData.observe(viewLifecycleOwner) {
            when (it.status) {
                Resource.Status.LOADING -> {
                    binding.pbWatchlist.visibility = View.VISIBLE
                }
                Resource.Status.ERROR -> {
                    binding.pbWatchlist.visibility = View.GONE
                    binding.refreshLayout.isRefreshing = false
                }
                Resource.Status.EMPTY -> {
                    binding.pbWatchlist.visibility = View.GONE
                    binding.refreshLayout.isRefreshing = false
                }
                Resource.Status.SUCCESS -> {
                    binding.pbWatchlist.visibility = View.GONE
                    binding.refreshLayout.isRefreshing = false
                    watchListAdapter.setData(it.data)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
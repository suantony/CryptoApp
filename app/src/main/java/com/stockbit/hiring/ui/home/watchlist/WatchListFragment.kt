package com.stockbit.hiring.ui.home.watchlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.stockbit.hiring.databinding.FragmentWatchlistBinding

class WatchListFragment : Fragment() {

    private var _binding: FragmentWatchlistBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val watchListViewModel =
            ViewModelProvider(this).get(WatchListViewModel::class.java)

        _binding = FragmentWatchlistBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textWatchlist
        watchListViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
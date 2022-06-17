package com.stockbit.hiring.ui.home.stream

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.stockbit.hiring.R
import com.stockbit.hiring.databinding.FragmentChatBinding
import com.stockbit.hiring.databinding.FragmentPortofolioBinding
import com.stockbit.hiring.databinding.FragmentStreamBinding
import com.stockbit.hiring.ui.home.portofolio.PortofolioViewModel

class StreamFragment : Fragment() {

    private var _binding: FragmentStreamBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = StreamFragment()
    }

    private lateinit var viewModel: StreamViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val streamViewModel =
            ViewModelProvider(this).get(StreamViewModel::class.java)

        _binding = FragmentStreamBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textStream
        streamViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
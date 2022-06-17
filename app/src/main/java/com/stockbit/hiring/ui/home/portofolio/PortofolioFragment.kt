package com.stockbit.hiring.ui.home.portofolio

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
import com.stockbit.hiring.ui.home.chat.ChatViewModel

class PortofolioFragment : Fragment() {

    private var _binding: FragmentPortofolioBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = PortofolioFragment()
    }

    private lateinit var viewModel: PortofolioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val portofolioViewModel =
            ViewModelProvider(this).get(PortofolioViewModel::class.java)

        _binding = FragmentPortofolioBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textPortofolio
        portofolioViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
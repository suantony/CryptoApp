package com.stockbit.hiring.ui.home.watchlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stockbit.hiring.databinding.CryptoItemBinding
import com.stockbit.model.CryptoItem
import java.util.ArrayList

class WatchListAdapter(
) : RecyclerView.Adapter<WatchListAdapter.WatchListViewHolder>() {

    private var itemList = ArrayList<CryptoItem>()

    fun setData(newListData: List<CryptoItem>?) {
        if (newListData == null) return
        itemList.clear()
        itemList.addAll(newListData)
        notifyDataSetChanged()
    }

    fun clear() {
        itemList.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WatchListAdapter.WatchListViewHolder {
        return WatchListViewHolder(
            CryptoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: WatchListAdapter.WatchListViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    class WatchListViewHolder(private val vb: CryptoItemBinding) : RecyclerView.ViewHolder(vb.root){
        fun bind(item : CryptoItem){
            vb.name.text = item.coinInfo?.name ?: ""
            vb.price.text = item.display?.usd?.price ?: ""
        }
    }
}
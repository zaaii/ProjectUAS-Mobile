package com.zai.movieku.ui.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.zai.movieku.databinding.TvRowBinding
import com.zai.movieku.network.Tv

class TvAdapter(private val clickListener: TvListener) :
    ListAdapter<Tv, TvAdapter.TvViewHolder>(DiffCallback)
{
    class TvViewHolder(
        var binding: TvRowBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: TvListener, tv: Tv) {
            binding.tv = tv
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Tv>() {
        override fun areItemsTheSame(oldItem: Tv, newItem: Tv): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Tv, newItem: Tv): Boolean {
            return oldItem.first_air_date == newItem.first_air_date && oldItem.overview == newItem.overview && oldItem.poster_path == newItem.poster_path
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TvViewHolder(
            TvRowBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val tv = getItem(position)
        holder.bind(clickListener, tv)
    }

}
class TvListener(val clickListener: (tv: Tv) -> Unit) {
    fun onClick(tv: Tv) = clickListener(tv)
}
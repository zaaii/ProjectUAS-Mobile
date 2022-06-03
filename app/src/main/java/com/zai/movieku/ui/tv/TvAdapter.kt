package com.zai.movieku.ui.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.zai.movieku.databinding.MovieRowBinding
import com.zai.movieku.databinding.TvRowBinding
import com.zai.movieku.network.Tv
import com.zai.movieku.ui.movies.MovieAdapter
import com.zai.movieku.ui.tv.TvAdapter

class TvAdapter(private val clickListener: TvListener) :
    ListAdapter<Tv, TvAdapter.TvViewHolder>(DiffCallback)
{
    class TvViewHolder(
        var binding: TvRowBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: TvListener, tv: tv) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvAdapter.TvViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TvAdapter.TvViewHolder(
            TvRowBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TvAdapter.TvViewHolder, position: Int) {
        val tv = getItem(position)
        holder.bind(clickListener, tv)
    }

}
class MoviesListener(val clickListener: (tv: tv) -> Unit) {
    fun onClick(tv: Tv) = clickListener(movie)
}
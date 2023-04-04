package com.thmanyah.podcast.presentation.ui.bottom_navigation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.thmanyah.podcast.data.get_ways.api_services.model.response.PlayListResponse
import com.thmanyah.podcast.databinding.LayoutEpisodeRowBinding

class EpisodeAdapter(
    private val rowClick: (PlayListResponse.Data.Episode) -> Unit,
    private val playClick: (PlayListResponse.Data.Episode) -> Unit,
    private val menuClick: (PlayListResponse.Data.Episode) -> Unit,
) : ListAdapter<PlayListResponse.Data.Episode, BaseHolder<PlayListResponse.Data.Episode>>(object :
        DiffUtil.ItemCallback<PlayListResponse.Data.Episode>() {

        override fun areItemsTheSame(
            oldItem: PlayListResponse.Data.Episode,
            newItem: PlayListResponse.Data.Episode
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: PlayListResponse.Data.Episode,
            newItem: PlayListResponse.Data.Episode
        ): Boolean {
            return oldItem == newItem
        }
    }) {

    inner class SampleViewHolder(
        private val binding: LayoutEpisodeRowBinding,
    ) : BaseHolder<PlayListResponse.Data.Episode>(binding) {

        override fun bind(dataModel: PlayListResponse.Data.Episode, position: Int) {
            binding.dataModel = dataModel

            binding.root.setOnClickListener {
                rowClick(dataModel)
            }

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseHolder<PlayListResponse.Data.Episode> {
        return SampleViewHolder(
            LayoutEpisodeRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseHolder<PlayListResponse.Data.Episode>, position: Int) {
        holder.bind(getItem(position)!!, position)
    }
}
abstract class BaseHolder<T>(binding : ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(value : T, position : Int)
}


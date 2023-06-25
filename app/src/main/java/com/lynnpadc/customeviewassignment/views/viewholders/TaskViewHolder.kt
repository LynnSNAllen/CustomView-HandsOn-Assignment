package com.lynnpadc.customeviewassignment.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lynnpadc.customeviewassignment.databinding.ViewPodTaskBinding
import com.lynnpadc.customeviewassignment.delegate.ProfileItemDelegate

class TaskViewHolder(itemView: View, private val delegate: ProfileItemDelegate) :RecyclerView.ViewHolder(itemView) {

    private var binding: ViewPodTaskBinding

    init {
        binding = ViewPodTaskBinding.bind(itemView)
        setUpListeners()
    }

    private fun setUpListeners() {
        binding.ivProfileImage.setOnClickListener {
            delegate.onTapProfileDetail()
        }

        itemView.setOnClickListener {
            delegate.onTapTask()
        }
    }
}
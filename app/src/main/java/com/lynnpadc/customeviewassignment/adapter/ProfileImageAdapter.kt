package com.lynnpadc.customeviewassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lynnpadc.customeviewassignment.R
import com.lynnpadc.customeviewassignment.delegate.ProfileItemDelegate
import com.lynnpadc.customeviewassignment.views.components.RoundedProfileImage
import com.lynnpadc.customeviewassignment.views.viewholders.ProfileImageViewHolder

class ProfileImageAdapter(private val delegate: ProfileItemDelegate):RecyclerView.Adapter<ProfileImageViewHolder>() {

    private val profileImageList = listOf(
        R.drawable.omega,
        R.drawable.omega,
        R.drawable.omega,
        R.drawable.plus
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_profile_image, parent, false)
        return ProfileImageViewHolder(view.rootView, delegate)
    }

    override fun getItemCount(): Int {
        return profileImageList.count()
    }

    override fun onBindViewHolder(holder: ProfileImageViewHolder, position: Int) {
        var profile = holder.itemView.findViewById<RoundedProfileImage>(R.id.customProfileImage)
        profile.setImageResource(profileImageList[position])

        holder.itemView.setOnClickListener {
            if (holder.adapterPosition == profileImageList.lastIndex){
                delegate.onTapTask()
            }else{
                delegate.onTapProfileDetail()
            }
        }

    }

}
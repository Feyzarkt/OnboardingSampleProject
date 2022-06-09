package com.feyzaurkut.onboardingsampleproject.ui.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.feyzaurkut.onboardingsampleproject.R
import com.feyzaurkut.onboardingsampleproject.databinding.ItemOnboardingBinding

class OnBoardingAdapter(private val onBoardingItems: List<OnBoardingItem>)
    : RecyclerView.Adapter<OnBoardingAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(onBoardingItem: OnBoardingItem) {
            binding.ivImage.setImageResource(onBoardingItem.onBoardingImage)
            binding.tvTitle.text = onBoardingItem.title
            binding.tvDescription.text = onBoardingItem.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingAdapter.ViewHolder {
        val itemBinding = LayoutInflater.from(parent.context).inflate(R.layout.item_onboarding, parent, false)
        return ViewHolder(ItemOnboardingBinding.bind(itemBinding))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(onBoardingItems[position])
    }

    override fun getItemCount(): Int {
        return onBoardingItems.size
    }
}
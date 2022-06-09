package com.feyzaurkut.onboardingsampleproject.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.feyzaurkut.onboardingsampleproject.R
import com.feyzaurkut.onboardingsampleproject.databinding.FragmentOnboardingBinding
import com.feyzaurkut.onboardingsampleproject.util.SharedPreferences

class OnBoardingFragment : Fragment() {

    private lateinit var onBoardingAdapter: OnBoardingAdapter
    private lateinit var binding: FragmentOnboardingBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentOnboardingBinding.inflate(inflater)

        initAdapter()
        initListeners()
        setCurrentIndicator(0)
        initViewPagerListener()

        return binding.root
    }

    private fun initAdapter(){
        onBoardingAdapter = OnBoardingAdapter(
            listOf(
                OnBoardingItem(
                    R.drawable.ic_travel1,
                    requireContext().getString(R.string.on_boarding_title1),
                    requireContext().getString(R.string.description1)
                ),
                OnBoardingItem(
                    R.drawable.ic_travel2,
                    requireContext().getString(R.string.on_boarding_title2),
                    requireContext().getString(R.string.description2)
                ),
                OnBoardingItem(
                    R.drawable.ic_travel3,
                    requireContext().getString(R.string.on_boarding_title3),
                    requireContext().getString(R.string.description3)
                )
            )
        )
        binding.viewPager.adapter = onBoardingAdapter
    }

    private fun setCurrentIndicator(position: Int){
        val childCount = binding.llIndicators.childCount
        for(i in 0 until childCount){
            val imageView = binding.llIndicators.getChildAt(i) as ImageView
            if(i == position)
                imageView.setImageResource(R.drawable.indicator_active_background)
            else
                imageView.setImageResource(R.drawable.indicator_inactive_background)
        }
    }

    private fun initListeners(){
        binding.btnNext.setOnClickListener {
            if(binding.viewPager.currentItem +1 < onBoardingAdapter.itemCount-1)
                binding.viewPager.currentItem += 1
            else if(binding.viewPager.currentItem +1 < onBoardingAdapter.itemCount){
                finishIsVisible(true)
                binding.viewPager.currentItem += 1
            }
        }
        binding.btnFinish.setOnClickListener {
            SharedPreferences(requireContext()).putBoolean(true)
            findNavController().navigate(R.id.action_onboardingFragment_to_homeFragment)
        }
        binding.btnSkip.setOnClickListener {
            SharedPreferences(requireContext()).putBoolean(true)
            findNavController().navigate(R.id.action_onboardingFragment_to_homeFragment)
        }
        binding.ivFirst.setOnClickListener {
            binding.viewPager.currentItem = 0
        }
        binding.ivSecond.setOnClickListener {
            binding.viewPager.currentItem = 1
        }
        binding.ivThird.setOnClickListener {
            binding.viewPager.currentItem = 2
        }
    }

    private fun initViewPagerListener(){
        binding.viewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
                if(binding.viewPager.currentItem +1 < onBoardingAdapter.itemCount){
                    finishIsVisible(false)
                }
                else finishIsVisible(true)
            }
        })
        (binding.viewPager.getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }

    private fun finishIsVisible(isVisible: Boolean){
        if(isVisible){
            binding.btnNext.visibility = View.GONE
            binding.btnSkip.visibility = View.GONE
            binding.btnFinish.visibility = View.VISIBLE
        }
        else{
            binding.btnNext.visibility = View.VISIBLE
            binding.btnSkip.visibility = View.VISIBLE
            binding.btnFinish.visibility = View.GONE
        }
    }
    
}
package com.feyzaurkut.onboardingsampleproject.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.feyzaurkut.onboardingsampleproject.R

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //val isVisited = context?.let { SharedPref(it).getBooleanVisitOnBoarding() }

        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_onboardingFragment)
            /* if(isVisited == true)
                 observeDatabase()
             else
                 findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToOnBoardingFragment())
         */}, 3000)

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

}
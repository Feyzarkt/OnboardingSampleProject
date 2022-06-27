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
import com.feyzaurkut.onboardingsampleproject.util.SharedPreferences

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val isVisited = context?.let { SharedPreferences(it).getBoolean() }

        Handler(Looper.getMainLooper()).postDelayed({
            if (isVisited == true) findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            else findNavController().navigate(R.id.action_splashFragment_to_onboardingFragment)
        }, 2000)

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

}
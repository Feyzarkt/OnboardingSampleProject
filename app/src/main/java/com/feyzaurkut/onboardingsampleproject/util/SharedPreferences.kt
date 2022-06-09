package com.feyzaurkut.onboardingsampleproject.util

import android.content.Context
import android.content.SharedPreferences
import com.feyzaurkut.onboardingsampleproject.util.Constants.SHARED_PREF_ONBOARDING

class SharedPreferences(private val context: Context) {

    private fun createPreferences(): SharedPreferences? {
        return context.getSharedPreferences(Constants.FILE_NAME, Context.MODE_PRIVATE)
    }

    private fun createEditor(): SharedPreferences.Editor? {
        val preferences = createPreferences()
        return preferences?.edit()
    }

    fun putBoolean(value: Boolean){
        createEditor()?.putBoolean(SHARED_PREF_ONBOARDING, value)?.apply()
    }

    fun getBoolean(): Boolean{
        return createPreferences()?.getBoolean(SHARED_PREF_ONBOARDING, false) ?: false
    }

}
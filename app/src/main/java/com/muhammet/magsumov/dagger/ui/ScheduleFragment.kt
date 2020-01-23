package com.muhammet.magsumov.dagger.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dagger.R

class ScheduleFragment : Fragment() {

    companion object {
        val TAG: String = ScheduleFragment::class.java.simpleName
        fun newInstance() = ScheduleFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title =getString(R.string.title_schedule)
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }
}
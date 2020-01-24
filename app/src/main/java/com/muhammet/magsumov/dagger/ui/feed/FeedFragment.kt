package com.muhammet.magsumov.dagger.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dagger.R

class FeedFragment : Fragment() {

    companion object {
        val TAG: String = FeedFragment::class.java.simpleName
        fun newInstance() = FeedFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = getString(R.string.title_feed)
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }
}
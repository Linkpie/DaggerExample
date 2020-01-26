package com.muhammet.magsumov.dagger.ui.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import com.example.dagger.R
import com.example.dagger.databinding.FragmentScheduleBinding
import kotlinx.android.synthetic.main.toolbar.*

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
        val viewModel: ScheduleViewModel = ViewModelProviders.of(this,ScheduleViewModelFactory()).get(ScheduleViewModel::class.java)

        val binding: FragmentScheduleBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_schedule, container, false)

        binding.viewModel=viewModel

        observeViewModel(viewModel,binding)


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        toolbar.setTitle(R.string.title_schedule)
    }

    private fun observeViewModel(viewModel: ScheduleViewModel, binding: FragmentScheduleBinding) {


        viewModel.sessions.observe(this, Observer {sessions->
            binding.textView.let {
                val sb=StringBuilder()
                sessions.forEach{ sessions ->
                    sb.append("${sessions.title} by ${sessions.speakers.joinToString( ", ")}")
                }
                it.text=sb.toString()
            }

        })

        viewModel.isLoading.observe(this, Observer { isLoading ->
            if (isLoading!!) binding.textView.text = getString(R.string.loading)
        })
    }
}
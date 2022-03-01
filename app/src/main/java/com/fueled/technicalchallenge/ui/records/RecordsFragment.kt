package com.fueled.technicalchallenge.ui.records

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.flowWithLifecycle
import com.fueled.technicalchallenge.R
import com.fueled.technicalchallenge.databinding.FragmentRecordsBinding
import com.fueled.technicalchallenge.ui.base.BindFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class RecordsFragment : Fragment() {

    private val binding: FragmentRecordsBinding by BindFragment(R.layout.fragment_records)
    private val recordsAdapter: RecordsAdapter = RecordsAdapter()
    private val viewModel: RecordsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setupView()
        observeState()
        return binding.root
    }

    private fun setupView() {
        binding.recordRv.adapter = recordsAdapter
    }

    private fun observeState() {
        viewModel.state
            .flowWithLifecycle(
                lifecycle = viewLifecycleOwner.lifecycle,
                minActiveState = Lifecycle.State.STARTED
            )
            .onEach(::onViewStateUpdate)
            .launchIn(viewLifecycleOwner.lifecycle.coroutineScope)
    }

    private fun onViewStateUpdate(state: RecordsState) {
        binding.state = state
    }
}

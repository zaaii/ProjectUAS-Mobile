package com.zai.movieku.ui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.zai.movieku.R
import com.zai.movieku.databinding.FragmentTvBinding

class TvFragment : Fragment() {

    private val viewModel: TvViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTvBinding.inflate(inflater)
        viewModel.getTvList()
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.recyclerView.adapter = TvAdapter(TvListener { tvs ->
            viewModel.onTvClicked(tvs)
            findNavController()
                .navigate(R.id.action_tvFragment_to_tvDetailsFragment)
        })

        (activity as AppCompatActivity).supportActionBar?.title = "MovieKu"

        return binding.root
    }
}
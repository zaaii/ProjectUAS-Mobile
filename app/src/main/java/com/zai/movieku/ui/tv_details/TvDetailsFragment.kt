package com.zai.movieku.ui.tv_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.zai.movieku.R
import com.zai.movieku.databinding.MainFragmentDetailsBinding
import com.zai.movieku.databinding.TvFragmentDetailsBinding
import com.zai.movieku.ui.movies.MoviesViewModel
import com.zai.movieku.ui.tv.TvViewModel

class TvDetailsFragment : Fragment() {

    private val viewModel : TvViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstancesState: Bundle?
    ): View? {
        val binding = TvFragmentDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        (activity as AppCompatActivity).supportActionBar?.title = viewModel.tv.value?.title
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> findNavController().navigate(R.id.action_tvDetailFragment_to_tvFragment)
        }
        return true
    }
}
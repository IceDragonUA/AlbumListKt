package com.rnd.app.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rnd.app.databinding.FragmentDetailBinding
import com.rnd.app.extension.loadFromUrl

class DetailFragment : Fragment() {

    private var binding: FragmentDetailBinding? = null
    private val rootView get() = binding!!.root

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.image?.loadFromUrl(DetailFragmentArgs.fromBundle(requireArguments()).url)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

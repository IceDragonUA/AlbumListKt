package com.rnd.app.ui.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.rnd.app.common.base.AdapterItemClickListener
import com.rnd.app.databinding.FragmentAlbumBinding
import com.rnd.domain.core.ResultModel
import com.rnd.domain.model.Album

class AlbumFragment : Fragment(), AdapterItemClickListener<Album> {

    private var binding: FragmentAlbumBinding? = null
    private val rootView get() = binding!!.root

    private val viewModel: AlbumViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlbumBinding.inflate(inflater, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.list?.setListener(this)
        viewModel.items.observe(viewLifecycleOwner, { result ->
            when (result.status) {
                ResultModel.Status.LOADING -> {
                    binding?.loading?.visibility = View.VISIBLE
                }
                ResultModel.Status.SUCCESS -> {
                    binding?.loading?.visibility = View.GONE
                    result.data?.let {
                        binding?.list?.setItems(it)
                    }
                }
                ResultModel.Status.ERROR -> {
                    binding?.loading?.visibility = View.VISIBLE
                }
            }
        })
        viewModel.getAlbums()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onClicked(item: Album) {
        findNavController().navigate(
            AlbumFragmentDirections.actionAlbumFragmentToPhotoFragment(item.userId)
        )
    }
}

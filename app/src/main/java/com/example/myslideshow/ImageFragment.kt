package com.example.myslideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myslideshow.databinding.FragmentImageBinding

private const val IMG_RES_ID = "IMG_RES_ID"

class ImageFragment : Fragment() {
    private var imageResId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageResId = it.getInt(IMG_RES_ID)
        }
    }

    private var _binding: FragmentImageBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(imageResId: Int) =
            ImageFragment().apply {
                arguments = Bundle().apply {
                    putInt(IMG_RES_ID, imageResId)
                }
            }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        imageResId?.let {
            binding.imageView.setImageResource(it)
        }
    }
}
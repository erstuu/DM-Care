package com.health.dmcare.adapter.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.health.dmcare.R

class FootExercisePageFragment : Fragment() {
    private var imageResId: Int? = null
    private var description: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageResId = it.getInt(ARG_IMAGE_RES_ID)
            description = it.getString(ARG_DESCRIPTION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_foot_exercise_page, container, false)
        val imageView: ImageView = view.findViewById(R.id.imageViewExercise)
        val textView: TextView = view.findViewById(R.id.textViewDescription)

        imageResId?.let { imageView.setImageResource(it) }
        textView.text = description

        return view
    }

    companion object {
        private const val ARG_IMAGE_RES_ID = "image_res_id"
        private const val ARG_DESCRIPTION = "description"

        fun newInstance(imageResId: Int, description: String): FootExercisePageFragment {
            return FootExercisePageFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_IMAGE_RES_ID, imageResId)
                    putString(ARG_DESCRIPTION, description)
                }
            }
        }
    }
}
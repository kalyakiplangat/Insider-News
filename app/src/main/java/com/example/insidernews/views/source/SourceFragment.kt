package com.example.insidernews.views.source


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.insidernews.R
import io.reactivex.disposables.CompositeDisposable

/**
 * A simple [Fragment] subclass.
 */
class SourceFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var source
    private lateinit var disposable: CompositeDisposable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_source, container, false)

        return rootView
    }


}

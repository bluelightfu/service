package com.example.testing.ui.main

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.testing.R
import com.example.testing.Service

class MainFragment : Fragment() {

    lateinit var startButton:Button
    lateinit var stopButton:Button
    var serviceIntent:Intent? = null
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        startButton = view.findViewById(R.id.start)
        stopButton = view.findViewById(R.id.stop)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        serviceIntent = Intent(context, Service::class.java)

        startButton.setOnClickListener {
            Toast.makeText(requireActivity(),"start",Toast.LENGTH_LONG).show()
            requireActivity().startService(serviceIntent)
        }
        stopButton.setOnClickListener {
            requireActivity().stopService(serviceIntent)
        }
        // TODO: Use the ViewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        requireActivity().stopService(serviceIntent)
    }
}
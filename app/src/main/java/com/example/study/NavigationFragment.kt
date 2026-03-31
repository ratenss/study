package com.example.study

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.study.databinding.FragmentNavigationBinding

class NavigationFragment : Fragment() {

    private var _binding: FragmentNavigationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentNavigationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCallbacks.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, CallbackFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.btnEventBus.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, EventBusFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.btnIntentFlags.setOnClickListener {
            val intent = Intent(requireContext(), SecondActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }

        binding.btnBackStack.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentA())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.study

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.study.databinding.FragmentCallbackBinding

class CallbackFragment : Fragment() {

    private var _binding: FragmentCallbackBinding? = null
    private val binding get() = _binding!!

    // 1. Объявляем интерфейс для коллбэков
    interface OnDataPassListener {
        fun onDataPass(data: String)
    }

    private var listener: OnDataPassListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCallbackBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val data = binding.editText.text.toString()
            if (data.isNotBlank()) {
                listener?.onDataPass(data)
            } else {
                Toast.makeText(requireContext(), "Введите данные", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // 2. Присоединяем активити как слушатель
    override fun onAttach(context: android.content.Context) {
        super.onAttach(context)
        if (context is OnDataPassListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnDataPassListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
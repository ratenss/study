package com.example.study

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.study.databinding.FragmentEventBusBinding
import org.greenrobot.eventbus.EventBus

class EventBusFragment : Fragment() {

    private var _binding: FragmentEventBusBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentEventBusBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSend.setOnClickListener {
            val text = binding.editText.text.toString()
            if (text.isNotBlank()) {
                EventBus.getDefault().post(MessageEvent(text))
                Toast.makeText(requireContext(), "Событие отправлено", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Введите текст", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
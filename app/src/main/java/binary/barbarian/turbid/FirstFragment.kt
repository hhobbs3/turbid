package binary.barbarian.turbid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import binary.barbarian.turbid.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private fun countMe(view: View) {
        // Get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
        // Get the value of the text view
        val countString = showCountTextView.text.toString()
        var count = countString.toInt()
        count++
        // Display the new value in the text view.
        showCountTextView.text = count.toString()
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.randomButton.setOnClickListener {
            val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
            val currentCount = showCountTextView.text.toString().toInt()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
            findNavController().navigate(action)
        }

        binding.toastButton.setOnClickListener {
            val myToast = Toast.makeText(context, getString(R.string.toast_text), Toast.LENGTH_SHORT)
            myToast.show()
        }

        binding.countButton.setOnClickListener{
            countMe(view)
        }
    }





    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
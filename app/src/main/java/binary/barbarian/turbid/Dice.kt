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
class Dice : Fragment() {

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

    private fun rollDice(view: View, textId: Int, diceSize: Int) {
        // Get the text view
        val showDiceTextView = view.findViewById<TextView>(textId)
        val random = java.util.Random()
        var randomNumber = 0
        if (diceSize > 0) {
            randomNumber =  (1..diceSize).random() //random.nextInt(diceSize + 1)
        }
        //var roll = countString.toInt()

        // Display the new value in the text view.
        showDiceTextView.text = randomNumber.toString()
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
            val action = DiceDirections.actionFirstFragmentToSecondFragment(currentCount)
            findNavController().navigate(action)
        }

        binding.toastButton.setOnClickListener {
            val myToast = Toast.makeText(context, getString(R.string.toast_text), Toast.LENGTH_SHORT)
            myToast.show()
        }

        binding.countButton.setOnClickListener{
            countMe(view)
        }

        binding.d100Button.setOnClickListener{

            rollDice(view, R.id.textview_first_d100, 100)
        }
        binding.d20Button.setOnClickListener{
            rollDice(view, R.id.textview_first_d20, 20)
        }
        binding.d12Button.setOnClickListener{
            rollDice(view, R.id.textview_first_d12, 12)
        }
        binding.d10Button.setOnClickListener{
            rollDice(view, R.id.textview_first_d10, 10)
        }
        binding.d8Button.setOnClickListener {
            rollDice(view, R.id.textview_first_d8, 8)
        }
        binding.d6Button.setOnClickListener{
            rollDice(view, R.id.textview_first_d6, 6)
        }
        binding.d4Button.setOnClickListener{
            rollDice(view, R.id.textview_first_d4, 4)
        }
        binding.d2Button.setOnClickListener{
            rollDice(view, R.id.textview_first_d2, 2)
        }
    }





    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
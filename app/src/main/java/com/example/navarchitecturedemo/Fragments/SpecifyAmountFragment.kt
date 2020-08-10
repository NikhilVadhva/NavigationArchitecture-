package com.example.navarchitecturedemo.Fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navarchitecturedemo.R
import kotlinx.android.synthetic.main.fragment_specify.*



class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController
    private lateinit var recipient: String
    val args: SpecifyAmountFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()
        view.findViewById<Button>(R.id.send_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
        recipient = args.recipient
        val message = "Sending money to $recipient"
        view.findViewById<TextView>(R.id.recipient).setText(message)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.send_btn -> {
                if (!TextUtils.isEmpty(input_amount.text.toString())) {
                    val amount = input_amount.text.toString().toInt()
                    val action =
                        SpecifyAmountFragmentDirections.confirmationAction(recipient, amount)
                    navController.navigate(action)
                }
                else{
                     Toast.makeText(requireActivity(),"Enter an amount",Toast.LENGTH_LONG).show()
                }

            }
            R.id.cancel_btn -> requireActivity().onBackPressed()
        }
    }

}
package com.example.navarchitecturedemo.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.navarchitecturedemo.R


class ConfirmationFragment : Fragment() {

    lateinit var recipient : String
    private var  amount : Int = 0

    val args: ConfirmationFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipient = args.recipient
        amount = args.amount

        val confirmationMsg= "You have sent $ $amount to $recipient"
        view.findViewById<TextView>(R.id.confirmation_message).text = confirmationMsg


    }

}
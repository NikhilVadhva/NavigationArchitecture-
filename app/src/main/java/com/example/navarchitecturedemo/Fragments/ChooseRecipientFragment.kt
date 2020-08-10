package com.example.navarchitecturedemo.Fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.navarchitecturedemo.R
import kotlinx.android.synthetic.main.fragment_choose_recipient.*


class ChooseRecipientFragment : Fragment() , View.OnClickListener{

    private lateinit var navController : NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()
        view.findViewById<Button>(R.id.btNext).setOnClickListener(this)
        view.findViewById<Button>(R.id.btCancel).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id)
        {
             R.id.btNext ->
             {
                 if(!TextUtils.isEmpty(input_recipient.text.toString()))
                 {
                      val recipient = input_recipient.text.toString().trim()
                      val action = ChooseRecipientFragmentDirections.specifyAction(recipient)
                     navController.navigate(action)
                 }
                 else{
                     Toast.makeText(requireActivity(),"Enter a recipient", Toast.LENGTH_LONG).show()
                 }
             }
             R.id.btCancel -> requireActivity().onBackPressed()
        }
    }


}
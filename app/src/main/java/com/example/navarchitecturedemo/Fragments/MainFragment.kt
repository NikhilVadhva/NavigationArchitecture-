package com.example.navarchitecturedemo.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.navarchitecturedemo.R

class MainFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        view.findViewById<Button>(R.id.btViewTransaction).setOnClickListener(this)
        view.findViewById<Button>(R.id.btSendMoney).setOnClickListener(this)
        view.findViewById<Button>(R.id.btViewBalance).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btViewTransaction -> navController.navigate(R.id.action_mainFragment_to_viewTransactionFragment)
            R.id.btSendMoney -> navController.navigate(R.id.action_mainFragment_to_chooseRecipientFragment)
            R.id.btViewBalance -> navController.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
        }

    }


}
package com.anupras.apl.tddmvvmsample.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.anupras.apl.tddmvvmsample.R

/**
 * Created by Anamika Painuly on 11/05/21.
 */
class ShoppingFragment : Fragment(R.layout.shopping_fragment) {


    lateinit var  viewModel: ShoppingViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ShoppingViewModel::class.java)

    }

}
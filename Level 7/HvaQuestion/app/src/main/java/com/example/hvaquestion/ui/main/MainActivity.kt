package com.example.hvaquestion.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.hvaquestion.R

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initNavigation()

    }

   private fun initNavigation(){
       val navController = findNavController(R.id.navHostFragment)

        val appBarConfiguration = AppBarConfiguration(navController.graph)

       NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration)
   }
}

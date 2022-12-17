package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber
import com.udacity.shoestore.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
       private lateinit var appBarConfiguration:AppBarConfiguration
      override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
            Timber.plant(Timber.DebugTree())
            Timber.i("in activity main onCreate")
            val navController = this.findNavController(R.id.nav_host_fragment_container);
            appBarConfiguration = AppBarConfiguration(navController.graph);
            val toolbar=binding.toolbar
            setSupportActionBar(toolbar)
            setupActionBarWithNavController(navController,appBarConfiguration)
      }


    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment_container).navigateUp(appBarConfiguration)
    }
}

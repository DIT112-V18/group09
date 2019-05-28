package com.group9.dora

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothClass
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main.*
import me.aflak.bluetooth.Bluetooth
import android.bluetooth.BluetoothDevice
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import me.aflak.bluetooth.DeviceCallback
import java.lang.Compiler.enable




class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        var fragment: Fragment = fragment_mapping()

        when (item.itemId) {
            R.id.navigation_mapping -> {
                fragment = fragment_mapping()
            }
            R.id.navigation_manual -> {
                fragment = fragment_manualcontrols()
            }
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.subtitle = "Group 09 (Team \uD83D\uDC3F)"

        initBluetooth()

        navigation.itemIconTintList = resources.getColorStateList(R.color.colorWhite)
        navigation.itemTextColor = resources.getColorStateList(R.color.colorWhite)
        navigation.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment_mapping())
            .commit()
    }

    fun initBluetooth(){
        BT.init(this,this)
    }

    override fun onStop() {
        super.onStop()
        BT.bluetooth.unRegister()
    }
}
package com.sejarahandroidkel3

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.BatteryManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ArchitectureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_architecture)

        val appName = "Application\n($packageName)"
        findViewById<TextView>(R.id.tvAppLayer).text = appName

        val frameworkInfo = "Application Framework\n(API Level ${Build.VERSION.SDK_INT})"
        findViewById<TextView>(R.id.tvFrameworkLayer).text = frameworkInfo

        val vmVersion = System.getProperty("java.vm.version") ?: "Unknown"
        val artInfo = "Android Runtime (ART)\n(VM Version: $vmVersion)"
        findViewById<TextView>(R.id.tvArtLayer).text = artInfo

        val cpuArch = Build.SUPPORTED_ABIS[0]
        val libsInfo = "Libraries\n(CPU: $cpuArch)"
        findViewById<TextView>(R.id.tvLibsLayer).text = libsInfo

        val kernelOs = System.getProperty("os.version") ?: "Unknown"
        val kernelInfo = "Linux Kernel\n(Versi: $kernelOs)"
        findViewById<TextView>(R.id.tvKernelLayer).text = kernelInfo

        findViewById<TextView>(R.id.tvVersion).text = "Android Version: ${Build.VERSION.RELEASE}"
        findViewById<TextView>(R.id.tvModel).text = "Device Model: ${Build.MODEL}"
        findViewById<TextView>(R.id.tvBrand).text = "Manufacturer/Brand: ${Build.MANUFACTURER}"

        val kernelVersion = System.getProperty("os.version") ?: "Unknown"
        findViewById<TextView>(R.id.tvKernel).text = "Kernel Version: $kernelVersion"

        val batteryManager = getSystemService(Context.BATTERY_SERVICE) as BatteryManager
        val batLevel = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
        findViewById<TextView>(R.id.tvBattery).text = "Battery Level: $batLevel%"

        findViewById<TextView>(R.id.tvNetwork).text = "Network Status: ${getNetworkStatus()}"

        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun getNetworkStatus(): String {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = cm.activeNetwork ?: return "Offline"
        val capabilities = cm.getNetworkCapabilities(network) ?: return "Offline"

        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> "WIFI"
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> "Cellular"
            else -> "Connected (Lainnya)"
        }
    }
}
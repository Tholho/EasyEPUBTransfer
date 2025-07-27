package com.example.easyepubtransfer.data.repository

import android.content.Context
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbManager
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UsbRepository(private val context: Context) {
    private val usbManager = context.getSystemService(Context.USB_SERVICE) as UsbManager
    private val ereaderVendorIds = listOf<Int>()

    suspend fun scanDevices(): List<UsbDevice> = withContext(Dispatchers.IO) {
        Log.d("UsbRepository", "Starting USB device scan...")
        val deviceList = usbManager.deviceList
        Log.d("UsbRepository", "Found ${deviceList.size} devices in deviceList")

        deviceList.values.forEach { device ->
            Log.d("UsbRepository", "Device: ${device.productName ?: "Unknown"}, VendorID: ${device.vendorId}, ProductID: ${device.productId}")
        }

        deviceList.values.toList()
    }

    suspend fun scanForEReaders(): UsbDevice? {
        //TODO
        //define ereader filters
        //loop through list of devices and check against filters -- getVendorId()
        //return device
        return null
    }

    fun isEReaderDevice(device: UsbDevice): Boolean {
        //TODO
        //Check vendor id -- getVendorId() vs hashmap(?)
        return false
    }
}
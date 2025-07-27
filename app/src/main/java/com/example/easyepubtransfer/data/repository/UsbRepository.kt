package com.example.easyepubtransfer.data.repository

import android.content.Context
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbManager
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers

class UsbRepository(private val context: Context) {
    private val usbManager = context.getSystemService(Context.USB_SERVICE) as UsbManager

    suspend fun scanDevices(): List<UsbDevice> = withContext(Dispatchers.IO) {
        usbManager.deviceList.values.toList()
    }
}
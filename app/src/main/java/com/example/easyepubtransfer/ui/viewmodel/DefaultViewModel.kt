package com.example.easyepubtransfer.ui.viewmodel

import android.hardware.usb.UsbDevice
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.easyepubtransfer.data.repository.UsbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DefaultViewModel @Inject constructor(
    private val usbRepository: UsbRepository
): ViewModel() {
    private val _usbDevices = MutableLiveData<List<UsbDevice>>()
    val usbDevices: LiveData<List<UsbDevice>> = _usbDevices

    private val _isScanning = MutableLiveData<Boolean>()
    val isScanning: LiveData<Boolean> = _isScanning

    fun scanForUsbDevices() {
        viewModelScope.launch {
            _isScanning.value = true
            try {
                val devices = usbRepository.scanDevices()
                _usbDevices.value = devices
            } catch (e: Exception) {
                // Handle
            } finally {
                _isScanning.value = false
            }
        }
    }
}
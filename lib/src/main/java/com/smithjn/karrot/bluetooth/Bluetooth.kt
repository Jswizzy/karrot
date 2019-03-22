package com.smithjn.karrot.bluetooth

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import com.smithjn.karrot.extensions.OnActivityResult
import com.smithjn.karrot.extensions.REQUEST_ENABLE_BLUETOOTH
import com.smithjn.karrot.extensions.startResult

fun AppCompatActivity.bluetoothLESupported(): Boolean =
    packageManager.hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)

fun getBluetoothAdapter(): Result<BluetoothAdapter> {
    val adapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
    return if (adapter != null) {
        Result.success(adapter)
    } else {
        Result.failure(BluetoothNotSupported("Bluetooth Not Supported On this device"))
    }
}

fun AppCompatActivity.enableBluetooth(
    bluetoothAdapter: BluetoothAdapter,
    requestCode: Int = REQUEST_ENABLE_BLUETOOTH
): OnActivityResult {
    if (!bluetoothAdapter.isEnabled) {
        startResult(Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE), requestCode)
    }
    return OnActivityResult(requestCode)
}

class BluetoothNotSupported(message: String? = null): Throwable(message)
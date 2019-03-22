package com.smithjn.karrot.extensions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.startResult(intent: Intent, requestCode: Int): OnActivityResult {
    startActivityForResult(intent, requestCode)
    return OnActivityResult(requestCode)
}

class OnActivityResult(private val requestCode: Int) {
    operator fun invoke(callback: (Int) -> Unit ) {
        callback(requestCode)
    }
}

// Constants
internal const val REQUEST_ENABLE_BLUETOOTH = 1
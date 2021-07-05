package com.freshworks.giphy.helper

import com.bumptech.glide.util.Util.isOnMainThread
import com.freshworks.giphy.repository.model.GiphyModel

typealias GiphyModelList = List<GiphyModel>

//If callback is on ui thread, run the callback through thread, otherwise run  immediately
fun ensureBackgroundThread(callback: () -> Unit) {
    if (isOnMainThread()) {
        Thread {
            callback()
        }.start()
    } else {
        callback()
    }
}
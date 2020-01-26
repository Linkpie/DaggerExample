package com.magsumov.inc.tv

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.leanback.app.BrowseFragment

private const val TAG = "MainFragment"

class MainFragment : BrowseFragment() {

    @SuppressLint("NewApi")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate")
        super.onActivityCreated(savedInstanceState)

        title = getString(R.string.browse_title)
        badgeDrawable = ContextCompat.getDrawable(context, R.drawable.ic_banner)
        headersState = BrowseFragment.HEADERS_DISABLED
    }
}
package com.example.webview

import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Initialize the WebView
        webView = findViewById(R.id.webview)

        // Enable JavaScript
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true  // Enable JavaScript

        // Enable local storage (for websites that store data locally)
        webSettings.domStorageEnabled = true

        // Prevent opening in the default browser
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return false
            }
        }

        // Load the website
        webView.loadUrl("https://www.canva.com/")

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (webView.canGoBack()) {
                    webView.goBack()  // Navigate back in WebView history
                } else {
                    isEnabled = false  // Disable this callback if no history in WebView
                    onBackPressedDispatcher.onBackPressed()  // Use system back press behavior
                }
            }
        })

    }

}
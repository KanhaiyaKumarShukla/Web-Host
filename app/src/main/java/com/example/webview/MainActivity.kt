package com.example.webview

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
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

        // Prevent opening in the default browser
        webView.webViewClient = WebViewClient()

        // Load the website
        webView.loadUrl("https://www.canva.com/en_in/?msockid=3dc01166608660ed1b37021c61f16127")

    }
}
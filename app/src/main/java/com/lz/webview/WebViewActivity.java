package com.lz.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    private WebView mwebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mwebView = findViewById(R.id.wv_webview);
        //mwebView.loadUrl("file:///android_asset/sample.html”);

        setWebViewSetting();
    }

    private void setWebViewSetting() {
        WebSettings webSettings = mwebView.getSettings();
        // 设置支持JS or Flash
        webSettings.setJavaScriptEnabled(true);// 启用js
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);// js和android交互
        webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setAllowFileAccess(true); // 允许访问文件
        webSettings.setDefaultTextEncodingName("UTF-8");// 设置字符编码
        webSettings.setBuiltInZoomControls(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);// 设置，可能的话使所有列的宽度不超过屏幕宽度NARROW_COLUMNS
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setLoadWithOverviewMode(true);// 设置webview自适应屏幕大小
        webSettings.setDomStorageEnabled(true);// 设置可以使用localStorage
        webSettings.setDefaultFontSize(40);// 设置默认的字体大小，默认为16，有效值区间在1-72之间。
        // mWebView.getSettings().setBlockNetworkImage(true);
        // mwebView.setWebViewClient(new MyWebviewClient());
        mwebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress >= 100) {
                    // 切换页面
                    // if (progressBar.isShowing()) { // 将对话框隐藏
                    // progressBar.dismiss();
                    // }
                }
            }
        });
        mwebView.loadData("", "text/html", "UTF-8");
        mwebView.loadUrl("file:///android_asset/jksz/index.html");
    }
}

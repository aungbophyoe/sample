package com.example.bottomnav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toolbar;

public class webview extends AppCompatActivity {

    private WebView web;
    private ProgressBar pgbar;
    private TextView title;
    private ImageButton back,close;
    private SwipeRefreshLayout swiply;
    private int c1,c2,c3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        setUi();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(web.canGoBack()){
                    web.goBack();
                } else {
                    finish();
                }
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        swiply.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        web.reload();
                        swiply.setRefreshing(false);
                    }
                },2000);
            }
        });
    }

    private void setUi() {
        web=findViewById(R.id.webview);
        pgbar=findViewById(R.id.pgbar);
        title=findViewById(R.id.webtxt);
        back=findViewById(R.id.webback);
        close=findViewById(R.id.webclose);
        swiply=findViewById(R.id.swiply);
        getColorforswipe();
        swiply.setColorSchemeColors(c1,c2,c3);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("https://www.google.com/");
        web.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                pgbar.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                pgbar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });
        web.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                pgbar.setProgress(newProgress);
            }
        });
    }

    private void getColorforswipe() {
        c1=getResources().getColor(R.color.refresh1);
        c2=getResources().getColor(R.color.refresh2);
        c3=getResources().getColor(R.color.refresh3);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.web.canGoBack()) {
            this.web.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

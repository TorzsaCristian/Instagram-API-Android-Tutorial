package com.siteoftutorials.instagramapitutorial.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.siteoftutorials.instagramapitutorial.dialog.AuthenticationDialog;
import com.siteoftutorials.instagramapitutorial.listener.AuthenticationListener;
import com.siteoftutorials.instagramapitutorial.R;

public class MainActivity extends AppCompatActivity implements AuthenticationListener {

    private AuthenticationDialog auth_dialog;
    private Button btn_get_access_token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_get_access_token = (Button) findViewById(R.id.btn_get_access_token);

        btn_get_access_token.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth_dialog = new AuthenticationDialog(MainActivity.this, MainActivity.this);
                auth_dialog.setCancelable(true);
                auth_dialog.show();
            }
        });
    }

    @Override
    public void onCodeReceived(String access_token) {
        if (access_token == null) {
            auth_dialog.dismiss();
        }

        Intent i = new Intent(MainActivity.this, FeedActivity.class);
        i.putExtra("access_token", access_token);
        startActivity(i);

    }
}

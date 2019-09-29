package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private TextView tx;
    private Button bt;
    private Integer count = 0;
    OkHttpClient client = new OkHttpClient();

    String runs(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx = findViewById(R.id.tx);
        bt = findViewById(R.id.bt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                final QMUIDialog.MessageDialogBuilder messageDialogBuilder = new QMUIDialog.MessageDialogBuilder(MainActivity.this);
//                messageDialogBuilder.setMessage("this is adialog").show();
                Intent in = new Intent(MainActivity.this,Second.class);
                startActivity(in);

//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            try {
//                                final String  content = runs("https://api.apiopen.top/getImages");
//                                tx.post(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        tx.setText(content);
//                                    }
//                                });
//
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }).start();
            }
        });

    }

}

package com.example.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private TextView tx;
    private Button bt;
    private Integer count = 0;
    
    OkHttpClient client = new OkHttpClient();
    private SharedPreferences data;

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
//改变状态栏颜色
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryBar));

        setContentView(R.layout.activity_main);
        final SharedPreferences data = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = data.edit();
        edit.putString("testKey","this is tes tvalue");
        edit.commit();
        tx = findViewById(R.id.tx);
        bt = findViewById(R.id.bt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String testKey = data.getString("testKey","do not find");
                Toast.makeText(MainActivity.this,testKey,Toast.LENGTH_LONG).show();
//                final QMUIDialog.MessageDialogBuilder messageDialogBuilder = new QMUIDialog.MessageDialogBuilder(MainActivity.this);
//                messageDialogBuilder.setMessage("this is adialog").show();
//                启动其他intent
//                Intent in = new Intent(MainActivity.this,QQlogin.class);
//                in.putExtra("inten exture data","to deliver data to next intent");
//                startActivityForResult(in,1);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "you confired", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "you cancled", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
//子线程获取接口内容
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2){
            String feedback_data = data.getStringExtra("feedback data");
            Toast.makeText(this,feedback_data,Toast.LENGTH_LONG).show();
        }
    }
}

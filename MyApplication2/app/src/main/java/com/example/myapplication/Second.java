package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.qmuiteam.qmui.widget.QMUIAnimationListView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import util.Http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Second extends AppCompatActivity {
    ListView lv;
    public Adapter  ad;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    Log.d("test", "handleMessage: ");
                    ad.notifyDataSetChanged();
                    break;
                 default:
                     break;

            }

        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
			.build();
        ImageLoader.getInstance().init(config);
        QMUIAnimationListView qmuiAnimationListView = (QMUIAnimationListView)findViewById(R.id.lv);
        ad = new Adapter();
        ad.data = new ArrayList<>();
        qmuiAnimationListView.setAdapter(ad);
        new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Map<String,String> param = new HashMap<String,String>(){
                                    {
                                        put("page","1");
                                        put("count","30");
                                    }
                                };
                                Http.getInstance().setToken("werwe");
                                Response response = Http.getInstance().get("https://api.apiopen.top/getImages",param);
                                String content = response.body().string();
                                Gson gson = new Gson();
                                entity nt = gson.fromJson(content,entity.class);
                                Log.d("test",nt.message);
                                ad.data.addAll(nt.result);
                                handler.sendEmptyMessage(0);

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
    }
}

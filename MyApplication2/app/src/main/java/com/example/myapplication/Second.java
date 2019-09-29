package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.ListView;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import okhttp3.Response;
import util.Http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Second extends AppCompatActivity {
    ListView lv;
    public Adapter  ad;
    Context cox;
    private Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    Log.d("test", "handleMessage: ");
                    break;
                default:
                    break;

            }
            return false;
        }
    });
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        cox = getBaseContext();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
			.build();
        ImageLoader.getInstance().init(config);
        ad = new Adapter(this);
        ad.data = new ArrayList<>();
        RecyclerView lv = (RecyclerView)findViewById(R.id.lv);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        lv.setLayoutManager(staggeredGridLayoutManager);
        lv.setAdapter(ad);
        lv.addItemDecoration(new Decoration(cox,10));
//        new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            try {
//                                Map<String,String> param = new HashMap<String,String>(){
//                                    {
//                                        put("page","1");
//                                        put("count","30");
//                                    }
//                                };
//                                Http.getInstance().setToken("werwe");
//                                Response response = Http.getInstance().get("https://api.apiopen.top/getImages",param);
//                                String content = response.body().string();
//                                Gson gson = new Gson();
//                                entity nt = gson.fromJson(content,entity.class);
//                                Log.d("test",nt.message);
//                                ad.data.addAll(nt.result);
//                                handler.sendEmptyMessage(0);
//
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }).start();
    }


}

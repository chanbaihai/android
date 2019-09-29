package com.example.myapplication;

import java.util.List;

public class entity {
    int code;
    String message;
    List<Im> result;
    public entity(int code, String message, List<Im> result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }


}
 class Im {
     int id;
     String time;
     String img;
     public Im(int id, String time, String img) {
         this.id = id;
         this.time = time;
         this.img = img;
     }


}
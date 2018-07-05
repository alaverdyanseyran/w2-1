package com.example.sey.dishies;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    public ArrayList <Dish> dishes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList();
        DishesAdapter ad =new DishesAdapter(this, dishes);
        lv.setAdapter(ad);
       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               String urlString=dishes.get(i).linkUrl.toString();
              // Toast.makeText(MainActivity.this, "kkkkkk",Toast.LENGTH_LONG).show();
               Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
               intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               intent.setPackage("com.android.chrome");
               try {
                   startActivity(intent);
               } catch (ActivityNotFoundException ex) {
                   // Chrome browser presumably not installed so allow user to choose instead
                   intent.setPackage(null);
                   startActivity(intent);
               }
          }
       });


    }

    private void initList() {
    lv=(ListView) findViewById(R.id.dList);
    dishes.add(new Dish("https://cdn.pixabay.com/photo/2015/07/14/18/14/school-845196__340.png", "tolma", "make tolma","http://mail.ru" ));
    dishes.add(new Dish("https://cdn.pixabay.com/photo/2017/01/03/17/04/dragon-1949993__340.png", "harisa", "make harisa", "https://cdn.pixabay.com/photo/2017/01/03/17/04/dragon-1949993__340.png"));
    dishes.add(new Dish("https://cdn.pixabay.com/photo/2016/03/03/17/15/fruit-1234657__340.png", "piccca", "call antanelli", "https://cdn.pixabay.com/photo/2016/03/03/17/15/fruit-1234657__340.png"));

    }
}

package com.example.grocery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.grocery.adapter.RecentlyViewedAdapter;
import com.example.grocery.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;

public class cart extends AppCompatActivity {
    RecyclerView  recentlyViewedRecycler;
    RecentlyViewedAdapter recentlyViewedAdapter;

    List<RecentlyViewed> recentlyViewedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        recentlyViewedRecycler =findViewById(R.id.recently_items);
        //adding data to model
        recentlyViewedList =new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Watermelon","Watermelon has high water content and also provide some fiber.","₹ 80","1","KG",R.drawable.card4,R.drawable.b4));
        recentlyViewedList.add(new RecentlyViewed("Papaya","Papaya has high water content and also provide some fiber.","₹ 30","1","KG",R.drawable.card3,R.drawable.b3));
        recentlyViewedList.add(new RecentlyViewed("strawberry","strawberry has high water content and also provide some fiber.","₹ 85","1","KG",R.drawable.card2,R.drawable.b1));
        recentlyViewedList.add(new RecentlyViewed("Kiwi","Kiwi has high water content and also provide some fiber.","₹ 40","1","Pcs",R.drawable.card1,R.drawable.b2));
        setRecentlyRecycler();
    }

    private void setRecentlyRecycler() {
        RecyclerView.LayoutManager  layoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }
}

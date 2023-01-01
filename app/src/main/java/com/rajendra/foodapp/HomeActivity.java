package com.rajendra.foodapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rajendra.foodapp.adapter.AsiaFoodAdapter;
import com.rajendra.foodapp.adapter.PopularFoodAdapter;
import com.rajendra.foodapp.model.AsiaFood;
import com.rajendra.foodapp.model.PopularFood;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView popularRecycler, asiaRecycler;
    PopularFoodAdapter popularFoodAdapter;
    AsiaFoodAdapter asiaFoodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        // now here we will add some dummy data to out model class

        List<PopularFood> popularFoodList = new ArrayList<>();

        popularFoodList.add(new PopularFood("USA Burger", "7.05 TND", R.drawable.burget));
        popularFoodList.add(new PopularFood("New york burger", "17.05 TND", R.drawable.burget));
        popularFoodList.add(new PopularFood("LA burger", "25.05 TND", R.drawable.burget));
        popularFoodList.add(new PopularFood("Chicago Burger", "7.05 TND", R.drawable.burget));
        popularFoodList.add(new PopularFood("Las Vegas Burger", "17.05 TND", R.drawable.burget));
        popularFoodList.add(new PopularFood("Texas burger", "25.05 TND", R.drawable.burget));

        setPopularRecycler(popularFoodList);


        List<AsiaFood> asiaFoodList = new ArrayList<>();
        asiaFoodList.add(new AsiaFood("Chicago Burger", "20 TND", R.drawable.burget, "4.5", "Briand Restaurant"));
        asiaFoodList.add(new AsiaFood("Chicago Burger", "25 TND", R.drawable.burget, "4.2", "Friends Restaurant"));
        asiaFoodList.add(new AsiaFood("Chicago Burger", "20 TND", R.drawable.burget, "4.5", "Briand Restaurant"));
        asiaFoodList.add(new AsiaFood("Chicago Burger", "25 TND", R.drawable.burget, "4.2", "Friends Restaurant"));
        asiaFoodList.add(new AsiaFood("Chicago Pizza", "20 TND", R.drawable.burget, "4.5", "Briand Restaurant"));
        asiaFoodList.add(new AsiaFood("Straberry Cake", "25 TND", R.drawable.burget, "4.2", "Friends Restaurant"));

        setAsiaRecycler(asiaFoodList);

    }


    private void setPopularRecycler(List<PopularFood> popularFoodList) {

        popularRecycler = findViewById(R.id.popular_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        popularRecycler.setLayoutManager(layoutManager);
        popularFoodAdapter = new PopularFoodAdapter(this, popularFoodList);
        popularRecycler.setAdapter(popularFoodAdapter);

    }

    private void setAsiaRecycler(List<AsiaFood> asiaFoodList) {

        asiaRecycler = findViewById(R.id.asia_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        asiaRecycler.setLayoutManager(layoutManager);
        asiaFoodAdapter = new AsiaFoodAdapter(this, asiaFoodList);
        asiaRecycler.setAdapter(asiaFoodAdapter);

    }
}

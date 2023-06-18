package com.example.recyclarviewbywelfare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recyclarviewbywelfare.Adapters.RecipeAdapter;
import com.example.recyclarviewbywelfare.Classes.RecyclerItemClickListener;
import com.example.recyclarviewbywelfare.Models.RecipeModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclarView);

    //   RecyclerView Code in MainActivity - Items insertion in RecyclerView

        ArrayList<RecipeModel> list = new ArrayList<>();

        list.add(new RecipeModel(R.drawable.food,"Burger"));
        list.add(new RecipeModel(R.drawable.food1,"Burger"));
        list.add(new RecipeModel(R.drawable.food2,"Burger"));
        list.add(new RecipeModel(R.drawable.food3,"Burger"));
        list.add(new RecipeModel(R.drawable.food4,"Burger"));
        list.add(new RecipeModel(R.drawable.food5,"Burger"));
        list.add(new RecipeModel(R.drawable.food6,"Burger"));
        list.add(new RecipeModel(R.drawable.food7,"Burger"));
        list.add(new RecipeModel(R.drawable.food8,"Burger"));

        RecipeAdapter adapter = new RecipeAdapter(list,this);
        recyclerView.setAdapter(adapter);

    // onItemTouchListner on RecyclerView (Classes,ScrollingActivity)

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this , recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        switch (position){
                            case 0:  
                                Intent intent = new Intent(MainActivity.this,ScrollingActivity.class);
                                startActivity(intent);
                                break;
                            case 1:
                                Toast.makeText(MainActivity.this, "Second Item is clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                Toast.makeText(MainActivity.this, "Third Item is clicked", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                        }

                    }

                    @Override public void onLongItemClick(View view, int position) {
                       switch (position){
                           case 0:
                               Toast.makeText(MainActivity.this, "Get 10% Discount", Toast.LENGTH_SHORT).show();
                               break;
                           default:
                       }

                    }
                })
        );

        // LinearLayoutManager in RecyclerView

    //    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    //    recyclerView.setLayoutManager(layoutManager);

    //    LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);
    //    recyclerView.setLayoutManager(layoutManager);

    //  GridLayoutManager in RecyclerView

    //    GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
    //    recyclerView.setLayoutManager(gridLayoutManager);

    //  StaggeredLayoutManager in RecyclerView

        StaggeredGridLayoutManager  Staggered = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager( Staggered);





    }
}
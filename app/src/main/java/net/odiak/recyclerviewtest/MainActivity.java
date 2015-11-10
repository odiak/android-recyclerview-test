package net.odiak.recyclerviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int CONTENT_VIEW_ID = 999999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        ArrayList<Item> array = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            array.add(new Item(String.format("item %d", i + 1)));
        }

        recyclerView.setAdapter(new RecyclerAdapter(this, array, new RecyclerAdapter.OnRecyclerClickListener() {
            @Override
            public void onRecyclerClicked(View v, int position) {
                Toast.makeText(MainActivity.this, String.format("clicked %d!", position),
                        Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
package com.example.sportsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener
{

    //Step 1. Create variables of the CustomerAdapter Class and also,
    // create the variable of data source(list), also create the variable of RecyclerView.


    RecyclerView recyclerView;
    CustomAdapterForRecyclerView customAdapterForRecyclerView;
    List<Item> list;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Step2. Initialize the recycler view.
        recyclerView=findViewById(R.id.recyclerView);

        //Step3 Create the object of model class.
        Item item1=new Item(R.drawable.basketball,"Basketball");
        Item item2= new Item(R.drawable.football,"Football");
        Item item3=new Item(R.drawable.tennis,"Tennis");
        Item item4=new Item(R.drawable.volley,"Volley");
        Item item5=new Item(R.drawable.ping,"Ping");


        //Step 4 Create the new instance of array list and add items in the list.
        list=new ArrayList<>(); //Since ArrayList is a concrete implementation of the List interface
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        list.add(item5);



        //  Step 5:  Set up the Linear Layout Manager, for showcasing the items in the Recycler View.
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        //Step6: set the recycler view with layout manager
        recyclerView.setLayoutManager(layoutManager);

        //Step 7: Create the instance of CustomerAdapter and pass list in it.
        customAdapterForRecyclerView=new CustomAdapterForRecyclerView(list);

        //Step 8: set the adapter
         recyclerView.setAdapter(customAdapterForRecyclerView);

      // Steps for making the items clickable for recycler View.

        customAdapterForRecyclerView.setClickListener(this);






    }


    @Override
    public void onCLick(View v, int position)
    {

        if(list.get(position).getTexView()=="Basketball")
        {

            PlaySounds(R.raw.black);

        }

        if(list.get(position).getTexView()=="Football")
        {

            PlaySounds(R.raw.green);

        }







    }

    public void PlaySounds(int id)
    {
        MediaPlayer mediaPlayer=MediaPlayer.create(
                getApplicationContext(), id);
        mediaPlayer.start();


    }


}
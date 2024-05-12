package com.example.sportsapp;

import android.view.View;

//Step 1
//For Creating a onClick Listener for the item to be clickable on recycler view, we first need to crate the interface.
public interface ItemClickListener
{
 public void onCLick(View v,int position);


}

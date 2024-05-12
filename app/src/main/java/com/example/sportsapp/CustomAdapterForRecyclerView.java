package com.example.sportsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//Step 4 extends RecyclerView.Adapter<Yourclass.MyViewHolder> and also, override the methods
public class CustomAdapterForRecyclerView extends RecyclerView.Adapter<CustomAdapterForRecyclerView.MyViewHolder>
{



    //Step 1 create the variable of dataSource
    private List<Item> list;

    //For clicking on items on the recycler view.
    //Step (a): Create the variable of ItemClickListener
    public ItemClickListener itemClickListener;

    //Step (b): Create the function setClickListener so that it can be called from main.

    public void setClickListener(ItemClickListener mylistener){

        this.itemClickListener=mylistener;

    }




    //Step 2 create the constructor
    public CustomAdapterForRecyclerView(List<Item> list) {
        this.list = list;
    }


    //Step 5 Complete the MyViewHolder method, inflate the layout in this method.

    //ViewGroups are Layouts that contains text views and other widgets
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Step 5.1, Inflate the layout using LayoutInflater
      View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_layout,parent,false);

        //Step 5.2, return the instance of MyViewHolderClass and pass your view(inflated layout) in it.
        return new MyViewHolder(view);

    }

    //Step 6: Binds the data from the source to the views, within the view holder.
    // In general, set the image resource, set the text etc. in this method, and get the data from the model class.
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        //Step 6.1: Get the items from the items class at the respective position, by using the list.get().
        Item item= list.get(position);//

        //Step 6.2: get the image views, titles and set them from the item class.

        holder.imageView.setImageResource(item.getImageView());
        holder.title.setText(item.getTexView());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    //Step 3 Create the MyViewHolder Class and extends RecyclerView.ViewHolder and initialize the widgets of item_layout.


    //Step c, implements the View.OnClickListener in MyViewHolder, because we have to make the textViews and imageViews clickable.
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        //Step 3.2 Create the references to the widgets
        TextView title;
        ImageView imageView;


        //Step 3.1 Create the constructor
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            //step 3.3 Initialize the above widgets.

            title= itemView.findViewById(R.id.textView);
            imageView=itemView.findViewById(R.id.img_cardView);
            //step d: set the OnClickListener on this MyViewHolder(widgets)

            itemView.setOnClickListener(this);


        }

        //Step e: Override the onClick method of View.OnClick
        @Override
        public void onClick(View v)
        {

            //Step f: Check if itemClick is null or not.
            if(itemClickListener!=null)
            {

                //Step g: Call the interface method, onCLick()
               itemClickListener.onCLick(v,getAdapterPosition());


            }



        }
    }


}

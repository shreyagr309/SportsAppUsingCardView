package com.example.sportsapp;


//Model Class for card_item_layout.
//This class will contain the attributes of card item layout.
//It will act as a model class for the items in the card view.
public class Item
{
    private int imageView;
    private String texView;

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getTexView() {
        return texView;
    }

    public void setTexView(String texView) {
        this.texView = texView;
    }



    public Item(int imageView,String texView) {
        this.imageView = imageView;
        this.texView = texView;
    }









}

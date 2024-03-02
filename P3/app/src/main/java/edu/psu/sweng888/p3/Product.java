package edu.psu.sweng888.p3;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Product implements Parcelable {
    private int id;
    private String name;
    private String description;
    private String seller;
    private double price;
    private String picture; // Assuming picture is stored as a URI or path to the image
    private boolean isSelected = false;

    // Constructor
    public Product(int id, String name, String description, String seller, double price, String picture) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.seller = seller;
        this.price = price;
        this.picture = picture;
    }

    protected Product(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
        seller = in.readString();
        price = in.readDouble();
        // Make sure to read the picture and isSelected in the same order as you write them out
        picture = in.readString();
        isSelected = in.readByte() != 0; // isSelected == true if byte != 0
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSeller() {
        return seller;
    }

    public double getPrice() {
        return price;
    }

    public String getPicture() {
        return picture;
    }

    //Setter Methods
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(seller);
        dest.writeDouble(price);
        // Make sure to write the picture and isSelected in the same order as you read them in
        dest.writeString(picture);
        dest.writeByte((byte) (isSelected ? 1 : 0)); // isSelected ? 1 : 0
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}

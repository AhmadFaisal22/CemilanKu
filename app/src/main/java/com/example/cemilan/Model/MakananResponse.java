package com.example.cemilan.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MakananResponse {

    @SerializedName("results")
    private ArrayList<Makanan> result;

    public ArrayList<Makanan> getResult() {
        return result;
    }
}

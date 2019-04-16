package com.example.friendlist.model;

import com.google.gson.annotations.SerializedName;

public class Status {

    @SerializedName("message")
    private String message;

    public String getMessage() {
        return message;
    }
}

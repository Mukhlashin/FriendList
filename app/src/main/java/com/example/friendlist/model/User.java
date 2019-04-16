package com.example.friendlist.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private String idUser;

    @SerializedName("nama")
    private String namaUser;

    @SerializedName("email")
    private String emailUser;

    @SerializedName("pass")
    private String passUser;

    public String getIdUser() {
        return idUser;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public String getPassUser() {
        return passUser;
    }
}

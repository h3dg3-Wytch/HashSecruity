package com.example.h3dg3wytch.lab4;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

/**
 * Created by h3dg3wytch on 4/1/16.
 */
public class User implements Serializable {
    //User name
    private String userName;
    //Salt, created at the time of the user.
    private String salt;

    //Hash, generated from PasswordStorage
    private String hash;

    //Outdated salt, another way to gen a salt on Android
    private UUID id;

    //Default constructor
    public User(){
        //MAKE SURE THE USER HAS THE SALT, IT HAS TO HOLD ONTO IT OR BE LOST FOREVER
        try {
            this.salt = PasswordStorage.getSalt();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public UUID getId() {
        return id;
    }

    public void createHash(){

    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }


    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

}

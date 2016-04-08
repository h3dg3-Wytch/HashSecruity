package com.example.h3dg3wytch.lab4;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.UUID;

/**
 * Created by h3dg3wytch on 4/1/16.
 */
public class User implements Serializable {

    private String userName;
    private String password;

    private byte[] salt;

    private String hash;

    private UUID id;

    public User(){
        this.id = UUID.randomUUID();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }


    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

}

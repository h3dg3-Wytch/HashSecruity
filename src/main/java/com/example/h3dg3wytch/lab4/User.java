package com.example.h3dg3wytch.lab4;

import java.security.SecureRandom;

/**
 * Created by h3dg3wytch on 4/1/16.
 */
public class User {

    private String userName;
    private String password;

    private byte[] salt;

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
}

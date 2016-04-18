package com.example.h3dg3wytch.lab4;

import android.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class PasswordStorage {

    //generates a salt
    public static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return salt.toString();
    }

    public static String getSecurePassword(String passwordToHash, String salt){
        String generatedPassword = null;
        try{
            //Create MessageDigest instance for md5
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //Add passwrod bytes to digest
            messageDigest.update(salt.getBytes());
            //Get the hash's bytes
            byte[] bytes = messageDigest.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();

        }catch (NoSuchAlgorithmException e){

        }

        return generatedPassword;
    }
}
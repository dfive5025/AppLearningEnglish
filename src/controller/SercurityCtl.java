/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author hoaianh_Kyros
 */
public class SercurityCtl {
    public String md5(String input) 
    {
        String hashText = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            hashText = number.toString(16);
            while(hashText.length() < 32)
            {
                hashText = "0" + hashText;
            }
        } catch (Exception e) {
        }
        return hashText;
    }
}

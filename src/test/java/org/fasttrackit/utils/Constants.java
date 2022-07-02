package org.fasttrackit.utils;

import java.util.Random;

public class Constants {

    public static final String USER_EMAIL = " vladhodisan@yahoo.com";
    public static final String USER_PASS = "Passwordone343!";
    public static String getSaltString;
    public static final String USER_RANDOM_EMAIL = getSaltString()+"@gmail.com";
    public static String randomPasswordGenerator;
    public static final  String USER_RANDOM_PASSWORD = randomPasswordGenerator() ;
    public static final String RANDOM_USER =getSaltString();





    protected static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
protected  static String randomPasswordGenerator(){
        String PASSWORD = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder pass = new StringBuilder();
        Random rnd = new Random();
        while(pass.length()< 10) {
            int index = (int) (rnd.nextFloat()* PASSWORD.length());
            pass.append(PASSWORD.charAt(index));
        }
    String passStr = pass.toString();
        return passStr;
}


}

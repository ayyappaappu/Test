package com.example;

public class ReversR {
    public static void main(String[] args) {

        String s= "ayyappa vlogs";
        String reversed = reversedString(s);
        System.out.println("The reversedString is: " + reversed);

    }
    public static String reversedString(String s){
        if(s.isEmpty())
            return s;
        return reversedString(s.substring(1))+s.charAt(0);


    }
}
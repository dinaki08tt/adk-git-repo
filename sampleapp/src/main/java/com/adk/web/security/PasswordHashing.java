package com.adk.web.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordHashing {

       public static void main(String[] args) {

       String[] originalPassword = {"arun123", "jeremy123", "jing123"};
       PasswordEncoder encoder = new BCryptPasswordEncoder();
       String hashedPassword = "";

       System.out.println("ORIGINAL \t HASHED");
       System.out.println("=========\t=======");
       for(String password : originalPassword){
           hashedPassword = encoder.encode(password);
           System.out.println(password + "\t\t" + hashedPassword);
       }
   }
}
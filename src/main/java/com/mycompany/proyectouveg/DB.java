package com.mycompany.proyectouveg;

import com.mycompany.proyectouveg.Users.User;

import java.util.ArrayList;

public class DB {
    static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<User> getUsers(){
        return users;
    }
}

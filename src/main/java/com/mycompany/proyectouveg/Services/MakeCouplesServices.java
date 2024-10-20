package com.mycompany.proyectouveg.Services;
import com.mycompany.proyectouveg.Students.Gender;
import com.mycompany.proyectouveg.Students.User;
import com.mycompany.proyectouveg.enums.*;

import java.util.ArrayList;

public class MakeCouplesServices {
    private static ArrayList<User> womans = new ArrayList<>();
    private static ArrayList<User> mans = new ArrayList<>();
    private  boolean is_order = true;
    static User searchCoupleForUserId(User[] users, int idUser) {
        return users[0];
    };
    void sortUsersByGender(User[] users){
        if(this.is_order == true){
            System.out.println("Not Order the users are ordered");
            return;
        };
        int length_users = users.length - 1;
        while(length_users >= 0){
            if(users[length_users].getGender() == Gender.Femenino){
                womans.add(users[length_users]);
            }else mans.add(users[length_users]);
            length_users--;
        }
    }
    boolean getOrder(){
        return this.is_order;
    }
    void setOrder(boolean is_order){
        this.is_order = is_order;
    }
}

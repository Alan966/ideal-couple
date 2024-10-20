package com.mycompany.proyectouveg.Services;
import com.mycompany.proyectouveg.DB;
import com.mycompany.proyectouveg.Students.Gender;
import com.mycompany.proyectouveg.Students.User;

import java.util.ArrayList;

public class MakeCouplesServices {
    private static ArrayList<User> womans = new ArrayList<>();
    private static ArrayList<User> mans = new ArrayList<>();
    private  boolean is_order = true;
    private ArrayList<User> users = DB.getUsers();
    public User searchCoupleForUserId(User[] users, int idUser) {
        return users[0];
    };
    public void sortUsersByGender(){
        if(this.is_order == true){
            System.out.println("Not Order the users are ordered");
            return;
        };
        int length_users = users.size() - 1;
        while(length_users >= 0){
            User index_user = users.get(length_users);
            if(index_user.getGender() == Gender.Femenino){
                womans.add(index_user);
            }else mans.add(index_user);
            length_users--;
        }
        setOrder(true);
    }
     public boolean getOrder(){
        return this.is_order;
    }
    public void setOrder(boolean is_order){
        this.is_order = is_order;
    }
}

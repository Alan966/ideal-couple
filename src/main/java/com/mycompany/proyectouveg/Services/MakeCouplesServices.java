package com.mycompany.proyectouveg.Services;
import com.mycompany.proyectouveg.DB;
import com.mycompany.proyectouveg.Students.Gender;
import com.mycompany.proyectouveg.Students.User;

import java.util.ArrayList;

public class MakeCouplesServices {
    private static ArrayList<User> womans = new ArrayList<>();
    private static ArrayList<User> mans = new ArrayList<>();
    private int orders = 0;
    private  boolean is_order = true;
    private ArrayList<User> users = DB.getUsers();
    public User searchCoupleForUserId( int idUser) {
       return users.get(1);
    };
    public void sortUsersByGender(){
        if(this.is_order){
            System.out.println("Not Order the users are ordered");
            return;
        };
        int length_users = users.size() - 1;
        int orders_in_the_last_loop = this.orders;
        while(length_users >= orders_in_the_last_loop){
            this.orders++;
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

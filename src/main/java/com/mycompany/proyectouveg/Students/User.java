package com.mycompany.proyectouveg.Students;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.mycompany.proyectouveg.interfaces.Services;
import com.mycompany.proyectouveg.interfaces.emotional_states;

public class User implements Services.IUser {
    private int id_user;
    private String first_name;
    private String last_name;
    private Gender gender;
    private String email;
    private boolean is_authenticated;
    private String token;
    private String password;
    private emotional_states emotional_parnet;
    double id_counter = 0.00000001;
    Calendar birhtday;

    public User(String first_name, String last_name, Gender gender, String email, String password, String year_mo_da) {
        id_counter++;
        this.id_user = (int) Math.ceil((id_counter * 100000000));
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.email = email;
        this.password = password;
        int year = Integer.parseInt(year_mo_da.split("/")[0]);
        int month = Integer.parseInt(year_mo_da.split("/")[1]) - 1;
        int day = Integer.parseInt(year_mo_da.split("/")[2]);
        this.birhtday = new GregorianCalendar(year, month, day);
    }

    public void setEmotionalParnet(emotional_states emotional) {
        this.emotional_parnet = emotional;
    }

    public void setBirthday(String birthday) {
        int year = Integer.parseInt(birthday.split("/")[0]);
        int month = Integer.parseInt(birthday.split("/")[1]);
        int day = Integer.parseInt(birthday.split("/")[2]);
        this.birhtday = new GregorianCalendar(year, month, day);
    }

    ;

    public void setFistName(String first_name) {
        this.first_name = first_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdUser() {
        return this.id_user;
    }

    public emotional_states getEmotionalPartner() {
        return emotional_parnet;
    }

    public java.lang.String getFullName() {
        return this.first_name + " " + this.last_name;
    }

    public String getFirstName() {
        return this.first_name;
    }

    public String getLastName() {
        return this.last_name;
    }

    public Gender getGender() {
        return this.gender;
    }

    public String getEmail() {
        return this.email;
    }

    ;

    public Date getBirthday() {
        return this.birhtday.getTime();
    }

    ;

    public void Authentication(String username, String password) {
        //TODO: Implement database for authenticated
        if (username.equals("changeThisUsername")) {
            is_authenticated = true;
            generateToken(username);
        } else {
            is_authenticated = false;
        }
    }

    public boolean isAuthenticated() {
        return is_authenticated;
    }

    public void generateToken(String username) {
        token = username + ":" + new Date().getTime();
    }

    public void getAction(Actions_enums action) {
        if (token.isEmpty()) {
            System.out.println("Token is empty");
        }
        switch (action) {
            case action_one -> ActionOne();
            case action_two -> ActionTwo();
            case action_three -> ActionThree();
            case action_four -> ActionFour();
        }
    }

    private void ActionOne() {
        System.out.println("Action One");
    }

    private void ActionTwo() {
        System.out.println("Action Two");
    }

    private void ActionThree() {
        System.out.println("Action Three");
    }

    private void ActionFour() {
        System.out.println("Action Four");
    }
}

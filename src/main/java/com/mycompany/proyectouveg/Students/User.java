package com.mycompany.proyectouveg.Students;
import java.util.Date;

import com.mycompany.proyectouveg.interfaces.ServicesEmotionals;
import com.mycompany.proyectouveg.interfaces.emotional_states;

public class User implements ServicesEmotionals.IUser {
    private int id_user;
    private String first_name;
    private String last_name;
    private int age;
    private Gender gender;
    private String email;
    private boolean is_authenticated;
    private String token;
    private String password;
    private emotional_states emotional_parnet;
    double id_counter = 0.00000001;
    public User(String first_name, String last_name, int age , Gender gender, String email, String password){
        id_counter++;
        this.id_user = (int) (id_counter * 100000000);
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }
    public emotional_states getEmotionalPartner(){
        return emotional_parnet;
    }
    public void setEmotionalParnet(emotional_states emotional){
        this.emotional_parnet = emotional;
    }
    public int getIdUser(){
        return this.id_user;
    }
    public java.lang.String getFullName() {
        return this.first_name + " " + this.last_name;
    }
    public String getFirstName(){
        return this.first_name;
    }
    public String getLastName(){
        return this.last_name;
    }
    public int getAge(){
        return this.age;
    }
    public Gender getGender(){
        return this.gender;
    }
    public String getEmail() {
        return this.email;
    }
    public void setFistName(String first_name) {
     this.first_name = first_name;
    }
    public void setLastName(String last_name) {
        this.last_name = last_name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void Authentication(String username, String password){
        //TODO: Implement database for authenticated
        if(username.equals("changeThisUsername")){
            is_authenticated = true;
            generateToken(username);
        }else{
            is_authenticated = false;
        }
    }
    public boolean isAuthenticated(){
        return is_authenticated;
    }
    public void generateToken(String username){
        token = username + ":" +new Date().getTime();
    }
    public void getAction(Actions_enums action){
        if(token.isEmpty()){
            System.out.println("Token is empty");
        }
        switch (action){
            case action_one -> ActionOne();
            case action_two -> ActionTwo();
            case action_three -> ActionThree();
            case action_four -> ActionFour();
        }
    }
    private void ActionOne(){
        System.out.println("Action One");
    }
    private void ActionTwo(){
        System.out.println("Action Two");
    }
    private void ActionThree(){
        System.out.println("Action Three");
    }
    private void ActionFour(){
        System.out.println("Action Four");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectouveg;

import com.mycompany.proyectouveg.LoveLenguageAndAffectio.ManLoveLenguageAndAffection;
import com.mycompany.proyectouveg.LoveLenguageAndAffectio.WomanLoveLenguageAndAffection;
import com.mycompany.proyectouveg.emotionalsCouples.MakeCouplesEmotionalsPartner;
import com.mycompany.proyectouveg.emotionalsCouples.ManServiceEmotions;
import com.mycompany.proyectouveg.interfaces.Services;
import com.mycompany.proyectouveg.emotionalsCouples.WomanServiceEmotionals;
import com.mycompany.proyectouveg.Users.Gender;
import com.mycompany.proyectouveg.Users.User;
import com.mycompany.proyectouveg.lifeGoalsAndAmbitions.ManServiceLifeandGoals;
import com.mycompany.proyectouveg.lifeGoalsAndAmbitions.WomanServiceLifeandGoals;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alanu
 */
public class ProyectoUVEG {
    static MakeCouplesEmotionalsPartner made_couples = new MakeCouplesEmotionalsPartner();
    public static void main(String[] args) {
        StartGame(DB.getUsers());
    }
    //StartGame: is the method that initialice the program
    public  static void StartGame(ArrayList<User> users){
        Scanner sc = new Scanner(System.in);
        User user = AddNewUser(sc);
        SetCoupleSupport(sc, user);
        users.add(user);
        System.out.println("This is your id: "+ user.getIdUser());
        System.out.println("This is your couple emotional :"+ user.getEmotionalPartner());
        System.out.println("This is your life and goal partner : "+ user.getLifeAndAmbitions());
        System.out.println("Has finish to upload the users ?");
        System.out.println("Response true or false");
        if(sc.nextLine().equals("true")){
            return;
        }else{
            made_couples.setOrder(false);
            StartGame(users);
        }
        made_couples.sortUsersByGender();
    }
    public static User AddNewUser(Scanner sc){
        System.out.println("Ingresa los siguientes valores para crear un Usuario: ");
        System.out.println("Ingresa el nombre");
        String first_name  = sc.nextLine();
        System.out.println("Ingresa el apellido");
        String last_name  = sc.nextLine();
        System.out.println("Ingresa el sexo");
        String response_gender_scanner = sc.nextLine();
        Gender gender;
        if(response_gender_scanner.equals("Masculino")){
            gender = Gender.Masculino;
        }else{
            gender = Gender.Femenino;
        }
        System.out.println("Ingresa email");
        String email = sc.nextLine();
        System.out.println("Ingresa Password");
        String password = sc.nextLine();
        System.out.println("Ingresa la fecha de nacimiento en este formato yyyy/mm/day");
        String birthday = sc.nextLine();
        return new User(first_name, last_name, gender, email, password, birthday);
    }
    public static void SetCoupleSupport(Scanner sc, User user){
        Gender response_gender = user.getGender();
        Services emotional_service = null;
        Services life_and_goals = null;
        Services love_lenguage_and_affection = null;
        // Here we execute to for know their emotional sevice
        switch (response_gender){
            case Masculino -> {
                emotional_service =  new ManServiceEmotions(sc, user);
                life_and_goals = new ManServiceLifeandGoals(sc, user);
                love_lenguage_and_affection = new ManLoveLenguageAndAffection(sc, user);
                break;
            }
            case Femenino -> {
                emotional_service = new WomanServiceEmotionals(sc, user);
                life_and_goals = new WomanServiceLifeandGoals(sc, user);
                love_lenguage_and_affection = new WomanLoveLenguageAndAffection(sc, user);
                break;
            }
        }
        emotional_service.start();
        life_and_goals.start();
        love_lenguage_and_affection.start();
        System.out.println(user.getEmotionalPartner());
        System.out.println(user.getLifeAndAmbitions());
        System.out.println(user.getLoveLenguagePartner());
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectouveg;

import com.mycompany.proyectouveg.Services.MakeCouplesServices;
import com.mycompany.proyectouveg.Services.ManServiceEmotions;
import com.mycompany.proyectouveg.interfaces.ServicesEmotionals;
import com.mycompany.proyectouveg.Services.WomanServiceEmotionals;
import com.mycompany.proyectouveg.Students.Gender;
import com.mycompany.proyectouveg.Students.User;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alanu
 */
public class ProyectoUVEG {
    static MakeCouplesServices made_couples = new MakeCouplesServices();
    public static void main(String[] args) {

        StartGame(DB.getUsers());
    }
    //StartGame: is the method that initialice the program
    public  static void StartGame(ArrayList<User> users){
        Scanner sc = new Scanner(System.in);
        User user = AddNewUser(sc);
        SetEmotionalPartner(sc, user);
        users.add(user);
        System.out.println("This is your id: "+ user.getIdUser());
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
        System.out.println("Ingresa la edad");
        int age;
        age = Integer.parseInt(sc.nextLine());
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
        return new User(first_name, last_name, age, gender, email, password, birthday);
    }
    public static void SetEmotionalPartner(Scanner sc, User user){
        System.out.println(user.getBirthday());
        Gender response_gender = user.getGender();
        ServicesEmotionals emotional_service = null;
        // Here we execute to for know their emotional sevice
        switch (response_gender){
            case Masculino -> {
                emotional_service =  new ManServiceEmotions(sc, user);
                break;
            }
            case Femenino -> {
                emotional_service = new WomanServiceEmotionals(sc, user);
                break;
            }
        }
        emotional_service.start();
    }
}
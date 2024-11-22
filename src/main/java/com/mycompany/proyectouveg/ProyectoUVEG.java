/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectouveg;

import com.mycompany.proyectouveg.FindCouple.Couples;
import com.mycompany.proyectouveg.FindCouple.LifeAndSocialPreferencesQuestions.ManLifestyleAndSocietyPreferences;
import com.mycompany.proyectouveg.FindCouple.LifeAndSocialPreferencesQuestions.WomanLifestyleAndSocietyPreferences;
import com.mycompany.proyectouveg.FindCouple.LoveLenguageAndAffectionQuestions.ManLoveLenguageQuestions;
import com.mycompany.proyectouveg.FindCouple.LoveLenguageAndAffectionQuestions.WomanLoveLenguageQuestions;
import com.mycompany.proyectouveg.FindCouple.EmotionalCouplesQuestions.FindEmotionalPartnerService;
import com.mycompany.proyectouveg.FindCouple.EmotionalCouplesQuestions.ManEmotionalQuestions;
import com.mycompany.proyectouveg.FindCouple.EmotionalCouplesQuestions.WomanEmotionalQuestions;
import com.mycompany.proyectouveg.Users.Gender;
import com.mycompany.proyectouveg.Users.User;
import com.mycompany.proyectouveg.FindCouple.LifeGoalsAndAmbitionsQuestions.ManLifeGoalsQuestions;
import com.mycompany.proyectouveg.FindCouple.LifeGoalsAndAmbitionsQuestions.WomanLifeGoalsQuestions;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alanu
 */
public class ProyectoUVEG {
    public static void main(String[] args) {
        StartGame(DB.getUsers());
    }
    public  static void StartGame(ArrayList<User> users){
        Scanner sc = new Scanner(System.in);
        User user = AddNewUser(sc);
        SetCoupleSupport(sc, user);
        System.out.println("Now is time to give some some recomendations ");
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
        Couples emotional_service = null;
        Couples life_and_goals = null;
        Couples love_lenguage_and_affection = null;
        Couples life_and_social_preference = null;

        // Here we execute to for know their emotional sevice
        switch (response_gender){
            case Masculino -> {
                emotional_service =  new ManEmotionalQuestions(sc, user);
                life_and_goals = new ManLifeGoalsQuestions(sc, user);
                love_lenguage_and_affection = new ManLoveLenguageQuestions(sc, user);
                life_and_social_preference = new ManLifestyleAndSocietyPreferences(sc, user);
                break;
            }
            case Femenino -> {
                emotional_service = new WomanEmotionalQuestions(sc, user);
                life_and_goals = new WomanLifeGoalsQuestions(sc, user);
                love_lenguage_and_affection = new WomanLoveLenguageQuestions(sc, user);
                life_and_social_preference = new WomanLifestyleAndSocietyPreferences(sc, user);
                break;
            }
        }
        emotional_service.start();
        life_and_goals.start();
        love_lenguage_and_affection.start();
        life_and_social_preference.start();
        System.out.println("This is your id: "+ user.getUserId());
        System.out.println("This is your Emotional partner result:"+ user.getEmotionalPartner());
        System.out.println("This is your Life and Goals partner result : "+ user.getLifeAndAmbitions());
        System.out.println("This is your Love Lenguage And Affection partner result : "+ user.getLoveLenguagePartner());
        System.out.println("This is your Life and Social Preferences partner result: "+ user.getLifeAndSocialPreferencesCouple());
    }
}
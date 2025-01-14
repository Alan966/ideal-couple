/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectouveg;

import com.mycompany.proyectouveg.Users.Gender;
import com.mycompany.proyectouveg.Users.User;
import java.util.Scanner;

/**
 * @author alanu
 */
public class ProyectoUVEG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = getUser(sc);
        user.start();
        getUserInfo(user);
        String [] [] advices = user.getAdvices();
        for (String[] advice : advices) {
            printAdvices(advice);
        }
        if(!user.isPremium()){
            System.out.println("Do you want to become premium ?");
            System.out.println("Answer false you don't want to become premium");
            String answer = sc.nextLine().trim().toLowerCase();
            if (answer.equals("false")) return;
            System.out.println("Please insert the amount ");
            int amount = Integer.parseInt(sc.nextLine());
            user.setAmount(amount);
        }
        user.maybeStartProcessPremium(sc);
    }
    private static void  getUserInfo(User user){
        System.out.println("This is your id: " + user.getUserId());
        System.out.println("This is your Emotional partner result:" + user.getEmotionalPartner());
        System.out.println("This is your Life and Goals partner result : " + user.getLifeAndAmbitions());
        System.out.println("This is your Love Lenguage And Affection partner result : " + user.getLoveLenguagePartner());
        System.out.println("This is your Life and Social Preferences partner result: " + user.getLifeAndSocialPreferencesCouple());
    }
    public static User getUser
            (Scanner sc) {
        System.out.println("Ingresa los siguientes valores para evaluarte un Usuario: ");
        System.out.println("Ingresa el nombre");
        String first_name = sc.nextLine();
        System.out.println("Ingresa el apellido");
        String last_name = sc.nextLine();
        System.out.println("Ingresa el sexo");
        String response_gender_scanner = sc.nextLine();
        Gender gender;
        if (response_gender_scanner.equalsIgnoreCase("masculino")) {
            gender = Gender.Masculino;
        } else {
            gender = Gender.Femenino;
        }
        System.out.println("Ingresa email");
        String email = sc.nextLine();
        System.out.println("Ingresa Password");
        String password = sc.nextLine();
        System.out.println("Ingresa la fecha de nacimiento en este formato yyyy/mm/day");
        String birthday = sc.nextLine();
        System.out.println("Quieres poner dinero en tu cuenta");
        String response = sc.nextLine();
        if(response.equals(("Si"))){
            int amount = sc.nextInt();
            return new User(first_name, last_name, gender, email, password, birthday, sc, amount);
        }
        return new User(first_name, last_name, gender, email, password, birthday, sc);
    }
    private static void printAdvices(String[] advices) {
        int length_advice = advices.length;
        int i = 0;
        while (i < length_advice) {
            System.out.println(advices[i]);
            i++;
        }
    }
}
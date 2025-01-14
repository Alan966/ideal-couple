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
        User user = new User(sc);
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
    private static void printAdvices(String[] advices) {
        int length_advice = advices.length;
        int i = 0;
        while (i < length_advice) {
            System.out.println(advices[i]);
            i++;
        }
    }
}
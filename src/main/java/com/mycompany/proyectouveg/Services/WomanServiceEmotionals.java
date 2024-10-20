package com.mycompany.proyectouveg.Services;

import com.mycompany.proyectouveg.Students.User;
import com.mycompany.proyectouveg.enums.emotional_man;
import com.mycompany.proyectouveg.interfaces.ServicesEmotionals;

import java.util.Scanner;
public class WomanServiceEmotionals implements ServicesEmotionals {
    private int points;
    private emotional_man emotional_partner;
    private Scanner scanner;
    private User user;
    public  WomanServiceEmotionals(Scanner scanner, User user) {
        this.scanner = scanner;
        this.user = user;
    }
    public void start(){
        boolean user_could_play = StartGame(this.user);
        if(!user_could_play){
            System.out.println("Finish the game");
            return;
        }
        System.out.println("This is the first part for know what do you want");
        FistQuestion(this.scanner);
        SecondQuestion(this.scanner);
        ThirdQuestion(this.scanner);
        FourthQuestion(this.scanner);
        FifthQuestion(this.scanner);
        if(points < 8){
            emotional_partner = emotional_man.stoic_protector;
        }else if(points <=12 ){
            emotional_partner = emotional_man.calm_problem_solver;
        }else if(points <=17 ){
            emotional_partner = emotional_man.balanced_listener;
        }else {
            emotional_partner = emotional_man.emotional_connection;
        }
        user.setEmotionalParnet(emotional_partner);
    }
    public boolean StartGame(User user){
        boolean response = false;
        if(user.getAge() > 18){
            System.out.println("Hora de Coitorrear!!");
            response = true;
        }else{
            System.out.println("Cierra la computadora");
        }
        return response;
    }
    public String isValidresponse(String response){
        if(!response.equals("a") && !response.equals("b") && !response.equals("c") && !response.equals("d")) {
            System.out.println("Wrong response");
            return "Not_valid";
        }
        return "valid";
    }
    public void addPoints(String response){
        switch (response){
            case "a":
                points+=4;
                break;
            case "b":
                points+=3;
                break;
            case "c":
                points+=2;
                break;
            case "d":
                points+=1;
                break;
        }
    }
    public void FistQuestion(Scanner scanner){
        System.out.println("How do you feel when your partner expresses their emotions openly ?");
        System.out.println("a) I appreciate it, as it shows vulnerability and trust");
        System.out.println("b) I feel comfortable, as long as it's balanced");
        System.out.println("c) It's fine, but I prefer if they stay composed most of the time");
        System.out.println("d) I feel a bit uncomfortable; I like when my partner keeps their emotions in check");
        String response = scanner.nextLine();
        String is_valid = isValidresponse(response);
        if(is_valid.equals("Not_valid")){
            System.out.println("You response is not valid, Tried again");
            FistQuestion(scanner);
        }
        addPoints(response);
    }
    public void SecondQuestion(Scanner scanner){
        System.out.println("What's the ideal way for partner to handle conflict?");
        System.out.println("a) Address the issue calmly talk it through with mutual undestanding");
        System.out.println("b) Be assertive, but listen to my side of the story");
        System.out.println("c) Try to avoid excalating and let things cool down first");
        System.out.println("d) Stay composed and keep their emotions controlled, regardless of the situation");
        String response = scanner.nextLine();
        String is_valid = isValidresponse(response);
        if(is_valid.equals("Not_valid")){
            System.out.println("Your response is invalid, tried again");
            SecondQuestion(scanner);
        }
        addPoints(response);
    }
    public void ThirdQuestion(Scanner scanner){
        System.out.println("How do you prefer your partner to react when you're upset?");
        System.out.println("a) Be empathetic and listen without immediately trying to fix the problem");
        System.out.println("b) Show emotional support but also suggest solutions");
        System.out.println("c) Stay calm and let me vent without saying much");
        System.out.println("d) offer logical solutions rather than getting too emotional");
        String response = scanner.nextLine();
        String is_valid = isValidresponse(response);
        if(is_valid.equals("Not_valid")){
            System.out.println("Your response is invalid,tried again");
            ThirdQuestion(scanner);
        }
        addPoints(response);
    }
    public void FourthQuestion(Scanner scanner){
        System.out.println("How important is for your partner to show vulnerability? ");
        System.out.println("a) very important, it helps me connect deeply with them");
        System.out.println("b) important in certain situations, but I also ant them to be strong ");
        System.out.println("c) it's okay occasionally, but I prefer strength most of the time");
        System.out.println("d) I prefer my partner to be emotionally strong and not show much vulnerability");
        String response = scanner.nextLine();
        String is_valid = isValidresponse(response);
        if(is_valid.equals("Not_valid")){
            System.out.println("Your response is invalid,tried again");
            FourthQuestion(scanner);
        }
        addPoints(response);
    }
    public void FifthQuestion(Scanner scanner){
        System.out.println("How should your partner respond when they feel frustrated or stressed?");
        System.out.println("a) Talk openly about their feelings, and share what's bothering them");
        System.out.println("b) Be calm but share their concerns after reflecting");
        System.out.println("c) stay composed and focus on solving the problem rather than talking about emotions");
        String response = scanner.nextLine();
        String is_valid = isValidresponse(response);
        if(is_valid.equals("Not_valid")){
            System.out.println("Your response is invalid,tried again");
            FifthQuestion(scanner);
        }
        addPoints(response);
    }
}

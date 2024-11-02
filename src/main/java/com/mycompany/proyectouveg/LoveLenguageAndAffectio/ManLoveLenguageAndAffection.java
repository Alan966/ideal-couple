package com.mycompany.proyectouveg.LoveLenguageAndAffectio;

import com.mycompany.proyectouveg.Users.User;
import com.mycompany.proyectouveg.enums.LoveLenguageAndAffection.woman_love_lenguage_and_affection;
import com.mycompany.proyectouveg.interfaces.Services;
import com.mycompany.proyectouveg.interfaces.love_lenguage_and_affection;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ManLoveLenguageAndAffection  implements Services {
    private int points;
    private Scanner scanner;
    private User user;
    public love_lenguage_and_affection love_lenguage_partner;
    public ManLoveLenguageAndAffection(Scanner sn, User user){
        this.scanner = sn;
        this.user = user;
    }
    @Override
    public void start() {
        boolean user_could_play = StartGame(this.user);
        if(!user_could_play){
            System.out.println("Finish the game");
            return;
        };
        FistQuestion(this.scanner);
        SecondQuestion(this.scanner);
        ThirdQuestion(this.scanner);
        FourthQuestion(this.scanner);
        FifthQuestion(this.scanner);
        if(points <= 5){
            love_lenguage_partner = woman_love_lenguage_and_affection.reserved_independent_partner;
        }else if(points <= 10){
            love_lenguage_partner = woman_love_lenguage_and_affection.low_key_independent_partner;
        }else if(points <= 15){
            love_lenguage_partner = woman_love_lenguage_and_affection.balanced_supportive_partner;
        }else{
            love_lenguage_partner = woman_love_lenguage_and_affection.warm_affection_partner;
        }
        this.user.setLoveLenguagePartner(love_lenguage_partner);
    }

    @Override
    public boolean StartGame(User user) {
        boolean response = false;
        Calendar now = new GregorianCalendar();
        int difference = user.getBirthday().getYear() - now.getTime().getYear();
        if( difference > 18 || difference < -18 ){
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

    @Override
    public void FistQuestion(Scanner sn) {
        System.out.println("How important is physical affection in your relationship?");
        System.out.println("a) It's essential - I need a partner who's comfortable with lots of affection");
        System.out.println("b) I value affection but in more subtle, personal ways");
        System.out.println("c) I'm okay with affection, but it doesn't need to be constant");
        System.out.println("d) I don't place a lot of emphasis on physical affection");
        String response = sn.nextLine();
        String is_valid = isValidresponse(response);
        if(is_valid.equals("Not_valid")){
            System.out.println("You response is not valid, Tried again");
            FistQuestion(sn);
        }
        addPoints(response);
    }

    @Override
    public void SecondQuestion(Scanner sn) {
        System.out.println("How do you feel about verbal affirmations and compliments from your partner ?");
        System.out.println("a) I love frequent affirmations, they make me feel valued and close");
        System.out.println("b) I appreciate them when they feel genuine and meaningful");
        System.out.println("c) They're nice, but I don't need them all the time");
        System.out.println("d) I don't rely much on words of affirmation, I show and feel love in other ways");
        String response = sn.nextLine();
        String is_valid = isValidresponse(response);
        if(is_valid.equals("Not_valid")){
            System.out.println("You response is not valid, Tried again");
            SecondQuestion(sn);
        }
        addPoints(response);
    }

    @Override
    public void ThirdQuestion(Scanner sn) {
        System.out.println("When it comes to spending quality time, what's your preference ?");
        System.out.println("a) I prefer frequent one-on-one time with my partner, engaging in shared interests ");
        System.out.println("b) I like quality time together but also value some independence ");
        System.out.println("c) I enjoy it, but as long we connect regularly, it doesn't need to be constant");
        System.out.println("d) I value having my own time and space and prefer less focused attention");
        String response = sn.nextLine();
        String is_valid = isValidresponse(response);
        if(is_valid.equals("Not_valid")){
            System.out.println("You response is not valid, Tried again");
            SecondQuestion(sn);
        }
        addPoints(response);
    }

    @Override
    public void FourthQuestion(Scanner sn) {
        System.out.println("How do you feel about gifts as a form of expressing love?");
        System.out.println("a) Gifts are a key part of showing love,I like giving and receiving them often");
        System.out.println("b) I appreciate thoughtful gifts on meaningful occasions");
        System.out.println("c) I'm fine with gifts ut don't need them to feel connected");
        System.out.println("d) I don't place much emphasis on gifts as an expression of love");
        String response = sn.nextLine();
        String is_valid = isValidresponse(response);
        if(is_valid.equals("Not_valid")){
            System.out.println("You response is not valid, Tried again");
            SecondQuestion(sn);
        }
        addPoints(response);
    }

    @Override
    public void FifthQuestion(Scanner sn) {
        System.out.println("How important is it that your partner offers practical support (like helping with tasks or planning) ?");
        System.out.println("a) Very important I feel loved when my partner is actively supportive");
        System.out.println("b) I appreciate help but don't expect it all the time");
        System.out.println("c) It's nice occasionally, but I prefer independence in tasks");
        System.out.println("d) I don't expect or need practical support as a show of love");
        String response = sn.nextLine();
        String is_valid = isValidresponse(response);
        if(is_valid.equals("Not_valid")){
            System.out.println("You response is not valid, Tried again");
            SecondQuestion(sn);
        }
        addPoints(response);
    }
}

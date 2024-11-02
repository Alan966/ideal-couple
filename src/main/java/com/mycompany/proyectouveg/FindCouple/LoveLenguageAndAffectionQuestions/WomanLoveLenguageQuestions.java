package com.mycompany.proyectouveg.FindCouple.LoveLenguageAndAffectionQuestions;

import com.mycompany.proyectouveg.Users.User;
import com.mycompany.proyectouveg.FindCouple.Services;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class WomanLoveLenguageQuestions implements Services {
    private int points;
    private Scanner scanner;
    private User user;
    public love_lenguage_states love_lenguage_partner;
    public WomanLoveLenguageQuestions(Scanner sn, User user){
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
        if(this.points <= 5){
            love_lenguage_partner = love_lenguage_states_man.independent_reserved_partner;
        }else if (this.points <= 10){
            love_lenguage_partner = love_lenguage_states_man.low_key_reliable_partner;
        }else if(this.points <= 15){
            love_lenguage_partner = love_lenguage_states_man.supportive_balanced_partner;
        }else {
            love_lenguage_partner = love_lenguage_states_man.thoughtful_emotionally_engaged;
        }
        this.user.setLoveLenguagePartner(love_lenguage_partner);
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

    @Override
    public void FistQuestion(Scanner sn) {
        System.out.println("When you're feeling down, what kind of support would make you feel the most loved ?");
        System.out.println("a) A warm hug and having my partner close to me");
        System.out.println("b) Words of encouragement and reassurance from my partner");
        System.out.println("c) Helping me with small tasks or taking care of something I' struggling with");
        System.out.println("d) Giving me space to process alone but checking in on me later");
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
        System.out.println("How would you prefer your partner to express their appreciation for you?");
        System.out.println("a) By planning thoughtful date nights or special time just for us");
        System.out.println("b) By telling me frequently how much I mean to them ");
        System.out.println("c) Through small acts, like helping with errands or giving me a gift now and them");
        System.out.println("d) By respecting my boundaries and showing they trust me");
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
        System.out.println("When it comes to affection, what is most meaningful to you in day-to-day interactions ?");
        System.out.println("a) Frequent small gestures, like hand-holding, cuddling, and physical closeness");
        System.out.println("b) Compliments and verbal affirmations that make me feel valued");
        System.out.println("c) Helping out without being asked showing attentiveness through actions");
        System.out.println("d) Giving me space while still being there for me when I need support");
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
        System.out.println("If you and your partner have limited time together, how would you most want to spend it ?");
        System.out.println("a) Just enjoying quality time, like a quiet night in or an adventure together");
        System.out.println("b) Talking openly about life, dreams, and building a deep connection");
        System.out.println("c) Focusing on practical things like planning or working on something together");
        System.out.println("d) Respecting each other's space and then reconnecting when we're both free");
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
        System.out.println("How important is it for you that your partner goes out of their way to make you feel special on important dates (anniversaries, birthdays, tsc.) ?");
        System.out.println("a) very important, I love when my partner plans something memorable and thoughtful");
        System.out.println("b) It's meaningful, but even a heartfelt message or note is enough");
        System.out.println("c) Nice, but I prefer small gestures year-round rather than big celebrations");
        System.out.println("d) I don't place much emphasis on these dates, it's about how treat me daily");
        String response = sn.nextLine();
        String is_valid = isValidresponse(response);
        if(is_valid.equals("Not_valid")){
            System.out.println("You response is not valid, Tried again");
            SecondQuestion(sn);
        }
        addPoints(response);
    }
}

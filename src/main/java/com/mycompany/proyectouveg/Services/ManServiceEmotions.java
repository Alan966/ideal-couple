package com.mycompany.proyectouveg.Services;

import com.mycompany.proyectouveg.Students.User;
import com.mycompany.proyectouveg.enums.emotional_woman;
import com.mycompany.proyectouveg.interfaces.ServicesEmotionals;

import java.util.Scanner;

public class ManServiceEmotions implements ServicesEmotionals {
    private int points;
    private emotional_woman emotions_partner;
    private Scanner scanner;
    private User user;
    public ManServiceEmotions(Scanner scanner, User user) {
        this.scanner = scanner;
        this.user = user;
    }
    public void start(){
        boolean user_could_play = StartGame(user);
        if(!user_could_play){
            System.out.println("Finish the game");
            return;
        }
        System.out.println("This is the first part for know that do you want");
        FistQuestion(scanner);
        SecondQuestion(scanner);
        ThirdQuestion(scanner);
        FourthQuestion(scanner);
        FifthQuestion(scanner);
        if(points < 8){
            emotions_partner = emotional_woman.emotionally_reserved;
        }else if(points <= 12){
            emotions_partner = emotional_woman.emotionally_independent;
        }else if(points <= 17){
            emotions_partner = emotional_woman.emotionally_balanced;
        }else{
            emotions_partner = emotional_woman.emotionally_engaged;
        }
        user.setEmotionalParnet(emotions_partner);
    }

    public boolean StartGame(User user) {
        boolean response= false;
        if (user.getAge() > 18) {
            System.out.println("Hora de Coitorrear!!");
            response = true;
        } else {
            System.out.println("Cierra la computadora");
        }
        return response;
    }

    public String isValidresponse(String response) {
        if (!response.equals("a") && !response.equals("b") && !response.equals("c") && !response.equals("d")) {
            System.out.println("Wrong response");
            return "Not_valid";
        }
        return "valid";
    }

    public void addPoints(String response) {
        switch (response) {
            case "a":
                points += 4;
                break;
            case "b":
                points += 3;
                break;
            case "c":
                points += 2;
                break;
            case "d":
                points += 1;
                break;
        }
    }

    public void FistQuestion(Scanner sn) {
        System.out.println("How important is emotional vulnerability in your partner ?");
        System.out.println("a) I appreciate when she feels comfortable being open and vulnerable with me about her feelings");
        System.out.println("b) I like when she shares her emotions, but I also value her ability to maintain composure during tough times");
        System.out.println("c) I want her to be emotionally strong most of the time, sharing feelings only when necessary ");
        System.out.println("d) I prefer if she remains private about her emotions and deals with them independetly");
        String response = sn.nextLine();
        String is_valid = isValidresponse(response);
        if (is_valid.equals("Not_valid")) {
            System.out.println("Your response is not valid Tried again");
            FistQuestion(sn);
        }
        addPoints(response);
    }

    ;

    public void SecondQuestion(Scanner sn) {
        System.out.println("When your partner is upset, how would you like here to express it ?");
        System.out.println("a) Share her emotions openly with me, so we can talk through it together");
        System.out.println("b) Express her feelings but do calmly without letting emotions take over");
        System.out.println("c) Keep her feelings mostly to herself and talk about it only if absolutely needed");
        System.out.println("d) Try to handle it on her own, showing that she's strong enough to manage without much support");
        String response = sn.nextLine();
        String is_valid = isValidresponse(response);
        if (is_valid.equals("Not_valid")) {
            System.out.println("Your response is invalid,tried again");
            SecondQuestion(sn);
        }
        addPoints(response);
    }

    ;

    public void ThirdQuestion(Scanner sn) {
        System.out.println("What king of emotional balance do you seek in a partner?");
        System.out.println("a) I want a partner who is emotionally open but also resilient- someone who can be vulnerable and strong at the same time");
        System.out.println("b) A woman who can talk about her feelings when necessary, but who is also capable of handling difficult emotions on her own");
        System.out.println("c) A partner who values stability and prefers to keep her emotional experiences private most of the time");
        System.out.println("d) I prefer someone who doesn't rely too much on emotions, focusing more on practical solutions rather than emotional discussions");
        String response = sn.nextLine();
        String is_valid = isValidresponse(response);
        if (is_valid.equals("Not_valid")) {
            System.out.println("Your response is invalid,tried again");
            ThirdQuestion(sn);
        }
        addPoints(response);
    }

    ;

    public void FourthQuestion(Scanner sn) {
        System.out.println("How should your partner support you emotionally ?");
        System.out.println("a) Be emotionally engaged , offering empathy and understanding when I need it");
        System.out.println("b) Provide emotional support when I need it but remain calm and focused");
        System.out.println("c) Offer minimal emotional support, as I prefer to deal with my won feelings");
        System.out.println("d) Stay detached emotionally  and let me handle my own issues");
        String response = sn.nextLine();
        String is_valid = isValidresponse(response);
        if (is_valid.equals("Not_valid")) {
            System.out.println("Your response is invalid,tried again");
            FourthQuestion(sn);
        }
        addPoints(response);
    }

    ;

    public void FifthQuestion(Scanner sn) {
        System.out.println("How do you feel about emotional conflict in a relationship?");
        System.out.println("a) I prefer a partner who is open about her emotions, even during conflict,so we can work through issues together");
        System.out.println("b) I want her to express her feelings but remain respectful calm , even when things get hated");
        System.out.println("c) I prefer a partner who stays calm and avoids getting too emotional during conflicts ");
        System.out.println("d) I'de like her to remain composed and focus on finding solutions without letting emotions affect the conversation");
        String response = sn.nextLine();
        String is_valid = isValidresponse(response);
        if (is_valid.equals("Not_valid")) {
            System.out.println("Your response is invalid,tried again");
            FifthQuestion(sn);
        }
        addPoints(response);
    }
}
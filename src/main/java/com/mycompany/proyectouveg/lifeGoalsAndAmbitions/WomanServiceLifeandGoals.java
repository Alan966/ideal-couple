package com.mycompany.proyectouveg.lifeGoalsAndAmbitions;
import com.mycompany.proyectouveg.Users.User;
import  com.mycompany.proyectouveg.interfaces.Services;
import com.mycompany.proyectouveg.enums.enumsLifeandAmbitions.life_and_ambitions_man;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class WomanServiceLifeandGoals implements  Services{
    private int points;
    private life_and_ambitions_man life_and_ambition_partner;
    private Scanner scanner;
    private User user;
    public WomanServiceLifeandGoals(Scanner scanner, User user){
        this.scanner = scanner;
        this.user = user;
    }

    @Override
    public void start() {
        boolean user_could_play = StartGame(this.user);
        if(!user_could_play){
            System.out.println("Finish the game");
            return;
        };
        System.out.println("This is the first part for know what do you want");
        FistQuestion(this.scanner);
        SecondQuestion(this.scanner);
        ThirdQuestion(this.scanner);
        FourthQuestion(this.scanner);
        FifthQuestion(this.scanner);
        if(points <= 5){
            life_and_ambition_partner = life_and_ambitions_man.traditional_provider_led_relationship;
        }else if(points <= 10){
            life_and_ambition_partner = life_and_ambitions_man.more_traditional_family_focused;
        }else if (points <= 15){
            life_and_ambition_partner = life_and_ambitions_man.balanced_team_oriented_partner;
        }else{
            life_and_ambition_partner = life_and_ambitions_man.highly_ambitious_supportive_partner;
        }
        this.user.setLifeAndAmbitionPartner(life_and_ambition_partner);
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
        System.out.println("How do you view your career ambitions in a relationship?");
        System.out.println("a) My career is my top priority, and I expect my partner to support my ambitions fully.");
        System.out.println("b) My career is important, but I am open to compromising when needed for the relationship");
        System.out.println("c) I prefer to balance my career and personal life equally with my partner");
        System.out.println("d) I see myself focusing more on family and supporting my partner's career");
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
        System.out.println("How do you approach long-term goals with a partner?");
        System.out.println("a) I want us to pursue our individual goals while supporting each other from a distance");
        System.out.println("b) I want us to pursue goals together but maintain some independence");
        System.out.println("c) I prefer us to set mutual goals ad work as a team");
        System.out.println("d) I expect my partner to lead while I support and follow the shared goals");
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
        System.out.println("How important is financial independence for you in a relationship?");
        System.out.println("a) I want to maintain complete financial independence from my partner");
        System.out.println("b) I prefer to keep some financial independence but share certain responsabilities");
        System.out.println("c) I believe in sharing all financial responsabilities equally");
        System.out.println("d) I am comfortable relying on my partner for financial support");
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
        System.out.println("How do you view family planning in relation to your personal ambitions?");
        System.out.println("a) I prefer to focus on my career for now and think about family planning much later");
        System.out.println("b) I'd like to balance both family and personal goals from the start");
        System.out.println("c) I am open to focusing on family sooner, but I want to keep working on personal ambitions");
        System.out.println("d) I would prioritize family over personal ambitions when the time comes");
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
        System.out.println("How do you feel about traveling or relocating for career opportunities ?");
        System.out.println("a) I am very open to relocating or traveling often for career growth, even if it means long-distance");
        System.out.println("b) I would consider relocating or traveling for work if my partner is onboard with it");
        System.out.println("c) I prefer stability but would relocate if it's important for us as a couple");
        System.out.println("d) I don't like the idea of relocating and prefer a stable, settled life");
        String response = sn.nextLine();
        String is_valid = isValidresponse(response);
        if(is_valid.equals("Not_valid")){
            System.out.println("You response is not valid, Tried again");
            SecondQuestion(sn);
        }
        addPoints(response);
    }
}

package com.mycompany.proyectouveg.FindCouple.LifeGoalsAndAmbitionsQuestions;
import com.mycompany.proyectouveg.Users.User;
import com.mycompany.proyectouveg.FindCouple.Services;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ManLifeGoalsQuestions implements Services {
    private int points;
    private life_and_ambitions_states_woman life_and_ambitions_partner;
    private Scanner scanner;
    private User user;
    public ManLifeGoalsQuestions(Scanner scanner, User user){
        this.scanner = scanner;
        this.user = user;
    }

    @Override
    public void start() {
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
        if(points <= 5){
            life_and_ambitions_partner = life_and_ambitions_states_woman.traditional_family_oriented;
        }else if (points <= 10){
            life_and_ambitions_partner = life_and_ambitions_states_woman.family_focused_supportive;
        }else if(points <= 15){
            life_and_ambitions_partner = life_and_ambitions_states_woman.team_oriented_woman;
        }else {
            life_and_ambitions_partner = life_and_ambitions_states_woman.highly_ambitious_career;
        }
        this.user.setLifeAndAmbitionPartner(life_and_ambitions_partner);
    }

    @Override
    public boolean StartGame(User user) {
        boolean response = false;
        Calendar now = new GregorianCalendar();
        int difference = user.getBirthday().getYear() - now.getTime().getYear();
        if(difference > 18 || difference < -18){
            System.out.println("Hora de Coitorrear!!!");
            response = true;
        }else {
            System.out.println("Cierra la computadora");
        };
        return response;
    }
    public String isValidresponse(String response){
        if(!response.equals("a") && !response.equals("b")&& !response.equals("c") && !response.equals("d")){
            System.out.println("Wrong response");
            return "Not_valid";
        }
        return "valid";
    }
    public void addPoints(String response){
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
    @Override
    public void FistQuestion(Scanner sn) {
        System.out.println("How important is it for you that your partner has her own career ambitions ?");
        System.out.println("a) It's very important that she is as ambitious as I am, with a strong focus on her career");
        System.out.println("b) I want her to have career goals, but I am okay with a balanced approach between work and home");
        System.out.println("c) I would prefer she focuses more on family, but can still work if she wants");
        System.out.println("d) I prefer a partner who focuses on family ans supports my career");
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
        System.out.println("What role do you want your partner to play in achieving log-term goals?");
        System.out.println("a) I want her to have her own individual goals, and we support each other from a distance");
        System.out.println("b) I would like us to pursue goals together but maintain some independence ");
        System.out.println("c) I prefer that we set mutual goals and work closely as a team");
        System.out.println("d) I want to lead in setting goals, and I prefer she supports me in achieving them");
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
        System.out.println("How do you feel about your partner's financial independence ?");
        System.out.println("a) I want her to be fully financially independent and contribute equally");
        System.out.println("b) I'm comfortable with her contributing, but it's okay if I take the lead in finances");
        System.out.println("c) I'm fine with sharing responsibilities, but I'm open to being the primary provider");
        System.out.println("d) I prefer to be the primary financial provider, with her focusing on family or supporting me.");
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
        System.out.println("How do you see your partner's role in family planning ?");
        System.out.println("a) I expect her focus more on her career in the short term and think about family later");
        System.out.println("b )I would like us to balance family and career together from start");
        System.out.println("c) I'm okay with her prioritizing family over career in the near future");
        System.out.println("d) I want her to prioritize family as soon as possible, with me focusing on providing");
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
        System.out.println("Would you want your partner to relocate or travel for career opportunities?");
        System.out.println("a) I'm fully supportive of her relocating or traveling for career growth, even if ti means long-distance");
        System.out.println("b) I'm open to relocating together or supporting her career decisions, as long as we plan as a couple");
        System.out.println("c) I prefer stability, but I'm open to relocating if it's important for both of us");
        System.out.println("d) I prefer a stable home life and expect her to prioritize that over travel or relication");
        String response = sn.nextLine();
        String is_valid = isValidresponse(response);
        if(is_valid.equals("Not_valid")){
            System.out.println("You response is not valid, Tried again");
            SecondQuestion(sn);
        }
        addPoints(response);
    }
}

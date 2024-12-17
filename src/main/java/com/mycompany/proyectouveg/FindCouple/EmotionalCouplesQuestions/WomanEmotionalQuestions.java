package com.mycompany.proyectouveg.FindCouple.EmotionalCouplesQuestions;

import com.mycompany.proyectouveg.FindCouple.Couples;
import com.mycompany.proyectouveg.Users.User;
import java.util.Scanner;
public class WomanEmotionalQuestions extends Couples {
    private int points = 0;
    private emotional_states_man emotional_partner;
    private Scanner scanner;
    public WomanEmotionalQuestions(Scanner scanner, User user) {
        super(user);
        this.scanner = scanner;
    }
    public void start(){
        boolean user_could_play = couldPlay();
        if(!user_could_play){
            System.out.println("Finish the game");
            return;
        };
        executeQuestions();
        if(points < 8){
            emotional_partner = emotional_states_man.stoic_protector;
        }else if(points <= 12 ){
            emotional_partner = emotional_states_man.calm_problem_solver;
        }else if(points <= 17 ){
            emotional_partner = emotional_states_man.balanced_listener;
        }else {
            emotional_partner = emotional_states_man.emotional_connection;
        }
        this.user.setEmotionalPartner(emotional_partner);
    }
    protected void FirstQuestion(){
        System.out.println("How do you feel when your partner expresses their emotions openly ?");
        System.out.println("a) I appreciate it, as it shows vulnerability and trust");
        System.out.println("b) I feel comfortable, as long as it's balanced");
        System.out.println("c) It's fine, but I prefer if they stay composed most of the time");
        System.out.println("d) I feel a bit uncomfortable; I like when my partner keeps their emotions in check");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)) {
            System.out.println("Your response is not valid Tried again");
            FirstQuestion();
        }
        this.points += returnPoints(response);
    }
    protected void SecondQuestion(){
        System.out.println("What's the ideal way for partner to handle conflict?");
        System.out.println("a) Address the issue calmly talk it through with mutual undestanding");
        System.out.println("b) Be assertive, but listen to my side of the story");
        System.out.println("c) Try to avoid excalating and let things cool down first");
        System.out.println("d) Stay composed and keep their emotions controlled, regardless of the situation");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)) {
            System.out.println("Your response is invalid,tried again");
            SecondQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    protected void ThirdQuestion() {
        System.out.println("How do you prefer your partner to react when you're upset?");
        System.out.println("a) Be empathetic and listen without immediately trying to fix the problem");
        System.out.println("b) Show emotional support but also suggest solutions");
        System.out.println("c) Stay calm and let me vent without saying much");
        System.out.println("d) offer logical solutions rather than getting too emotional");
        String response = this.scanner.nextLine();
        if(!validateResponse(response)){
            System.out.println("Your response is invalid,tried again");
            ThirdQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    protected void FourthQuestion() {
        System.out.println("How important is for your partner to show vulnerability? ");
        System.out.println("a) very important, it helps me connect deeply with them");
        System.out.println("b) important in certain situations, but I also ant them to be strong ");
        System.out.println("c) it's okay occasionally, but I prefer strength most of the time");
        System.out.println("d) I prefer my partner to be emotionally strong and not show much vulnerability");
        String response = scanner.nextLine();
        if(!validateResponse(response)){
            System.out.println("Your response is invalid,tried again");
            FourthQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    protected void FifthQuestion() {
        System.out.println("How should your partner respond when they feel frustrated or stressed?");
        System.out.println("a) Talk openly about their feelings, and share what's bothering them");
        System.out.println("b) Be calm but share their concerns after reflecting");
        System.out.println("c) stay composed and focus on solving the problem rather than talking about emotions");
        System.out.println("d) Stay composed and focus on solving the problem rather than talking about emotions ");
        String response = scanner.nextLine();
        if(!validateResponse(response)){
            System.out.println("Your response is invalid,tried again");
            FifthQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    public String[] getAdvices() {
        WomanEmotionalTips woman_emotional_tips = new WomanEmotionalTips(this.user);
       return  woman_emotional_tips.getTips();
    }
}

package com.mycompany.proyectouveg.FindCouple.LifeAndSocialPreferencesQuestions;

import com.mycompany.proyectouveg.FindCouple.Couples;
import com.mycompany.proyectouveg.Users.User;

import java.util.Scanner;

public class WomanLifestyleAndSocietyPreferences extends Couples {
    private int points = 0;
    private final Scanner scanner;
    public WomanLifestyleAndSocietyPreferences(Scanner sn, User user){
        super(user);
        this.scanner = sn;
    }
    @Override
    public void start() {
        boolean user_could_play = couldPlay();
        if(!user_could_play){
            System.out.println("Finish the game");
            return;
        }
        executeQuestions();
        life_and_social_preferences_states life_and_social_preferences_couples;
        if(points <= 5){
            life_and_social_preferences_couples = life_and_social_preferences_states_man.laid_back_private_partner;
        }else if(points <= 10){
            life_and_social_preferences_couples = life_and_social_preferences_states_man.family_oriented_partner;
        }else if(points <= 15){
            life_and_social_preferences_couples = life_and_social_preferences_states_man.socially_flexible_partner;
        }else{
            life_and_social_preferences_couples = life_and_social_preferences_states_man.socially_driver_partner;
        }
        this.user.setLifeAndSocialPreferences(life_and_social_preferences_couples);
    }

    @Override
    protected void FirstQuestion() {
        System.out.println("How would you like your partner to spend weekends with you ?");
        System.out.println("a) Going out and experiencing new things, like social events or gatherings");
        System.out.println("b) A mix of outdoor activities and quiet time together");
        System.out.println("c) Mostly staying in or spending time with close friends and famility");
        System.out.println("d) Relaxing at home or enjoying a quiet weekend with just us");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)){
            FirstQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    protected void SecondQuestion() {
        System.out.println("How do you feel about a partner who has a busy social life and likes to be out often ?");
        System.out.println("a) I love it, I want a partner who enjoys an active, social lifestyle ");
        System.out.println("b) It's nice as long as we have a balance of social and private time");
        System.out.println("c) I'd prefer someone who has a smaller social circle and enjoys quiet nights");
        System.out.println("d) I'm looking for someone who values time at home with a relaxed routine");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)){
            SecondQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    protected void ThirdQuestion() {
        System.out.println("What type of work-life balance would you prefer your partner to have ?");
        System.out.println("a) Very driven and career-focused, with less emphasis on leisure time");
        System.out.println("b) Balanced, making time for both career and relaxation");
        System.out.println("c) Work isn't everything, I'd prefer someone who values downtime more");
        System.out.println("d) I want someone who prioritizes a low-stress, leisurely lifestyle");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)){
            ThirdQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    protected void FourthQuestion() {
        System.out.println("What level of independence and personal space do you prefer in a partner ?");
        System.out.println("a) I enjoy someone very independent who's often busy with his own interests");
        System.out.println("b) I prefer a partner who values some personal space but enjoys time together too");
        System.out.println("c) I like a partner who enjoys spending most of his time with me");
        System.out.println("d) I prefer someone who values our time together over personal space");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)){
            FourthQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    protected void FifthQuestion() {
        System.out.println("How do you feel about partner's involvement in social gatherings and events with friends?");
        System.out.println("a) I'd love a partner who enjoys social events and networking ");
        System.out.println("b) I appreciate a partner who enjoys occasional social gatherings with me");
        System.out.println("c) I'd prefer someone who limits social gatherings to close friends and family");
        System.out.println("d) I'm looking for someone who values quiet time and isn't very social");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)){
            FifthQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    public String[] getAdvices() {
        WomanLifeAndSocialTips woman_life_and_social = new WomanLifeAndSocialTips(this.user);
        return woman_life_and_social.getTips();
    }
}

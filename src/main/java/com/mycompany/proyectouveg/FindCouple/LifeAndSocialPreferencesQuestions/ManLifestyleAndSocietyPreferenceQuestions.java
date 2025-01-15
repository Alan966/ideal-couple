package com.mycompany.proyectouveg.FindCouple.LifeAndSocialPreferencesQuestions;

import com.mycompany.proyectouveg.FindCouple.Couples;
import com.mycompany.proyectouveg.Users.User;

import java.util.Scanner;

public class ManLifestyleAndSocietyPreferenceQuestions extends Couples {
    private int points = 0;
    private final Scanner scanner;

    public ManLifestyleAndSocietyPreferenceQuestions(Scanner _sn, User _user) {
        super(_user);
        this.scanner = _sn;
    }

    @Override
    public void start() {
        boolean user_could_play = couldPlay();
        if (!user_could_play) {
            System.out.println("Finish the game");
            return;
        }
        executeQuestions();
        life_and_social_preferences_states life_and_social_preferences_couple;
        if (points <= 5) {
            life_and_social_preferences_couple = life_and_social_preferences_states_woman.personal_space_oriented_partner;
        } else if (points <= 10) {
            life_and_social_preferences_couple = life_and_social_preferences_states_woman.home_oriented_partner;
        } else if (points <= 15) {
            life_and_social_preferences_couple = life_and_social_preferences_states_woman.socially_flexible_partner;
        } else {
            life_and_social_preferences_couple = life_and_social_preferences_states_woman.socially_engaged_partner;
        }
        this.user.setLifeAndSocialPreferences(life_and_social_preferences_couple);
    }

    @Override
    protected void FirstQuestion() {
        System.out.println("How do you prefer spending your weekends with a partner?");
        System.out.println("a) Going out, exploring new places, and meeting new people");
        System.out.println("b) A mix of going out and relaxing at home");
        System.out.println("c) Mostly staying in or having quiet time with close friends or family");
        System.out.println("d) Staying in, enjoying personal time, or relaxing together");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)) {
            FirstQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    protected void SecondQuestion() {
        System.out.println("How do you feel about a partner who enjoys social gatherings and events ?");
        System.out.println("a) I love it, I'm looking for someone social and outgoing");
        System.out.println("b) I appreciate it, as long as we also get time for just us");
        System.out.println("c) I'd prefer someone who enjoys small, intimate gatherings more than big events");
        System.out.println("d) I'm looking for someone who's more introverted and enjoys quiet nights");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)) {
            SecondQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    protected void ThirdQuestion() {
        System.out.println("What's your ideal balance between personal time and time spent together with your partner?");
        System.out.println("a) I'd like to spend most of our time together");
        System.out.println("b) I appreciate quality time but also value some personal space");
        System.out.println("c) I need a good amount of personal time to recharge");
        System.out.println("d) I highly value personal space and alone time");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)) {
            ThirdQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    protected void FourthQuestion() {
        System.out.println("How important is it that your partner shared similar energy levels and preferences for social activities ?");
        System.out.println("a) Very important; I want a partner with similar social energy");
        System.out.println("b) Fairly important, it's nice if we align, but I'm flexible");
        System.out.println("c) It's fine if we have different energy levels as long as we compromise");
        System.out.println("d) No very important I don't mind if our energy levels differ");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)) {
            FourthQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    protected void FifthQuestion() {
        System.out.println("What's your preference for balancing work and leisure with a partner?");
        System.out.println("a) I'd like a partner who is as focused on work as I am, with occasional leisure time");
        System.out.println("b) I prefer a balance of work and play, with time dedicated ro relaxation");
        System.out.println("c) I lean toward a relaxed lifestyle, with more time for personal interests");
        System.out.println("d) I prefer minimal work stress and a lifestyle focused on enjoy and relaxation");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)) {
            FifthQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    public String[] getAdvices() {
        final ManLifeAndSocialTips man_life_and_social = new ManLifeAndSocialTips(this.user);
        return man_life_and_social.getTips();
    }
}

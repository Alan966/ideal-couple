package com.mycompany.proyectouveg.FindCouple.LifeAndSocialPreferencesQuestions;

import com.mycompany.proyectouveg.Users.User;
import com.mycompany.proyectouveg.FindCouple.Services;

import java.util.Scanner;

public class ManLifestyleAndSocietyPreferences implements Services {
    @Override
    public void start() {

    }

    @Override
    public boolean StartGame(User user) {
        return false;
    }

    @Override
    public void FistQuestion(Scanner sn) {
        System.out.println("How do you prefer spending your weekends with a partner?");
        System.out.println("a) Going out, exploring new places, and meeting new people");
        System.out.println("b) A mix of going out and relaxing at home");
        System.out.println("c) Mostly staying in or having quiet time with close friends or family");
        System.out.println("d) Staying in, enjoying personal time, or relaxing together");
    }

    @Override
    public void SecondQuestion(Scanner sn) {
        System.out.println("How do you feel about a partner who enjoys social gatherings and events ?");
        System.out.println("a) I love it, I'm looking for someone social and outgoing");
        System.out.println("b) I appreciate it, as long as we also get time for just us");
        System.out.println("c) I'd prefer someone who enjoys small, intimate gatherings more than big events");
        System.out.println("d) I'm looking for someone who's more introverted and enjoys quiet nights");
    }

    @Override
    public void ThirdQuestion(Scanner sn) {
        System.out.println("What's your ideal balance between personal time and time spent together with your partner?");
        System.out.println("a) I'd like to spend most of our time together");
        System.out.println("b) I appreciate quality time but also value some personal space");
        System.out.println("c) I need a good amount of personal time to recharge");
        System.out.println("d) I highly value personal space and alone time");
    }

    @Override
    public void FourthQuestion(Scanner sn) {
        System.out.println("How important is it that your partner shared similar energy levels and preferences for social activities ?");
        System.out.println("a) Very important; I want a partner with similar social energy");
        System.out.println("b) Fairly important, it's nice if we align, but I'm flexible");
        System.out.println("c) It's fine if we have different energy levels as long as we compromise");
        System.out.println("d) No very important I don't mind if our energy levels differ");
    }

    @Override
    public void FifthQuestion(Scanner sn) {
        System.out.println("What's your preference for balancing work and leisure with a partner?");
        System.out.println("a) I'd like a partner who is as focused on work as I am, with occasional leisure time");
        System.out.println("b) I prefer a balance of work and play, with time dedicated ro relaxation");
        System.out.println("c) I lean toward a relaxed lifestyle, with more time for personal interests");
        System.out.println("d) I prefer minimal work stress and a lifestyle focused on enjoy and relaxation");
    }
}

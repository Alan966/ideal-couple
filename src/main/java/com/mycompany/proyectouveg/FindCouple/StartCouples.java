package com.mycompany.proyectouveg.FindCouple;

import com.mycompany.proyectouveg.FindCouple.EmotionalCouplesQuestions.ManEmotionalQuestions;
import com.mycompany.proyectouveg.FindCouple.EmotionalCouplesQuestions.WomanEmotionalQuestions;
import com.mycompany.proyectouveg.FindCouple.LifeAndSocialPreferencesQuestions.ManLifestyleAndSocietyPreferenceQuestions;
import com.mycompany.proyectouveg.FindCouple.LifeAndSocialPreferencesQuestions.WomanLifestyleAndSocietyPreferenceQuestions;
import com.mycompany.proyectouveg.FindCouple.LifeGoalsAndAmbitionsQuestions.ManLifeGoalsQuestions;
import com.mycompany.proyectouveg.FindCouple.LifeGoalsAndAmbitionsQuestions.WomanLifeGoalsQuestions;
import com.mycompany.proyectouveg.FindCouple.LoveLenguageAndAffectionQuestions.ManLoveLenguageQuestions;
import com.mycompany.proyectouveg.FindCouple.LoveLenguageAndAffectionQuestions.WomanLoveLenguageQuestions;
import com.mycompany.proyectouveg.Users.Gender;
import com.mycompany.proyectouveg.Users.User;

import java.util.Scanner;

public class StartCouples {
    private User user;
    private Scanner scanner;
    private Gender gender;
    private Couples emotional;
    private Couples love_lenguage;
    private Couples life_and_goals;
    private Couples life_and_social;
    private String [] [] advices = {
            {},
            {},
            {},
            {}
    };

    public StartCouples(User user, Scanner scanner) {
        this.user = user;
        this.scanner = scanner;
    }

    private void setGender() {
        this.gender = this.user.getGender();
    }

    private void setCouplesServices() {
            setGender();
        if (this.gender == Gender.Masculino) {
            setCouplesMale();
        } else {
            setCouplesFemale();
        }
    }

    private void setCouplesMale() {
        this.emotional = new ManEmotionalQuestions(this.scanner, this.user);
        this.life_and_goals = new ManLifeGoalsQuestions(this.scanner, this.user);
        this.love_lenguage = new ManLoveLenguageQuestions(this.scanner, this.user);
        this.life_and_social = new ManLifestyleAndSocietyPreferenceQuestions(this.scanner, this.user);
    }

    private void setCouplesFemale() {
        this.emotional = new WomanEmotionalQuestions(this.scanner, this.user);
        this.life_and_goals = new WomanLifeGoalsQuestions(this.scanner, this.user);
        this.love_lenguage = new WomanLoveLenguageQuestions(this.scanner, this.user);
        this.life_and_social = new WomanLifestyleAndSocietyPreferenceQuestions(this.scanner, this
                .user);
    }
    private void start(){
        setCouplesServices();
        this.emotional.start();
        this.life_and_goals.start();
        this.love_lenguage.start();
        this.life_and_social.start();
    }
    public  String[][] getAdvices(){
        start();
        this.advices[0] = this.emotional.getAdvices();
        this.advices[1] = this.life_and_goals.getAdvices();
        this.advices[2] = this.love_lenguage.getAdvices();
        this.advices[3] = this.life_and_social.getAdvices();
        return this.advices;
    }
}

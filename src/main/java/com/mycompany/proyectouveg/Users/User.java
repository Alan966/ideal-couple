package com.mycompany.proyectouveg.Users;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.mycompany.proyectouveg.FindCouple.EmotionalCouplesQuestions.emotional_states;
import com.mycompany.proyectouveg.FindCouple.LifeGoalsAndAmbitionsQuestions.life_and_ambitions_states;
import com.mycompany.proyectouveg.FindCouple.LoveLenguageAndAffectionQuestions.love_lenguage_states;
import com.mycompany.proyectouveg.FindCouple.LifeAndSocialPreferencesQuestions.life_and_social_preferences_states;

public class User implements IUser {
    private int id_user;
    private String first_name;
    private String last_name;
    private Gender gender;
    private String email;
    private String password;
    private emotional_states emotional_parnet;
    private life_and_ambitions_states life_and_ambition_partner;
    private love_lenguage_states love_lenguage_partner;
    private life_and_social_preferences_states life_and_social_preferences_couple;
    double id_counter = 0.00000001;
    Calendar birhtday;
    private boolean is_premium = false;
    private int amount_count = 0;

    public User(String first_name, String last_name, Gender gender, String email, String password, String year_mo_da) {
        id_counter++;
        this.id_user = (int) Math.ceil((id_counter * 100000000));
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.email = email;
        this.password = password;
        int year = Integer.parseInt(year_mo_da.split("/")[0]);
        int month = Integer.parseInt(year_mo_da.split("/")[1]) - 1;
        int day = Integer.parseInt(year_mo_da.split("/")[2]);
        this.birhtday = new GregorianCalendar(year, month, day);
    }

    @Override
    public void setEmotionalPartner(emotional_states emotional_parnet) {
        this.emotional_parnet = emotional_parnet;
    }

    ;

    @Override
    public void setLifeAndAmbitionPartner(life_and_ambitions_states life_am) {
        this.life_and_ambition_partner = life_am;
    }

    @Override
    public void setLenguageAndAffectionPartner(love_lenguage_states love_lenguage_and_affection_partner) {
    }


    public void setBirthday(String birthday) {
        int year = Integer.parseInt(birthday.split("/")[0]);
        int month = Integer.parseInt(birthday.split("/")[1]);
        int day = Integer.parseInt(birthday.split("/")[2]);
        this.birhtday = new GregorianCalendar(year, month, day);
    }

    ;

    public void setFistName(String first_name) {
        this.first_name = first_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setLoveLenguagePartner(love_lenguage_states loveL_lenguage_partner) {
        this.love_lenguage_partner = loveL_lenguage_partner;
    }

    public void setLifeAndSocialPreferences(life_and_social_preferences_states life_and_social_preferences_couple) {
        this.life_and_social_preferences_couple = life_and_social_preferences_couple;
    }

    public love_lenguage_states getLoveLenguagePartner() {
        return this.love_lenguage_partner;
    }

    public emotional_states getEmotionalPartner() {
        return this.emotional_parnet;
    }

    public life_and_ambitions_states getLifeAndAmbitions() {
        return this.life_and_ambition_partner;
    }

    public life_and_social_preferences_states getLifeAndSocialPreferencesCouple() {
        return this.life_and_social_preferences_couple;
    }

    @Override
    public int getUserId() {
        return this.id_user;
    }

    public java.lang.String getFullName() {
        return this.first_name + " " + this.last_name;
    }

    public String getFirstName() {
        return this.first_name;
    }

    public String getLastName() {
        return this.last_name;
    }

    public Gender getGender() {
        return this.gender;
    }

    public String getEmail() {
        return this.email;
    }


    public Date getBirthday() {
        return this.birhtday.getTime();
    }


    public void insetAmount(int amount) {
        //TODO: Implement process to Premium Users
        this.amount_count = amount;
        this.is_premium = true;
    }

    public boolean isPremium() {
        return is_premium;
    }


    public String[] getPremiumQuestions() {
        if (this.is_premium == false) {
            System.out.println("This user is not premium");
            String[] strings = {};
            return strings;
        }
        if (this.gender == Gender.Masculino) {
            return QuestionsPremiumMen();
        } else {
            return QuestionsPremiumWoman();
        }
    }

    private String[] QuestionsPremiumMen() {
        String[] premium_questions = {
                "When faced with a challenge, How do you typically react ?",
                "How do you feel about making major decisions on your own?",
                "How do you respond when someone challenges your opinion or ideas?",
                "When things go wrong in your life, What's your first reaction?",
                "How do you handle your finances?",
                "When faced with difficult emotional situation, what do you do?",
                "How do you view personal fitness and health ?",
                "How do you manage your time during the day? ",
                "When someone asks you for help, how do you approach it?",
                "How do you feel about taking on responsibility in a group or organization?"
        };
        return premium_questions;
    }

    private String[] QuestionsPremiumWoman() {
        String[] premium_questions = {
                "How do you typically react when you face stress?",
                "How do you prioritize your physical health?",
                "When faced with a difficult decision, how do you approach it?",
                "How do you deal with negative emotions like sadness or anger?",
                "How do you feel about self-care and personal time?",
                "How do you approach your relationships with family and friends?",
                "When it comes to your goals how do you approach them?",
                "How do you respond when things don't go as planned ?",
                "How do you feel about your own body image?",
                "How do you balance your career and personal life?",
        };
        return premium_questions;
    }

    ;
};

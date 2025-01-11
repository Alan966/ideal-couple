package com.mycompany.proyectouveg.Users;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

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

    public String getFullName() {
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


    public void setAmount(int amount) {
        //TODO: Implement process to Premium Users
        this.amount_count += amount;
        if (this.amount_count > 100) {
            this.is_premium = true;
        }
    }

    public boolean isPremium() {
        return is_premium;
    }

    public void maybeStartProcessPremium(Scanner sc) {
        if (this.is_premium == false) {
            System.out.println("You're not Premium So sorry");
            return;
        }
        startProcessPremium(sc, this.gender);
    }

    ;

};

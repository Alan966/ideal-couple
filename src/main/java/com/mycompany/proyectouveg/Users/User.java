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
    private boolean is_authenticated;
    private String token;
    private String password;
    private emotional_states emotional_parnet;
    private life_and_ambitions_states life_and_ambition_partner;
    private love_lenguage_states love_lenguage_partner;
    private life_and_social_preferences_states life_and_social_preferences_couple;
    double id_counter = 0.00000001;
    Calendar birhtday;

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
    };
    @Override
    public void  setLifeAndAmbitionPartner(life_and_ambitions_states life_am){
        this.life_and_ambition_partner = life_am;
    }

    @Override
    public void setLenguageAndAffectionPartner(love_lenguage_states love_lenguage_and_affection_partner) {}


    public void setBirthday(String birthday) {
        int year = Integer.parseInt(birthday.split("/")[0]);
        int month = Integer.parseInt(birthday.split("/")[1]);
        int day = Integer.parseInt(birthday.split("/")[2]);
        this.birhtday = new GregorianCalendar(year, month, day);
    };

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


    public void  setLoveLenguagePartner( love_lenguage_states loveL_lenguage_partner){
        this.love_lenguage_partner = loveL_lenguage_partner;
    }
    public void setLifeAndSocialPreferences(life_and_social_preferences_states life_and_social_preferences_couple){
        this.life_and_social_preferences_couple = life_and_social_preferences_couple;
    }

    public love_lenguage_states getLoveLenguagePartner() {
        return this.love_lenguage_partner;
    }

    public emotional_states getEmotionalPartner() {
        return this.emotional_parnet;
    }
    public life_and_ambitions_states getLifeAndAmbitions(){
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


    public void Authentication(String username, String password) {
        //TODO: Implement database for authenticated
        if (username.equals("changeThisUsername")) {
            is_authenticated = true;
            generateToken(username);
        } else {
            is_authenticated = false;
        }
    }

    public boolean isAuthenticated() {
        return is_authenticated;
    }

    @Override
    public void generateToken() {

    }

    public void generateToken(String username) {
        token = username + ":" + new Date().getTime();
    }

    public void getAction(Actions_enums action) {
        if (token.isEmpty()) {
            System.out.println("Token is empty");
        }
        switch (action) {
            case action_one -> ActionOne();
            case action_two -> ActionTwo();
            case action_three -> ActionThree();
            case action_four -> ActionFour();
        }
    }

    private void ActionOne() {
        System.out.println("Action One");
    }

    private void ActionTwo() {
        System.out.println("Action Two");
    }

    private void ActionThree() {
        System.out.println("Action Three");
    }

    private void ActionFour() {
        System.out.println("Action Four");
    }
}

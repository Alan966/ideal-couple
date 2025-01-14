package com.mycompany.proyectouveg.Users;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.mycompany.proyectouveg.FindCouple.Couples;
import com.mycompany.proyectouveg.FindCouple.EmotionalCouplesQuestions.ManEmotionalQuestions;
import com.mycompany.proyectouveg.FindCouple.EmotionalCouplesQuestions.WomanEmotionalQuestions;
import com.mycompany.proyectouveg.FindCouple.EmotionalCouplesQuestions.emotional_states;
import com.mycompany.proyectouveg.FindCouple.LifeAndSocialPreferencesQuestions.ManLifestyleAndSocietyPreferenceQuestions;
import com.mycompany.proyectouveg.FindCouple.LifeAndSocialPreferencesQuestions.WomanLifestyleAndSocietyPreferenceQuestions;
import com.mycompany.proyectouveg.FindCouple.LifeGoalsAndAmbitionsQuestions.ManLifeGoalsQuestions;
import com.mycompany.proyectouveg.FindCouple.LifeGoalsAndAmbitionsQuestions.WomanLifeGoalsQuestions;
import com.mycompany.proyectouveg.FindCouple.LifeGoalsAndAmbitionsQuestions.life_and_ambitions_states;
import com.mycompany.proyectouveg.FindCouple.LoveLenguageAndAffectionQuestions.ManLoveLenguageQuestions;
import com.mycompany.proyectouveg.FindCouple.LoveLenguageAndAffectionQuestions.WomanLoveLenguageQuestions;
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
    private double id_counter = 0.00000001;
    private Calendar birhtday;
    private boolean is_premium = false;
    private int amount_count = 0;
    private Scanner sc;
    private Couples emotional;
    private Couples love_lenguage;
    private Couples life_and_goals;
    private Couples life_and_social;
    private String[][] advices = {
            {},
            {},
            {},
            {}
    };

    private void ConstructorUser(Scanner sc) {
        id_counter++;
        System.out.println("Ingresa los siguientes valores para evaluarte un Usuario: ");
        System.out.println("Ingresa el nombre");
        String first_name = sc.nextLine();
        System.out.println("Ingresa el apellido");
        String last_name = sc.nextLine();
        System.out.println("Ingresa el sexo");
        String response_gender_scanner = sc.nextLine();
        Gender gender;
        if (response_gender_scanner.equalsIgnoreCase("masculino")) {
            gender = Gender.Masculino;
        } else {
            gender = Gender.Femenino;
        }
        System.out.println("Ingresa email");
        String email = sc.nextLine();
        System.out.println("Ingresa Password");
        String password = sc.nextLine();
        System.out.println("Ingresa la fecha de nacimiento en este formato yyyy/mm/day");
        String birthday = sc.nextLine();
        this.id_user = (int) Math.ceil((id_counter * 100000000));
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.email = email;
        this.password = password;
        int year = Integer.parseInt(birthday.split("/")[0]);
        int month = Integer.parseInt(birthday.split("/")[1]) - 1;
        int day = Integer.parseInt(birthday.split("/")[2]);
        this.birhtday = new GregorianCalendar(year, month, day);
        this.sc = sc;
    }

    public User(Scanner sc) {
        ConstructorUser(sc);
        System.out.println("Quieres poner dinero en tu cuenta");
        String response = sc.nextLine();
        if (response.equals(("Si"))) {
            System.out.println("Ingresa la cantidad que quieres poner en tu cuenta");
            int amount = sc.nextInt();
            this.amount_count = amount;
            if (this.amount_count > 100) {
                this.is_premium = true;
            }
        }

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
        this.love_lenguage_partner = love_lenguage_and_affection_partner;
    }

    public void setLifeAndSocialPreferences(life_and_social_preferences_states life_and_society_parter) {
        this.life_and_social_preferences_couple = life_and_society_parter;
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
        if (!this.is_premium) {
            return;
        }
        startProcessPremium(sc, this.gender);
    }

    ;

    private void setCouplesMale() {
        this.emotional = new ManEmotionalQuestions(this.sc, this);
        this.life_and_goals = new ManLifeGoalsQuestions(this.sc, this);
        this.love_lenguage = new ManLoveLenguageQuestions(this.sc, this);
        this.life_and_social = new ManLifestyleAndSocietyPreferenceQuestions(this.sc, this);
    }

    private void setCouplesFemale() {
        this.emotional = new WomanEmotionalQuestions(this.sc, this);
        this.life_and_goals = new WomanLifeGoalsQuestions(this.sc, this);
        this.love_lenguage = new WomanLoveLenguageQuestions(this.sc, this);
        this.life_and_social = new WomanLifestyleAndSocietyPreferenceQuestions(this.sc, this
        );
    }

    private void setCouplesServices() {
        if (this.gender == Gender.Masculino) {
            setCouplesMale();
        } else {
            setCouplesFemale();
        }
    }

    public void start() {
        setCouplesServices();
        this.emotional.start();
        this.life_and_goals.start();
        this.love_lenguage.start();
        this.life_and_social.start();
    }

    public String[][] getAdvices() {
        this.advices[0] = this.emotional.getAdvices();
        this.advices[1] = this.life_and_goals.getAdvices();
        this.advices[2] = this.love_lenguage.getAdvices();
        this.advices[3] = this.life_and_social.getAdvices();
        return this.advices;
    }

};

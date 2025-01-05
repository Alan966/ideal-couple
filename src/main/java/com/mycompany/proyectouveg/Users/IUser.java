package com.mycompany.proyectouveg.Users;
import com.mycompany.proyectouveg.FindCouple.EmotionalCouplesQuestions.emotional_states;
import com.mycompany.proyectouveg.FindCouple.LifeGoalsAndAmbitionsQuestions.life_and_ambitions_states;
import com.mycompany.proyectouveg.FindCouple.LoveLenguageAndAffectionQuestions.love_lenguage_states;

import java.util.Date;

public interface IUser {
    // Setter methods
    public void setBirthday( String birthday);
    public void setFistName(String first_name);
    public void setLastName(String last_name);
    public void setGender(Gender gender);
    public void setEmail(String email);

    //Setters for states of their partner
    public void setEmotionalPartner(emotional_states emotional_state_partner);
    public void setLifeAndAmbitionPartner(life_and_ambitions_states life_and_ambitions_partner);
    public void setLenguageAndAffectionPartner(love_lenguage_states love_lenguage_and_affection_partner);


    // Getters methods
    public int getUserId();
    public String getFullName();
    public String getFirstName();
    public String getLastName();
    public Gender getGender();
    public String getEmail();
    public Date getBirthday();



    //Getters for states of their partner
    public love_lenguage_states getLoveLenguagePartner();
    public emotional_states getEmotionalPartner();
    public life_and_ambitions_states getLifeAndAmbitions();


}

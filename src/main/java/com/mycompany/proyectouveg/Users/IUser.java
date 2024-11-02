package com.mycompany.proyectouveg.Users;
import com.mycompany.proyectouveg.interfaces.*;

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
    public void setLifeAndAmbitionPartner(life_and_ambitions life_and_ambitions_partner);
    public void setLenguageAndAffectionPartner(love_lenguage_and_affection love_lenguage_and_affection_partner);


    // Getters methods
    public int getUserId();
    public String getFullName();
    public String getFirstName();
    public String getLastName();
    public Gender getGender();
    public String getEmail();
    public Date getBirthday();



    //Getters for states of their partner
    public love_lenguage_and_affection getLoveLenguagePartner();
    public emotional_states getEmotionalPartner();
    public life_and_ambitions getLifeAndAmbitions();

    public void Authentication (String username, String password);
    public boolean isAuthenticated();
    public void generateToken();

}

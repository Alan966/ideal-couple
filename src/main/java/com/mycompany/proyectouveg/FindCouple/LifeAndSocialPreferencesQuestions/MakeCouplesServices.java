package com.mycompany.proyectouveg.FindCouple.LifeAndSocialPreferencesQuestions;

import com.mycompany.proyectouveg.Users.User;
public class MakeCouplesServices {
    private User user;
    public  MakeCouplesServices (User user){
        this.user = user;
    }
    public life_and_social_preferences_states_man getManLifeAnSocialPreferencesCouple(){
        switch (this.user.getLifeAndSocialPreferencesCouple()) {
            case life_and_social_preferences_states_woman.socially_engaged_partner:
                return life_and_social_preferences_states_man.socially_driver_partner;
            case life_and_social_preferences_states_woman.home_oriented_partner:
                return life_and_social_preferences_states_man.socially_flexible_partner;
            case life_and_social_preferences_states_woman.socially_flexible_partner:
                return life_and_social_preferences_states_man.family_oriented_partner;
            default:
                return life_and_social_preferences_states_man.laid_back_private_partner;
        }
    }

    public life_and_social_preferences_states_woman getWomanLifeAndSocialPreferencesCouple(){
        switch (this.user.getLifeAndSocialPreferencesCouple()){
            case life_and_social_preferences_states_man.socially_driver_partner:
                return life_and_social_preferences_states_woman.socially_engaged_partner;
            case life_and_social_preferences_states_man.socially_flexible_partner:
                return life_and_social_preferences_states_woman.home_oriented_partner;
            case  life_and_social_preferences_states_man.family_oriented_partner:
                return life_and_social_preferences_states_woman.socially_flexible_partner;
            default:
                return  life_and_social_preferences_states_woman.personal_space_oriented_partner;
        }
    }
}

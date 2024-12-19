package com.mycompany.proyectouveg.FindCouple.LifeAndSocialPreferencesQuestions;

import com.mycompany.proyectouveg.Users.User;
public class MakeCouplesServices {
    private User user;
    public  MakeCouplesServices (User user){
        this.user = user;
    }
    public life_and_social_preferences_states_man getManLifeAnSocialPreferencesCouple(){
        life_and_social_preferences_states_woman life_and_social_state = (life_and_social_preferences_states_woman) this.user.getLifeAndSocialPreferencesCouple();
        return switch (life_and_social_state) {
            case socially_engaged_partner ->
                    life_and_social_preferences_states_man.socially_driver_partner;
            case home_oriented_partner ->
                    life_and_social_preferences_states_man.socially_flexible_partner;
            case socially_flexible_partner ->
                    life_and_social_preferences_states_man.family_oriented_partner;
            default -> life_and_social_preferences_states_man.laid_back_private_partner;
        };
    }

    public life_and_social_preferences_states_woman getWomanLifeAndSocialPreferencesCouple(){
        life_and_social_preferences_states_man life_and_social_preference = (life_and_social_preferences_states_man) this.user.getLifeAndSocialPreferencesCouple();
        return switch (life_and_social_preference) {
            case socially_driver_partner ->
                    life_and_social_preferences_states_woman.socially_engaged_partner;
            case socially_flexible_partner ->
                    life_and_social_preferences_states_woman.home_oriented_partner;
            case family_oriented_partner ->
                    life_and_social_preferences_states_woman.socially_flexible_partner;
            default -> life_and_social_preferences_states_woman.personal_space_oriented_partner;
        };
    }
}

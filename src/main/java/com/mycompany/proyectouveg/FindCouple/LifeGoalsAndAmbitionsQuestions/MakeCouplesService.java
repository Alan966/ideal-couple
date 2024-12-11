package com.mycompany.proyectouveg.FindCouple.LifeGoalsAndAmbitionsQuestions;

import com.mycompany.proyectouveg.Users.User;

public class MakeCouplesService {
    private User user;
    public MakeCouplesService( User user){
        this.user = user;
    }

    public  life_and_ambitions_states_man getMenLifeAndAmbitionsCouple(){
        switch (this.user.getLifeAndAmbitions()) {
            case life_and_ambitions_states_woman.team_oriented_woman:
                return life_and_ambitions_states_man.balanced_team_oriented_partner;
            case life_and_ambitions_states_woman.family_focused_supportive:
                return life_and_ambitions_states_man.more_traditional_family_focused;
            case life_and_ambitions_states_woman.traditional_family_oriented:
                return life_and_ambitions_states_man.highly_ambitious_supportive_partner;
            default:
                return life_and_ambitions_states_man.traditional_provider_led_relationship;
        }
    }

    public life_and_ambitions_states_woman getWomenLifeAndAmbitionCouple(){
        switch (this.user.getLifeAndAmbitions()){
            case life_and_ambitions_states_man.balanced_team_oriented_partner:
                return life_and_ambitions_states_woman.team_oriented_woman;
            case life_and_ambitions_states_man.more_traditional_family_focused:
                return life_and_ambitions_states_woman.family_focused_supportive;
            case life_and_ambitions_states_man.traditional_provider_led_relationship:
                return life_and_ambitions_states_woman.highly_ambitious_career;
            default:
                return life_and_ambitions_states_woman.traditional_family_oriented;
        }
    }

}

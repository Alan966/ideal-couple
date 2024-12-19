package com.mycompany.proyectouveg.FindCouple.LifeGoalsAndAmbitionsQuestions;

import com.mycompany.proyectouveg.Users.User;

public class MakeCouplesService {
    private User user;

    public MakeCouplesService(User user) {
        this.user = user;
    }

    public life_and_ambitions_states_man getMenLifeAndAmbitionsCouple() {
        life_and_ambitions_states_woman life_and_ambitions = (life_and_ambitions_states_woman) this.user.getLifeAndAmbitions();
        return switch (life_and_ambitions) {
            case team_oriented_woman -> life_and_ambitions_states_man.balanced_team_oriented_partner;
            case family_focused_supportive -> life_and_ambitions_states_man.more_traditional_family_focused;
            case traditional_family_oriented -> life_and_ambitions_states_man.highly_ambitious_supportive_partner;
            default -> life_and_ambitions_states_man.traditional_provider_led_relationship;
        };
    }

    public life_and_ambitions_states_woman getWomenLifeAndAmbitionCouple() {
        life_and_ambitions_states_man life_and_ambitions_state = (life_and_ambitions_states_man) this.user.getLifeAndAmbitions();
        switch (life_and_ambitions_state) {
            case balanced_team_oriented_partner:
                return life_and_ambitions_states_woman.team_oriented_woman;
            case more_traditional_family_focused:
                return life_and_ambitions_states_woman.family_focused_supportive;
            case traditional_provider_led_relationship:
                return life_and_ambitions_states_woman.highly_ambitious_career;
            default:
                return life_and_ambitions_states_woman.traditional_family_oriented;
        }
    }

}

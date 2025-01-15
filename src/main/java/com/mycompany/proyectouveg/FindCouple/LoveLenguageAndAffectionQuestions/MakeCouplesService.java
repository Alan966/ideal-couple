package com.mycompany.proyectouveg.FindCouple.LoveLenguageAndAffectionQuestions;

import com.mycompany.proyectouveg.Users.User;

public class MakeCouplesService {
    private final User user;

    public MakeCouplesService(User _user) {
        this.user = _user;
    }

    public love_lenguage_states_man getManLoveLenguageAndAffection() {
        final love_lenguage_states_woman love_lenguage_state = (love_lenguage_states_woman) this.user.getLoveLenguagePartner();
        switch (love_lenguage_state) {
            case reserved_independent_partner:
                return love_lenguage_states_man.thoughtful_emotionally_engaged;
            case low_key_independent_partner:
                return love_lenguage_states_man.supportive_balanced_partner;
            case balanced_supportive_partner:
                return love_lenguage_states_man.low_key_reliable_partner;
            default:
                return love_lenguage_states_man.independent_reserved_partner;
        }
    }

    public love_lenguage_states_woman getWomanLoveLenguageAndAffection() {
        final love_lenguage_states_man love_lenguage_state = (love_lenguage_states_man) this.user.getLoveLenguagePartner();
        return switch (love_lenguage_state) {
            case thoughtful_emotionally_engaged -> love_lenguage_states_woman.reserved_independent_partner;
            case supportive_balanced_partner -> love_lenguage_states_woman.low_key_independent_partner;
            case low_key_reliable_partner -> love_lenguage_states_woman.balanced_supportive_partner;
            default -> love_lenguage_states_woman.warm_affection_partner;
        };
    }
}

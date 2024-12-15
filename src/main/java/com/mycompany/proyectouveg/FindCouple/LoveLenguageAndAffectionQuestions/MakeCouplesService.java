package com.mycompany.proyectouveg.FindCouple.LoveLenguageAndAffectionQuestions;

import com.mycompany.proyectouveg.Users.User;

public class MakeCouplesService {
    private User user;
    public MakeCouplesService(User user){
        this.user = user;
    }
    public love_lenguage_states_man getManLoveLenguageAndAffection(){
     switch (this.user.getLoveLenguagePartner()){
         case love_lenguage_states_woman.reserved_independent_partner:
             return love_lenguage_states_man.thoughtful_emotionally_engaged;
         case love_lenguage_states_woman.low_key_independent_partner:
             return love_lenguage_states_man.supportive_balanced_partner;
         case love_lenguage_states_woman.balanced_supportive_partner:
             return love_lenguage_states_man.low_key_reliable_partner;
         default:
             return love_lenguage_states_man.independent_reserved_partner;
     }
    }
    public love_lenguage_states_woman getWomanLoveLenguageAndAffection(){
        switch (this.user.getLoveLenguagePartner()){
            case love_lenguage_states_man.thoughtful_emotionally_engaged:
                return love_lenguage_states_woman.reserved_independent_partner;
            case love_lenguage_states_man.supportive_balanced_partner:
                return love_lenguage_states_woman.low_key_independent_partner;
            case love_lenguage_states_man.low_key_reliable_partner:
                return love_lenguage_states_woman.balanced_supportive_partner;
            default:
                return love_lenguage_states_woman.warm_affection_partner;
        }
    }
}

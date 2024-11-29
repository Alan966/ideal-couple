package com.mycompany.proyectouveg.FindCouple.EmotionalCouplesQuestions;

import com.mycompany.proyectouveg.FindCouple.TipsToGetCouple;
import com.mycompany.proyectouveg.Users.User;

public class WomanTipsToGetCouple implements TipsToGetCouple {
    private User user;
    private String [] [] tips_emotional_women = {
            {""},
            {""},
            {""},
            {""}
    };
    private emotional_states emotional_state_man;
    public WomanTipsToGetCouple (User user){
        this.user = user;
    }
    private void getEmotionalWomanCouples(){
        this.emotional_state_man = user.getEmotionalPartner();
    }
    @Override
    public String[] getTipsForCuple() {
        String [] default_string = {"", "", ""};
        if(this.emotional_state_man == null){
            getEmotionalWomanCouples();
        }
        switch (this.emotional_state_man) {
            case emotional_states_man.stoic_protector:
                return tips_emotional_women[0];
            case emotional_states_man.calm_problem_solver:
                return tips_emotional_women[1];
            case emotional_states_man.balanced_listener:
                return  tips_emotional_women[2];
            case emotional_states_man.emotional_connection:
                return tips_emotional_women[3];
            default:
                return default_string;
        }
    }
}

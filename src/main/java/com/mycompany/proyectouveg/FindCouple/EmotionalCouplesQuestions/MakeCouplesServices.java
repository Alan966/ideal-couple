package com.mycompany.proyectouveg.FindCouple.EmotionalCouplesQuestions;

import com.mycompany.proyectouveg.Users.User;

public class MakeCouplesServices {
    private User user;
    public MakeCouplesServices(User user){
        this.user = user;
    }
    public emotional_states_man getMenEmotionalCouple(){
        switch (this.user.getEmotionalPartner()){
            case emotional_states_woman.emotionally_engaged:
                return emotional_states_man.stoic_protector;
            case emotional_states_woman.emotionally_balanced:
                return emotional_states_man.balanced_listener;
            case emotional_states_woman.emotionally_independent:
                return emotional_states_man.calm_problem_solver;
            default:
                return emotional_states_man.emotional_connection;
        }
    }
    public emotional_states_woman getWomenEmotionalCouple(){
        switch (this.user.getEmotionalPartner()){
            case emotional_states_man.stoic_protector:
                return  emotional_states_woman.emotionally_engaged;
            case emotional_states_man.balanced_listener:
                return emotional_states_woman.emotionally_balanced;
            case emotional_states_man.calm_problem_solver:
                return  emotional_states_woman.emotionally_independent;
            default:
                return emotional_states_woman.emotionally_reserved;
        }
    }
}

package com.mycompany.proyectouveg.FindCouple.EmotionalCouplesQuestions;

import com.mycompany.proyectouveg.Users.User;

import static com.mycompany.proyectouveg.FindCouple.EmotionalCouplesQuestions.emotional_states_woman.*;
import static com.mycompany.proyectouveg.FindCouple.EmotionalCouplesQuestions.emotional_states_man.*;

public class MakeCouplesServices {
    private User user;
    public MakeCouplesServices(User user){
        this.user = user;
    }
    public emotional_states_man getMenEmotionalCouple(){
        emotional_states_woman emotional_state = (emotional_states_woman) this.user.getEmotionalPartner();
            return switch (emotional_state) {
                case emotionally_engaged -> stoic_protector;
                case emotionally_balanced -> balanced_listener;
                case emotionally_independent -> calm_problem_solver;
                default -> emotional_connection;
            };
    }
    public emotional_states_woman getWomenEmotionalCouple(){
        emotional_states_man emotional_state = (emotional_states_man) this.user.getEmotionalPartner();
        return switch (emotional_state) {
            case stoic_protector -> emotionally_engaged;
            case balanced_listener -> emotionally_balanced;
            case calm_problem_solver -> emotionally_independent;
            default -> emotionally_reserved;
        };
    }
}

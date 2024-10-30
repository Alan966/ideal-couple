package com.mycompany.proyectouveg.enums.enumsEmotions;

import com.mycompany.proyectouveg.interfaces.emotional_states;

public enum emotional_man implements emotional_states {
    emotional_connection,
    balanced_listener,
    calm_problem_solver,
    stoic_protector;
    public String getDescription(){
        return "This is the enum of emotional states of a man";
    }
}
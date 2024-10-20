package com.mycompany.proyectouveg.Services;

public enum emotional_man implements emotional_states{
    emotional_connection,
    balanced_listener,
    calm_problem_solver,
    stoic_protector;
    public String getDescription(){
        return "This is the enum of emotional states of a man";
    }
}

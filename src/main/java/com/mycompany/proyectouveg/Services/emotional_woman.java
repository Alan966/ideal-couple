package com.mycompany.proyectouveg.Services;

public enum emotional_woman implements  emotional_states{
    emotionally_engaged,
    emotionally_balanced,
    emotionally_independent,
    emotionally_reserved;
    public String getDescription(){
        return "This is the enum of emotional state of a woman";
    }
}

package com.mycompany.proyectouveg.FindCouple.EmotionalCouplesQuestions;

import com.mycompany.proyectouveg.FindCouple.TipsToGetCouple;
import com.mycompany.proyectouveg.Users.User;

public class WomanTipsToGetCouple implements TipsToGetCouple {
    private User user;
    private String [] [] tips_emotional_women = {
            {"Wake up early and spend 10 - 15 minutes journaling or planning your day to create mental dicipline",
                    "Learn a skill that not only boots confidence but also signals self-reliance",
                    "Practice being more private. Avoid oversharing online to naturally develop mystery and focus on yourself"
            },
            {},
            {},
            {""}
    };
    private emotional_states emotional_state_woman;
    public WomanTipsToGetCouple (User user){
        this.user = user;
    }
    private void getEmotionalWomanState(){
        MakeCouplesServices couple_service = new MakeCouplesServices(this.user);
        emotional_state_woman = couple_service.getWomenEmotionalCouple();
    }
    @Override
    public String[] getTips() {
        String [] default_string = {"", "", ""};
        if(this.emotional_state_woman == null){
            getEmotionalWomanState();
        }
        switch (this.emotional_state_woman) {
            case emotional_states_woman.emotionally_engaged:
                return tips_emotional_women[0];
            case emotional_states_woman.emotionally_balanced:
                return tips_emotional_women[1];
            case emotional_states_woman.emotionally_independent:
                return  tips_emotional_women[2];
            case emotional_states_woman.emotionally_reserved:
                return tips_emotional_women[3];
            default:
                return default_string;
        }
    }
}

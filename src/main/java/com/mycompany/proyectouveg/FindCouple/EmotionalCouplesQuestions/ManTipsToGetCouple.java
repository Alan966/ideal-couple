package com.mycompany.proyectouveg.FindCouple.EmotionalCouplesQuestions;

import com.mycompany.proyectouveg.FindCouple.TipsToGetCouple;
import com.mycompany.proyectouveg.Users.User;

public class ManTipsToGetCouple implements TipsToGetCouple {
    private User user;
     private String [][] tips_emotional_womans = {
             {"Spend 10 - 15 minutes meditating to improve your emotional control and reduce impulsive reactions. Apps Like Headspace or Calm can help",
                     "Start your day at 5 - 6 am to build discipline and give yourself time to reflect or plan without distractions",
                     "Avoid overreacting to problems, instead, pause, take a deep breath, and think critically before responding",
                     "Martial arts, weightlifting, or long-distance running helps build mental and physical resilience",
                     "Write down your thoughts daily to process emotions privately rather than venting outward"
             },
             {"Start with Emotional Intelligence 2.0 by Travis Bradberry to learn empathy and balance in communication",
                     "Dedicate 15-20 minutes daily to actively listen to others without interrupting, Reflect on what they share rather than offering immediate solutions",
                     "Explore activities like yoga, painting, or a team sport to maintain a well-rounded lifestyle",
                     "Every Sunday, plan how to balance work and social connections",
                     "List three things you're grateful for every night. This will make you more aware of what you value and help in grounding relationships"
             },
             {"Establish day routine (exercise work, relaxation) that doesn't depend on anyone else for motivation or structure",
                     "Write down short-term and long-term goals. Regularly assess your progress independently",
                     "Reduce or eliminate posting for likes or comments. Focus on real-world accomplishments",
                     "Travel alone, or spend time doing activities like hiking or exploring a city by yourself to develop self-sufficiency",
                     "Learn a new skill or take up challenging hobby like learning a language or mastering a musical instrument"
             },
             {"Practice sharing one emotion you felt during the day with a friend or famility member. Over time this becomes natural",
                     "Hug loved ones more often or use small acts of kindness (like cooking for someone) to show care",
                     "Volunteering or participating in local events can help you connect with others and express yourself naturally",
                     "Stories with emotional depth help you process and understand emotions better",
                     "Share a small but personal detail yourself during conversations, gradually open up to others as trust builds"
             }
     };
    private emotional_states emotional_state_woman;
    public ManTipsToGetCouple(User user){
        this.user = user;
    }
    private void getEmotionalWomanCouple(){
        this.emotional_state_woman = user.getEmotionalPartner();
    }

    @Override
    public String[] getTipsForCuple() {
        String [] default_string = {"", "", ""};
        switch (this.emotional_state_woman){
            case emotional_states_woman.emotionally_engaged:
                return tips_emotional_womans[0];
            case emotional_states_woman.emotionally_balanced:
                return tips_emotional_womans[1];
            case emotional_states_woman.emotionally_independent:
                return tips_emotional_womans[2];
            case emotional_states_woman.emotionally_reserved:
                return tips_emotional_womans[3];
            default:
                return default_string;
        }
    }
}

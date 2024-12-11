package com.mycompany.proyectouveg.FindCouple.EmotionalCouplesQuestions;

import com.mycompany.proyectouveg.FindCouple.TipsToGetCouple;
import com.mycompany.proyectouveg.Users.User;

public class ManEmotionalTips implements TipsToGetCouple {
    private User user;
     private String [][] tips_emotional_mens = {
             {"Wake up early and set a daily routine: Structure your day to build dicipline. Start with simple habits like exercising or journaling every morning",
                     "Practice control in challeging situations: Stay calm when things go wrong - pause before react. Use breathing exercise like 4-7-8 technique to manage stress",
                     "Lift weights or train in martial arts: Physical strength builds confidence ans symbolizes protection. Martial arts also improve mental dicipline",
                     "Limit emotional over-sharing: Share only that is necessary when discussing problems. Focus on being a good listener rather than seeking validation",
                     "Read books on philosophy: Dive into Meditations by Marcus Aurelius or The Obstacle Is the Way by Ryan holiday to develop a stoic mindset"
             },
             {"Practice solving puzzles daily: Spend 15 minutes on Sudoku, chess or logic puzzles to sharpen problem-solving skills",
                     "Break down problems into steps: Whenever you face an issue, write it out and identify actionable steps instead of being overwhelmed",
                     "Improve decision-making under pressure: Use simulation exercise like playing strategy games: civilization or chess",
                     "Learn affective communication: Use techniques like active listening and asking clarifying questions to understand other's perspectives",
                     "Keep a solution-oriented journal: Reflect daily on problems you faced and how you resolved them, reinforcing a constructive mindset"
             },
             {"Set daily for deep conversations: Talk to someone(friend, coworker or family member) and focus solely on listening without interrupting",
                     "Practice active listening: Repeat what other person said to confirm you understand, and avoid focus solely on listening without interrupting",
                     "Attend a public speaking or improv class: These improve you ability to express yourself and adapt to different conversational dynamics",
                     "Limit distractions in social settings: When speaking to someone, keep your phone away to ensure undivided attention",
                     "Read books on empathy and communication: Try How to Win Friends and Influence People by Dale Carnegie or Nonviolent Communication by Marshall Rosenberg"
             },
             {"Practice vulnerability: Share one meaningful thought or feeling with someone close to you each day. Start small and build trust gradually",
                     "Develop emotional awareness: Reflect on your emotions daily by journaling - write down that yu felt, why and how you reacted",
                     "Volunteer for cause you care about : Helping others fosters empathy and emotional understanding ",
                     "Learn emotional expression through art: Practice drawing, writing poetry, or playing music to connect with and express your feelings",
                     "Seek therapy or counseling (if needed): A professional can help you explore and undestand your emotions in safe, guide way"
             }
     };
    private emotional_states emotional_state_men;
    public ManEmotionalTips(User user){
        this.user = user;
    }
    private void getEmotionalMenState(){
        MakeCouplesServices couple_service = new MakeCouplesServices(this.user);
        emotional_state_men = couple_service.getMenEmotionalCouple();
    }

    @Override
    public String[] getTips() {
        if(this.emotional_state_men == null){
            getEmotionalMenState();
        }
        String [] default_string = {"", "", ""};
        switch (this.emotional_state_men){
            case emotional_states_man.stoic_protector:
                return tips_emotional_mens[0];
            case emotional_states_man.calm_problem_solver:
                return tips_emotional_mens[1];
            case emotional_states_man.balanced_listener:
                return tips_emotional_mens[2];
            case emotional_states_man.emotional_connection:
                return tips_emotional_mens[3];
            default:
                return default_string;
        }
    }
}

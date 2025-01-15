package com.mycompany.proyectouveg.FindCouple.EmotionalCouplesQuestions;

import com.mycompany.proyectouveg.FindCouple.TipsToGetCouple;
import com.mycompany.proyectouveg.Users.User;

public class WomanEmotionalTips implements TipsToGetCouple {
    private final User user;
    private static final String[][] tips_emotional_women = {
            {"Start gratitude journal:Write down three things you're thankful for every day. It fosters emotional positivity and openness to others",
                    "Practice active appreciation: Compliment or thank someone daily to build emotional bonds and show you warmth",
                    "Join a group focused on connection: Attend workshops like storytelling, creative writing or expressive dance to share emotions openly with others",
                    "Practice mindful listening: In conversations, focus fully on the other person without interrupting, and ask follow-up questions",
                    "Engage in reflective exercises: Spend 10 minutes daily identifying your feelings and how they connect to your relationship"
            },
            {
                    "Practice daily mindfulness: Spend 10 minutes meditating or using a mindfulness app to center yourself emotionally",
                    "Set emotional boundaries: Lean to say 'no' politely but firmly when you feel your energy is bring drained",
                    "Engage in physical activity: Exercise like yoga or Pilates can regulate emotions and help maintain balance",
                    "Use a 'check-in' 'system': Regularly ask yourself hoe you're feeling and why - acknowledge emotions without judment",
                    "Read self - help or psychology books: Books like Emotional Agility by Susan David can provide tools to manage emotions healthily"
            },
            {
                    "Develop a solo hobby: Take up painting, hiking, or coding something you can enjoy alone and grow from",
                    "Establish a self-care routine: Dedicate at least an hour weekly to activities that rejuvenate and empower you, like spa treatments or journaling",
                    "Set and achieve personal goals: Write down small, achievable goals, like learning a new skill or saving money for something meaningful",
                    "Limit external validation: Spend a week avoiding social media likes or posting updates. Focus on doing things for yourself, not for others approval",
                    "Travel alone or take solo outings: Start with small trips to museums , cafe, or parks to build confidence in enjoying your own company"
            },
            {"Write in a personal journal: Use journaling as a way to explore and organize your feelings in private",
                    "Take time to recharge: Dedicate specific times during the week to be alone in peaceful environment, like a nature walk or quit room",
                    "Express through creative outlets: Try drawing , playing music, or gardening to channel emotions in ways that feel natural",
                    "Practice saying I'll thin about it: Use this phrase in conversations to avoid reacting immediately and create space to process emotions",
                    "Read fiction or poetry: Immersing yourself in emotionally rich stories can help you explore feelings and connections indirectly"
            }
    };
    private emotional_states emotional_state_woman;

    public WomanEmotionalTips(User _user) {
        this.user = _user;
    }

    private void getEmotionalWomanState() {
        MakeCouplesServices couple_service = new MakeCouplesServices(this.user);
        emotional_state_woman = couple_service.getWomenEmotionalCouple();
    }

    @Override
    public String[] getTips() {
        if (this.emotional_state_woman == null) {
            getEmotionalWomanState();
        }
        emotional_states_woman emotional_state = (emotional_states_woman) this.emotional_state_woman;
        return switch (emotional_state) {
            case emotionally_engaged -> tips_emotional_women[0];
            case emotionally_balanced -> tips_emotional_women[1];
            case emotionally_independent -> tips_emotional_women[2];
            default -> tips_emotional_women[3];
        };
    }
}

package com.mycompany.proyectouveg.FindCouple.LoveLenguageAndAffectionQuestions;

import com.mycompany.proyectouveg.FindCouple.TipsToGetCouple;
import com.mycompany.proyectouveg.Users.User;

public class WomanLoveLenguageTips implements TipsToGetCouple {
    private User user;
    private love_lenguage_states_woman love_lenguage_states;
    private String [][] tips_life_and_ambitions = {
            {
                "Start a Daily Gratitude Practice:Spend 5 minutes daily reflecting on what you appreciate about people in your life. This trains you to express gratitude more naturally",
                    "Practice Physical Affection with Close Loved Ones: Hug your friends or family members when greeting or saying goodbye. If you're shy, start small with light touches on the arm or hand ",
                    "Write or Say Encouraging Words Daily: Compliment one person a day, or leave a kind note for someone. This builds your habit of verbal warmth and encouragement",
                    "Host or Organize Social Gatherings: Create opportunities to nature connections, like organizing a dinner or coffee with friends. Warmth grows through meaningful social interactions",
                    "Learn Emotional Vulnerability: Share your feelings with trusted people, even if it feels uncomfortable. Start with small things (I really appreciated you listening to me earlier) "
            },
            {
                "Learn Active Listening Techniques: During conversations, focus fully on the other person. Reflect back on what they say, and avoid giving unsolicited advice unless asked",
                    "Practice Emotional Regulation: Use breathing exercises or mindfulness techniques to stay calm in stressful situations. For example, take 5 deep breaths before responding in a conflict",
                    "Develop Healthy Boundaries: Make a list of what you can and cannot offer emotionally and practically to others. Communicate these limits kindly but firmly",
                    "Offer Help Thoughtfully: Check in with people and ask if they need support, instead of assuming or stepping in uninvited. For example: 'Is there anything I can help you with ?'",
                    "Focus on Self-Care Weekly: Dedicate time each week to something that recharges you, Such as yoga, journaling, or spending time in nature. A balanced partner prioritizes their own well-being too"
            },
            {
                "Practice Solo activities: Take yourself out ot dinner, visit a museum, or attend a workshop alone, Building independence starts with being comfortable in your own company",
                    "Declutter Your Social Circle: Focus on spending time with people who bring you peace and positivity. Minimize interactions with those who create unnecessary drama or stress",
                    "Simplify Your Daily Routine: Remove unnecessary commitments or habits that drain your energy. This helps you prioritize what truly matters",
                    "Learn Practical Life Skill: Take up a skill that enhances your independence, like cooking , budgeting, or basic car maintenance. Independence comes from competence",
                    "Limit Social Media Engagement: Spend less time online comparing yourself to others. Use that time to pursue hobbies or interests that fulfill you"
            },
            {
                "Spend Time Alone Regularly: Dedicate time each day for solitude. For example, go for a quiet walk, meditate,or journal about your thoughts and emotions",
                    "Practice Selective Sharing: In conversations, choose carefully what you want to share. Practice saying I'd rather not talk about that 'If a topic feels too personal'",
                    "Pursue a Quiet Passion: Engage in a hobby that is calming and fulfilling, such as painting, reading, gardening, or writing. This nurtures your inner world",
                    "Avoid Overcommitting Socially: Say 'no' to Social events that feel too demanding or overwhelming. Prioritize quality interactions over quantity",
                    "Create Personal Boundaries: Clearly define your boundaries and enforce them with others. For example let people know when you need time for yourself without feeling guilty"

            }
    };
    public WomanLoveLenguageTips(User user){
        this.user = user;
    }
    private void getLoveLenguageAndAffection(){
        MakeCouplesService couple_srvice = new MakeCouplesService(this.user);
        this.love_lenguage_states = couple_srvice.getWomanLoveLenguageAndAffection();
    }

    @Override
    public String[] getTips() {
        if(this.love_lenguage_states == null){
            getLoveLenguageAndAffection();
        }
        switch (this.love_lenguage_states){
            case love_lenguage_states_woman.warm_affection_partner:
                return tips_life_and_ambitions[0];
            case  love_lenguage_states_woman.balanced_supportive_partner:
                return tips_life_and_ambitions[1];
            case love_lenguage_states_woman.low_key_independent_partner:
                return tips_life_and_ambitions[2];
            default:
                return  tips_life_and_ambitions[3];
        }
    }
}

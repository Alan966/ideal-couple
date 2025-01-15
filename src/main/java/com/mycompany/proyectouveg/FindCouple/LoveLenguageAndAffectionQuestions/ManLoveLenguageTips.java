package com.mycompany.proyectouveg.FindCouple.LoveLenguageAndAffectionQuestions;

import com.mycompany.proyectouveg.FindCouple.TipsToGetCouple;
import com.mycompany.proyectouveg.Users.User;

public class ManLoveLenguageTips implements TipsToGetCouple {
    private final User user;
    private love_lenguage_states_man love_lenguage_states;
    private final String[][] tips_love_and_lenguage = {
            {
                    "Practice Active Listening Daily: Dedicate time to truly listening to people, focusing on their words without interrupting or planning your response. Repeat back or summarize what you hear to show understanding",
                    "Express Appreciation Regularly: Start by writing small notes or messages to people you care about, expressing gratitude for what they bring to your life. This helps you develop emotional openness",
                    "Journal Your Thoughts and Emotions: Spend 10 minutes daily reflecting on your feelings, actions, and how you treated others during the day. This cultivates emotional awareness and mindfulness",
                    "Engage in Acts of Kindness Weekly: Commit to one thoughtful gesture a week (buying a small gift, preparing a meal for someone , or helping a friend). Small acts build thoughtfulness",
                    "Learn About Emotional Intelligence (EQ): Read books like Emotional Intelligence 2.0 by Travis Bradberry or watch videos about empathy and interpersonal relationships. Apply what you learn in your interactions"
            },
            {
                    "Master Conflict Resolution: Learn to manage disagreements calmly by practicing the 'pause and reflect' method before responding in conflicts. Take time to understand the other person's point of view",
                    "Balance work and relationships: Set specific boundaries for work hours to ensure time is reserved for friends, family, or self-care. Strive for harmony in your schedule",
                    "Build Patience Through Meditation: Dedicate 5 minutes a day to mindfulness or meditation to train your mind to stay calm under pressure, which helps in maintaining a balanced demeanor",
                    "Volunteer for a Cause: Supporting others in need through volunteering teaches you to put others first and stregthens your empathy for diverse life challenges",
                    "Ask and Offer Help Thoughtfully: Develop the habit of asking others how you can support them. Start small, like helping with daily tasks or listening to their concerns"
            },
            {
                    "Stick to Commitments: Make it a rule to never cancel plans unless absolutely necessary. Show people that they can rely on your word and presence",
                    "Establish Routines: Develop a predictable daily schedule for work, exercise, and relaxation. Stability in your life builds reliability for others",
                    "Practice Being Present: Minimize distractions (out away your phone) during conversations to demonstrate your ability to focus on what matters in the moment",
                    "Develop Practical Skills: Learn simple life skills, such as home repairs or car maintenance, to offer reliable help in practical situations",
                    "Be consistent in small actions: Show up on time, remember important dates, and check in regularly with loved ones. These small habits build trust"
            },
            {
                    "Define Personal Boundaries: Write down that you're comfortable sharing and where you need personal time. Practice communicating these boundaries politely and firmly",
                    "Pursue a Solo Hobby or Passion: Dedicate time to a skill or activity that enriches you personally, Such as hiking , writing, or learning a new craft. Independence Thrives on self-fulfillment",
                    "Practice Saying 'No' Diplomatically: Learn to decline invitations or requests without feeling guilty. For example: I really appreciate the invite, but I need some time for myself",
                    "Limit Social Media and Online Presence: Reduce this time spent sharing personal updates online. This encourages you to value privacy and reduces unnecessary social pressures",
                    "Create a Solitude Ritual: Dedicate 15 - 30 minutes each day to being alone with your thoughts (walking in nature, meditating, or reading). This strengthens self-reliance"
            }
    };

    public ManLoveLenguageTips(User _user) {
        this.user = _user;
    }

    private void getLoveLenguageAndAffectionState() {
        MakeCouplesService couple_service = new MakeCouplesService(this.user);
        this.love_lenguage_states = couple_service.getManLoveLenguageAndAffection();
    }

    @Override
    public String[] getTips() {
        if (this.love_lenguage_states == null) {
            getLoveLenguageAndAffectionState();
        }

        final love_lenguage_states_man love_lenguage_state = (love_lenguage_states_man) this.love_lenguage_states;
        return switch (love_lenguage_state) {
            case thoughtful_emotionally_engaged -> tips_love_and_lenguage[0];
            case supportive_balanced_partner -> tips_love_and_lenguage[1];
            case low_key_reliable_partner -> tips_love_and_lenguage[2];
            default -> tips_love_and_lenguage[3];
        };
    }
}

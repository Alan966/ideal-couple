package com.mycompany.proyectouveg.FindCouple.LifeAndSocialPreferencesQuestions;

import com.mycompany.proyectouveg.FindCouple.TipsToGetCouple;
import com.mycompany.proyectouveg.Users.User;

public class WomanLifeAndSocialTips implements TipsToGetCouple {
    private final User user;
    private life_and_social_preferences_states_woman life_and_social_preferences;
    private static final String[][] tips_life_social_preference_woman = {
            {
                    "Join Social Clubs or Groups: Participate in clubs or events like book clubs, fitness classes, or professional networks to expand your circle",
                    "Host Gatherings Regularly: Organize small get-togethers, such as coffee chats, game nights, or brunches, to nature connections",
                    "Be Present in Conversations: Practice active listening and ask follow up questions to deepen your engagement in discussions",
                    "Volunteer for Social Causes: Get involved in community projects or charity events whee you can meet people with shared values",
                    "Plan Regular Social activities: Create a monthly calendar with activities like dinners, networking, events, or trips to stay socially active"
            },
            {
                    "Alternate Social and Private Time: Plan for social outings followed by alone time to balance your energy stay refreshed",
                    "Learn to Read Social Cues: Observe other's behavior to adapt your energy level to suit different social environments",
                    "Say 'Yes' to variety: Accept invitations to different types of events, from lively parties to quiet dinners, to expand your social adaptability",
                    "Develop a Relaxing Wind-Down Routine: After socializing, spend time journaling, meditating, or watching a favorite show to recharge",
                    "Stay Open to Spontaneity: Allow room in your schedule for unplanned activities to practice adaptability without overextending"
            },
            {
                    "Enhance Your Home Space: Decorate or organize your home to make it welcoming, calming environment for yourself and loved ones",
                    "Cook or Host regularly: Plan family dinners or invite friends over simple meals to foster a sense of togetherness",
                    "Practice Daily Acts of Care: Develop routines like writing thoughtful notes, helping with chores, or planning small surprises for close ones",
                    "Learn Basic DIY or Homemaking Skills: Enhance your ability to create a comfortable and functional home through skills like gardening, sewing, or crafting",
                    "Uphold Traditions: Start or maintain family traditions like Sunday brunch or movie nights to strengthen bonds"
            },
            {
                    "Schedule Solo Activities: Dedicate time weekly to hobbies like reading, painting, or yoga to recharge in your own company",
                    "Set Healthy Boundaries: Learn to politely say 'no' to commitments that overextend your energy r time",
                    "Create a 'Me-Time' Space: Designate a part of your home for personal reflection, relaxation or creativity",
                    "Practice Self-Care Regularly: Engage in activities like journaling, skincare routines , or solo outings to maintain emotional balance",
                    "Be transparent About Needs: Communicate your preference for personal space with friends and loved ones to avoid misunderstandings"
            }
    };

    public WomanLifeAndSocialTips(User _user) {
        this.user = _user;
    }

    private void getSocialPreferenceState() {
        MakeCouplesServices couple_service = new MakeCouplesServices(this.user);
        this.life_and_social_preferences = couple_service.getWomanLifeAndSocialPreferencesCouple();
    }

    @Override
    public String[] getTips() {
        if (this.life_and_social_preferences == null) {
            getSocialPreferenceState();
        }
        final life_and_social_preferences_states_woman life_and_social_state = (life_and_social_preferences_states_woman) this.life_and_social_preferences;
        return switch (life_and_social_state) {
            case socially_engaged_partner -> tips_life_social_preference_woman[0];
            case socially_flexible_partner -> tips_life_social_preference_woman[1];
            case home_oriented_partner -> tips_life_social_preference_woman[2];
            default -> tips_life_social_preference_woman[3];
        };
    }
}

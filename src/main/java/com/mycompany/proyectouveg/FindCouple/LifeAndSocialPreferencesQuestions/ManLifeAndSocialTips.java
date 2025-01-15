package com.mycompany.proyectouveg.FindCouple.LifeAndSocialPreferencesQuestions;

import com.mycompany.proyectouveg.FindCouple.TipsToGetCouple;
import com.mycompany.proyectouveg.Users.User;

public class ManLifeAndSocialTips implements TipsToGetCouple {
    private final User user;
    private life_and_social_preferences_states_man life_and_social_preferences_states;
    private static final String[][] tips_life_social_preference_mens = {
            {
                    "Organize Gatherings Regularly: Start hosting small events like dinners, outings, or game nights to build your social circle and leadership in social settings",
                    "Practice Public Speaking: Join groups like Toastmasters to improve confidence in speaking and leading discussions",
                    "Engage in Networking: Attend events or conferences in your field of interest to refine your ability to connect meaningfully",
                    "Be a connector: Introduce people in your circle who might benefit from knowing each other; this establishes you as a social hub",
                    "Set Social Goals: Plan to meet specific number of new people weekly and actively follow up to nurture connections"
            },
            {
                    "Expand Your comfort Zone: Make a effort to attend both lively and quiet gatherings, observing what suits different social contexts",
                    "Master Active Listening: In every interaction, aim to listen more than you speak to understand people's preferences and adapt your energy accordingly",
                    "Learn Basic Talk Skills: Practice open-ended questions to to build rapport in any environment",
                    "Be Open to Spontaneity: Say 'yes' to last-minute invites to practice adaptability without overcommitting",
                    "Develop Empathy: Spend time observing how others behave in social settings and tailor your responses to make them feel at ease"
            },
            {
                    "Prioritize Family Time: Dedicate at least one day a week to family activities like dinners, outings, or phone calls with loved ones",
                    "Learn Basic Caregiving:: Offer help with household tasks, babysitting, or cooking, these skills demonstrate family-oriented behavior",
                    "Build Emotional Availability: Practice sharing your feelings and supporting others emotionally within your family or close circle",
                    "Establish Traditions: Create or uphold family rituals like Sunday brunches or holiday gatherings",
                    "Volunteer for Family Needs: Be proactive in helping relatives, whether fixing something for them or offering a listening ear"
            },
            {
                    "Create a quiet morning routine: Start your day with activities like journaling, yoga or reading to cultivate calmness",
                    "Limit Digital Distractions: Schedule daily 'disconnect' time to focus on hobbies or personal reflection without interruptions",
                    "Practice Saying No: Politely decline social events that don't align with your need for downtime, asserting your personal boundaries ",
                    "Deepen a Solo Habby: Dedicate time to activities like writing, painting, or hiking  enhancing your contentment in solitude",
                    "Simplify Your social circle: Maintain a few meaningful relationships rather than spreading your energy thin across many acquaintances"
            }
    };

    public ManLifeAndSocialTips(User _user) {
        this.user = _user;
    }

    private void getSocialPreferenceState() {
        final MakeCouplesServices couple_service = new MakeCouplesServices(this.user);
        this.life_and_social_preferences_states = couple_service.getManLifeAnSocialPreferencesCouple();
    }


    @Override
    public String[] getTips() {
        if (this.life_and_social_preferences_states == null) {
            getSocialPreferenceState();
        }
        final life_and_social_preferences_states_man life_ans_social_state = (life_and_social_preferences_states_man) this.life_and_social_preferences_states;
        return switch (life_ans_social_state) {
            case socially_driver_partner -> tips_life_social_preference_mens[0];
            case socially_flexible_partner -> tips_life_social_preference_mens[1];
            case family_oriented_partner -> tips_life_social_preference_mens[2];
            default -> tips_life_social_preference_mens[3];
        };
    }
}

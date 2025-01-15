package com.mycompany.proyectouveg.FindCouple.LifeGoalsAndAmbitionsQuestions;

import com.mycompany.proyectouveg.FindCouple.TipsToGetCouple;
import com.mycompany.proyectouveg.Users.User;

public class WomanLifeAndGoalsTips implements TipsToGetCouple {
    private final User user;
    private life_and_ambitions_states_woman life_and_ambitions_states;
    private final String [] [] tips_life_and_ambitions = {
            {
                "Set daily Career Goals: Allocate 30 minutes each morning to outline the day's top three tasks that directly advance your career goals",
                    "Expand your network: Attend one networking event or industry meetup weekly to build relationships with like-minded professionals",
                    "Pursue Continued Education: Dedicate time to taking advanced courses, certifications, or workshops in your field to stay ahead",
                    "Develop Time blocking Habits: Use tools like Google Calendar to segment your day into productive work hours, self-care, and skill-building",
                    "Learn to advocate for yourself: Practice negotiating (salary, promotions, or responsibilities) by role-playing with mentor or trusted friend"
            },
            {
                "Join Collaborative Activities: Participate in group activities like team sports, book club or volunteer projects to practice teamwork skills",
                    "Focus on Active Listening: In every conversation, summarize the other person's points before sharing your opinion to ensure mutual understanding",
                    "Volunteer in leadership Roles: Take up team leadership in small projects or local community events to build your ability to lead while supporting others",
                    "Engage in Feedback Loops: Seek feedback regularly from friends, coworkers, or mentors, and use it to refine your interpersonal and teamwork skills",
                    "Practice Conflict Resolution: Learn to handle disagreements constructively by reading books like Crucial Conversations or taking conflict management workshops"
            },
            {
                "Learn Practical Home Skills: Spend weekends improving at least one home-oriented skill, like cooking, budgeting, or organizing family schedules ",
                    "Strengthen Family Bonds: Dedicate at least one day a week to meaningful family activities (game nights,outings, or shared meals)",
                    "Develop Emotional Intelligence: Practice empathy by listening intently to loved ones and reflecting on their emotions without judgment",
                    "Create a supportive environment: Organize your living space to make it welcoming and conducive to family connection",
                    "Study Family Dynamics: Read Books or attend workshops on healthy family communication, parenting, and building strong emotional connections"
            },
            {
                "Master Homemaking skills: Dedicate an hour a day to improving skills like cooking, cleaning, and home decoration to create a warm and functional home",
                    "Practice Financial Responsibility: Lean basic budgeting techniques to manage household, finance effectively, even it it's just practice for now",
                    "Focus on Wellness: Explore family-friendly meal planning and fitness routines to ensure you and your future family are healthy",
                    "Cultivate Patience: Dedicate 15 minutes daily to mindfulness or journaling to develop a clam and patient mindset for dealing with family challenges",
                    "Learn Traditional Values: Spend time talking to older relatives or role models who embody traditional family roles to understand their perspectives and wisdom"
            }
    };

    public WomanLifeAndGoalsTips(User _user){
        this.user = _user;
    }
    private void getLifeAndAmbitionsPreferenceState(){
        MakeCouplesService couple_service = new MakeCouplesService(this.user);
        this.life_and_ambitions_states = couple_service.getWomenLifeAndAmbitionCouple();
    }

    @Override
    public String[] getTips() {
        if (this.life_and_ambitions_states == null){
            getLifeAndAmbitionsPreferenceState();
        }
        final life_and_ambitions_states_woman life_and_ambitions = (life_and_ambitions_states_woman) this.life_and_ambitions_states;
        return switch (life_and_ambitions) {
            case highly_ambitious_career -> tips_life_and_ambitions[0];
            case team_oriented_woman -> tips_life_and_ambitions[1];
            case family_focused_supportive -> tips_life_and_ambitions[2];
            default -> tips_life_and_ambitions[3];
        };
    }
}

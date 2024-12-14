package com.mycompany.proyectouveg.FindCouple.LifeGoalsAndAmbitionsQuestions;

import com.mycompany.proyectouveg.FindCouple.TipsToGetCouple;
import com.mycompany.proyectouveg.Users.User;

public class ManLifeGoalsAndAmbitionsTips implements TipsToGetCouple {
    private User user;
    private  life_and_ambitions_states_man life_and_ambitions_states;
    private String [][] tips_life_and_ambitions = {
            {
                "Set Clear Long-term Goals: Dedicate 30 minutes daily to defining your professional and personal goals, breaking them into achievable steps with deadlines",
                 "Develop a Work Ethic Routine: Wake up at 5:30 am every day to work on your priorities  - whether career, fitness, or personal growth",
                 "Network strategically: Attend industry events and social mixers weekly to connect with ambitious individuals. Join Linkedln groups or professional clubs",
                    "Invest in Personal Development: Take online courses, attend seminars , or read one self-improvement book every month",
                    "Practice resilience : Commit to 10 minutes of mindfulness meditation daily to handle stress and staty focused on your goals"
            },
            {
                "Join a Team activity: Participate in weekly sports or group projects (joining a soccer team or collaborative workshops) to build teamwork skills",
                    "Improve communication: Practice active listening by summarizing others's  points before responding in conversations especially during team discussions",
                    "Schedule Balanced Routines: Spend equal time on career goals and personal relationships. Use a planner to allocate specific hours for work and social time",
                    "Volunteer: Dedicate one weekend a month to volunteering at charity or community event, focusing on collaboration and giving back",
                    "Learn Conflict Resolution: Read books on effective negotiation and conflict managment and apply the techniques in real-world situations"
            },
            {
                "Learn Basic Domestic Skills: Dedicate wekends to improving skills like cooking, cleaning , and childcare by helping family members or taking online courses",
                    "Strengthen Bonds: Spend time weekly with close family: Organizing dinners or simply catching up - to reinforce family values",
                    "Set financial Goals: Start budgeting your income to prioritize savings for future family plans ",
                    "Improve Patience and Understanding: Practice spending time with kids or older family members to develop nurturing qualities",
                    "Find a family oriented role model: Seek guidance or mentorship from men in your community who embody strong family values"
            },
            {
                "Develop Financial Literacy: Enroll in a online finance course(budgeting, investments) and allocate time weekly to manage your money efficiently",
                    "Focus on Health: Commit to fitness regimen, 4 workout sessions per week, to build physical endurance and log-term vitality for providing support",
                    "Master Decision_Making: Practice evaluating decisions (big or small) by writing down pros and const daily improving your ability to lead",
                    "Cultivate Calm Leadership: Dedicate 15 minutes daily to journaling or reflecting on challenges, identify ways to lead with composure and fairness",
                    "Learn skills for independence: Focus on improving essential skills like home maintenance, car repairs, or emergency preparedness to embody self-reliance"
            }
};
    public  ManLifeGoalsAndAmbitionsTips(User user){
        this.user = user;
    }
    private void getLifeAndAmbitionsPreferenceState(){
        MakeCouplesService couple_service = new MakeCouplesService(this.user);
        this.life_and_ambitions_states = couple_service.getMenLifeAndAmbitionsCouple();
    }

    @Override
    public String[] getTips() {
        if(this.life_and_ambitions_states == null){
            getLifeAndAmbitionsPreferenceState();
        }

        switch (this.life_and_ambitions_states){
            case  life_and_ambitions_states_man.highly_ambitious_supportive_partner:
                return tips_life_and_ambitions[0];
            case life_and_ambitions_states_man.balanced_team_oriented_partner:
                return tips_life_and_ambitions[1];
            case life_and_ambitions_states_man.more_traditional_family_focused:
                return tips_life_and_ambitions[2];
            default:
                return tips_life_and_ambitions[3];
        }
    }

}
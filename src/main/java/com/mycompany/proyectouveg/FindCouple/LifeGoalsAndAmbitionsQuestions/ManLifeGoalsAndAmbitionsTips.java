package com.mycompany.proyectouveg.FindCouple.LifeGoalsAndAmbitionsQuestions;

import com.mycompany.proyectouveg.FindCouple.TipsToGetCouple;
import com.mycompany.proyectouveg.Users.User;

public class ManLifeGoalsAndAmbitionsTips implements TipsToGetCouple {
    private User user;
    private  life_and_ambitions_states_man life_and_ambitions_states;
    private String [][] tips_life_and_ambitions = {
            {
                "Set Clear Career Goals: Define a long-term vision for your career and beak it into actionable short-term objectives: For example: commit to completing one professional certification or advancing your skills in a specific area within 6 months",
                    "Schedule Quality Time: Create a habit of scheduling intentional time wit your partner (or future partner), even during busy weeks. Use tools like Google Calendar to balance work with quality time",
                    "Learn Active Listening: Practice listening without interrupting or offering solutions. Start with one conversation daily where you focus entirely on understanding the other person's perspective",
                    "Develop Financial Discipline: Learn budgeting and start investing. Tools like Mint or personal finace books (Rich Dad Poor Dad) can help you become financially dependable",
                "Stay Curious About Your Partner's Career: Learn about her field. Ask questions, celebrate her milestones, and think about how you can practically support her goals"
            },
            {
                "Develop a habit of collaboration: Engage in team-based activities like sports, volunteering, or group projects to hone you your teamwork skills, Focus on problem solving others rather rather than taking sole control ",
                    "Practice Emotional Transparency: Share your thoughts and feelings openly with trusted friends or family members to get comfortable with emotional vulnerability. Try journaling daily to articulate your emotions",
                    "Strengthen Communication Skills: Practice summarizing what someone says before responding. For example: So you're saying you think we should , ensures clarity and builds trust",
                    "create shared plans: Get into the habit of making collaborative plans, whether it's planning a trip with friends or managing a group project. This build the mindset of working toward mutual goals",
                    "Read about team Dynamics: Books Like The Five Dysfunctions of a Team by Patrick Lencioni or Crucial Conversations can help you understand and improve your collaboration abilities"
            },
            {
                "Connect wit family regularly: Strengthen your bond with family members by calling or visiting them regularly. Start with one meaningful conversation per week",
                    "Learn Domestic Skills: Practice cooking, cleaning and managing a household, Choose a simple meal to master and cook it weekly. This will prepare you contribute meaningfully at home",
                    "Be Reliable: Show up consistently for commitments, whether it's for friends, family, or work. Develop a reputation for being dependable and supportive ",
                    "Volunteer with community or Family-Centered Activities: Participe in activities like mentoring kids, coaching sports, or family-focused charity work. This helps you cultivate a nurturing mindset",
                    "Plan for the future: Think about where you want to live, the kind of family dynamic you envision, and start saving for it . Open a savings acocunt or create vision board for your future home life"
            },
            {
                "Build financial independence: Focus on saving 20% of your income and investing in assets. Learn about budgeting and financial planning through apps like YNAB or courses on Coursera",
                    "Cultivate Strong Decision-Making Skills: Start making firm, small, decisions daily and stick to them, For example, decide on a plan for your day the night before and execute it fully",
                    "Work on leadership: Take on leadership roles at work or in community projects. Build confidence in managing responsibilities and guiding others",
                    "Develop a clear vision of stability: Write down what 'security' means to you (financially, emotionally, physically) and work toward it systematically. Start with building an emergency fund (3 - 6 months of expenses)",
                    "Be consistent and reliable: Create daily routines that demonstrate reliability, wake up at the same time, exercising, and meeting deadlines. This builds the trustworthiness associated with being a provider"
            }
};
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
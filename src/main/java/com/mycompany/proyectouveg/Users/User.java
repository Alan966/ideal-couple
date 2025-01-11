package com.mycompany.proyectouveg.Users;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.mycompany.proyectouveg.FindCouple.EmotionalCouplesQuestions.emotional_states;
import com.mycompany.proyectouveg.FindCouple.LifeGoalsAndAmbitionsQuestions.life_and_ambitions_states;
import com.mycompany.proyectouveg.FindCouple.LoveLenguageAndAffectionQuestions.love_lenguage_states;
import com.mycompany.proyectouveg.FindCouple.LifeAndSocialPreferencesQuestions.life_and_social_preferences_states;

public class User implements IUser {
    private int id_user;
    private String first_name;
    private String last_name;
    private Gender gender;
    private String email;
    private String password;
    private emotional_states emotional_parnet;
    private life_and_ambitions_states life_and_ambition_partner;
    private love_lenguage_states love_lenguage_partner;
    private life_and_social_preferences_states life_and_social_preferences_couple;
    double id_counter = 0.00000001;
    Calendar birhtday;
    private boolean is_premium = false;
    private int amount_count = 0;

    public User(String first_name, String last_name, Gender gender, String email, String password, String year_mo_da) {
        id_counter++;
        this.id_user = (int) Math.ceil((id_counter * 100000000));
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.email = email;
        this.password = password;
        int year = Integer.parseInt(year_mo_da.split("/")[0]);
        int month = Integer.parseInt(year_mo_da.split("/")[1]) - 1;
        int day = Integer.parseInt(year_mo_da.split("/")[2]);
        this.birhtday = new GregorianCalendar(year, month, day);
    }

    @Override
    public void setEmotionalPartner(emotional_states emotional_parnet) {
        this.emotional_parnet = emotional_parnet;
    }

    ;

    @Override
    public void setLifeAndAmbitionPartner(life_and_ambitions_states life_am) {
        this.life_and_ambition_partner = life_am;
    }

    @Override
    public void setLenguageAndAffectionPartner(love_lenguage_states love_lenguage_and_affection_partner) {
    }


    public void setBirthday(String birthday) {
        int year = Integer.parseInt(birthday.split("/")[0]);
        int month = Integer.parseInt(birthday.split("/")[1]);
        int day = Integer.parseInt(birthday.split("/")[2]);
        this.birhtday = new GregorianCalendar(year, month, day);
    }

    ;

    public void setFistName(String first_name) {
        this.first_name = first_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setLoveLenguagePartner(love_lenguage_states loveL_lenguage_partner) {
        this.love_lenguage_partner = loveL_lenguage_partner;
    }

    public void setLifeAndSocialPreferences(life_and_social_preferences_states life_and_social_preferences_couple) {
        this.life_and_social_preferences_couple = life_and_social_preferences_couple;
    }

    public love_lenguage_states getLoveLenguagePartner() {
        return this.love_lenguage_partner;
    }

    public emotional_states getEmotionalPartner() {
        return this.emotional_parnet;
    }

    public life_and_ambitions_states getLifeAndAmbitions() {
        return this.life_and_ambition_partner;
    }

    public life_and_social_preferences_states getLifeAndSocialPreferencesCouple() {
        return this.life_and_social_preferences_couple;
    }

    @Override
    public int getUserId() {
        return this.id_user;
    }

    public String getFullName() {
        return this.first_name + " " + this.last_name;
    }

    public String getFirstName() {
        return this.first_name;
    }

    public String getLastName() {
        return this.last_name;
    }

    public Gender getGender() {
        return this.gender;
    }

    public String getEmail() {
        return this.email;
    }


    public Date getBirthday() {
        return this.birhtday.getTime();
    }


    public void insetAmount(int amount) {
        //TODO: Implement process to Premium Users
        this.amount_count += amount;
        if (this.amount_count > 100) {
            this.is_premium = true;
        }
    }

    public boolean isPremium() {
        return is_premium;
    }

    public void maybeProcessPremium(Scanner sc) {
        if (this.is_premium == false) {
            System.out.println("You're not Premium So sorry");
        }
        startProcessPremium(sc);
    };

    private void startProcessPremium(Scanner sc) {
        String[] premium_questions = getPremiumQuestions();
        int count = 0;
        String [][] answers = getPremiumAnswers();
        String[] responses = new  String[10];
        do {
            System.out.println(premium_questions[count]);
            printAnswers(answers[count]);
            String response = sc.nextLine();
            responses[count] = response;
            count++;
        } while (count != premium_questions.length);
        System.out.println("Your answers was");
        for (String response : responses){
            System.out.println(response);
        }
    }

    private String[] getPremiumQuestions() {
        if (this.gender == Gender.Masculino) {
            return QuestionsPremiumMen();
        }
        return QuestionsPremiumWoman();
    }
    private String[][] getPremiumAnswers() {
        if(this.gender == Gender.Masculino){
            return getAnswersQuestionsManPremium();
        }
        return getAnswersQuestionsWomanPremium();
    };

    private String[] QuestionsPremiumMen() {
        String[] premium_questions = {
                "When faced with a challenge, How do you typically react ?",
                "How do you feel about making major decisions on your own?",
                "How do you respond when someone challenges your opinion or ideas?",
                "When things go wrong in your life, What's your first reaction?",
                "How do you handle your finances?",
                "When faced with difficult emotional situation, what do you do?",
                "How do you view personal fitness and health ?",
                "How do you manage your time during the day? ",
                "When someone asks you for help, how do you approach it?",
                "How do you feel about taking on responsibility in a group or organization?"
        };
        return premium_questions;
    }

    private String[] QuestionsPremiumWoman() {
        String[] premium_questions = {
                "How do you typically react when you face stress?",
                "How do you prioritize your physical health?",
                "When faced with a difficult decision, how do you approach it?",
                "How do you deal with negative emotions like sadness or anger?",
                "How do you feel about self-care and personal time?",
                "How do you approach your relationships with family and friends?",
                "When it comes to your goals how do you approach them?",
                "How do you respond when things don't go as planned ?",
                "How do you feel about your own body image?",
                "How do you balance your career and personal life?",
        };
        return premium_questions;
    }
    ;
    private String[][] getAnswersQuestionsManPremium(){
        String [][] premium_answers = {
                {
                    "a) I avoid it until I can no longer escape",
                        "b) I try to deal with it, but I can be overwhelmed",
                        "c) I take the time to think through possible solutions",
                        "d) I face it head-on and deal with whatever comes my way"
                },
                {
                    "a) I prefer to ask for advice and seek consensus",
                        "b) I make the decision, but I'm always unsure",
                        "c) I weigh the pros and cons, then take responsibility for my choice",
                        "c) I trus my gut and maje the decisions swiftly, regardless or what others think"
                },
                {
                    "a) I get defensive and argue my point harder",
                        "b) I explain myself calmly, but i get frustrated",
                        "c) I listen to the other person's argument and consider it",
                        "d) I remain calm and either agree, disagree, or walk away if it's not worth the energy"
                },
                {
                    "a) I blame others and external circumstances",
                        "b) I feel sorry for myself for a while",
                        "c) I analyze what went wrong and adjust accordingly",
                        "d) I don't waste time complaining, I take immediate action to fix it"
                },
                {
                    "a) I avoid thinking about it and let things happen on their own",
                        "b) I try to save but often spend impulsively",
                        "c) I budget and save with some room for flexibility",
                        "d) I have clear financial goals and stick to a strict plan"
                },
                {
                    "a) I ignore it and hope it goes away",
                        "b) I talk to friends or family to get advice",
                        "c) I deal with it privately, but I try to stay strong",
                        "d) I face the situation directly and process the emotions without hesitation"
                },
                {
                    "a) I don't have time for fitness, it's not important to me",
                        "b) I try to work out sometimes, but it's not a priority",
                        "c) I maintain a regular workout routine but can slack off occasionally",
                        "d) I have disciplined fitness routine and prioritize my health"
                },
                {
                    "a) I react to whatever comes my way, and time is often wasted",
                        "b) I try to organize myself but often get sidetracked",
                        "c) I have to-do list, but sometimes I don't follow through",
                        "d) I have a structured daily routine and make sure I stick to it"
                },
                {
                    "a) I avoid helping, as I don't like getting involved in others' problems",
                        "b) I help, but I get frustrated or expect something in return",
                        "c) I offer help if i can, but I expect the person to figure out most of it on their own",
                        "d) I offer my help wilingly and expect nothing in return"
                },
                {
                    "a) I avoid it; I prefer to stay out of the spotlight",
                        "b) I take on some responsibilities but often find them overwhelming",
                        "c) I take on responsibilities and complete them, even under pressure",
                        "d) I actively seek out responsibility and thrive when leading others"
                }
        };
        return premium_answers;
    };
    private String[][] getAnswersQuestionsWomanPremium(){
        String [][] premium_answers = {
                {
                    "a) I avoid dealing with it and try to distract myself",
                        "b) I acknowledge it , but i tend to bottle it up and feel overwhelmed",
                        "c) I take time to process my feelings and take some small actions to manage it",
                        "d) I handle it, calmly, analyze the situation,a nd focus on solutions"
                },
                {
                    "a) I don't pay much attention to my health and make unhealthy choices",
                        "b) I try to be healthy but struggle to keep consistent",
                        "c) I exercise occasionally and eat somewhat balanced meals",
                        "d) I maintain regular exercise routine and prioritize my health with balanced meals",
                },
                {
                    "a) I avoid making decisions and let others choose for me",
                        "b) I feel overwhelmed and struggle to make the right decision",
                        "c) I seek advice from others and weigh the options",
                        "d) I trust my intuition, research the options, and make a decision confidenly"
                },
                {
                    "a) I repress them and try to ignore how I feel",
                        "b) I express them impulsively and sometimes regret it",
                        "c) I reflect on my feelings and try to understand where they come from",
                        "d) I process them calmly and take constructive action to move forward"
                },
                {
                    "a) I rarely make time for myself and feel guilty when I do",
                        "b) I occasionally take time for self-care but feel like I'm neglecting responsibilities",
                        "c) I try to prioritize self-care, but it often feels like a luxury",
                        "d) I regularly schedule time for self-care and understand it's importance for my well-being"
                },
                {
                    "a) I avoid conflict and sometimes let my boundaries be crossed",
                        "b) I sometimes struggle to set boundaries and speak up for myself",
                        "c) I maintain healthy relationships, but I can be easily overwhelmed by them",
                        "d) I establish and maintain healthy boundaries, while nurturing strong, supportive relationships"
                },
                {
                    "a) I lack clear goals and often feel lost or uncertain about what I want",
                        "b) I have some goals but often procrastinate and feel overwhelmed",
                        "c) I set goals and try to stay focused, though I sometimes get distracted",
                        "d) I have clear, actionable goals and consistently work towards them with discipline"
                },
                {
                    "a) I become discouraged and give up easily",
                        "b) I feel frustrated, but I try to move on without much reflection",
                        "c) I analyze the situation, adjust my approach, and try again",
                        "d) I stay calm, reassess my strategy, and move forward with determination"
                },
                {
                    "a) I feel uncomfortable and dissatisfied with my body most of the time",
                        "b) I have moments of self-doubt but try to focus on the positives",
                        "c) I accept my body, but I still strive for improvements",
                        "d) I feel confident and comfortable in my body and take care of it"
                },
                {
                    "a) I'm completely absorbed in my work and struggle to maintain personal relationships",
                        "b) I try to balance both, but I often feel overwhelmed and out of sync",
                        "c) I manage both reasonably well but sometimes feel like something gives",
                        "d) I maintain a strong balance between my career and personal life, ensure both thrive"
                }
        };
        return premium_answers;
    };
    private void printAnswers(String[] answers){
        int length = answers.length - 1;
        do{
            System.out.println(answers[length]);
            length--;

        }while (length >= 0);
    }
};

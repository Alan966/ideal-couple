package com.mycompany.proyectouveg.FindCouple.LoveLenguageAndAffectionQuestions;

import com.mycompany.proyectouveg.FindCouple.Couples;
import com.mycompany.proyectouveg.Users.User;
import java.util.Scanner;

public  class WomanLoveLenguageQuestions extends Couples {
    private int points = 0;
    private Scanner scanner;
    public love_lenguage_states_man love_lenguage_partner;
    public WomanLoveLenguageQuestions(Scanner sn, User user){
        super(user);
        this.scanner = sn;
    }
    @Override
    public void start() {
        boolean user_could_play =  couldPlay();
        if(!user_could_play){
            System.out.println("Finish the game");
            return;
        };
        executeQuestions();
        if(this.points <= 5){
            love_lenguage_partner = love_lenguage_states_man.independent_reserved_partner;
        }else if (this.points <= 10){
            love_lenguage_partner = love_lenguage_states_man.low_key_reliable_partner;
        }else if(this.points <= 15){
            love_lenguage_partner = love_lenguage_states_man.supportive_balanced_partner;
        }else {
            love_lenguage_partner = love_lenguage_states_man.thoughtful_emotionally_engaged;
        }
        this.user.setLoveLenguagePartner(love_lenguage_partner);
    }
    @Override
    protected void FirstQuestion() {
        System.out.println("When you're feeling down, what kind of support would make you feel the most loved ?");
        System.out.println("a) A warm hug and having my partner close to me");
        System.out.println("b) Words of encouragement and reassurance from my partner");
        System.out.println("c) Helping me with small tasks or taking care of something I' struggling with");
        System.out.println("d) Giving me space to process alone but checking in on me later");
        String response = this.scanner.nextLine();
        if(!validateResponse(response)){
            System.out.println("You response is not valid, Tried again");
            FirstQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    protected void SecondQuestion() {
        System.out.println("How would you prefer your partner to express their appreciation for you?");
        System.out.println("a) By planning thoughtful date nights or special time just for us");
        System.out.println("b) By telling me frequently how much I mean to them ");
        System.out.println("c) Through small acts, like helping with errands or giving me a gift now and them");
        System.out.println("d) By respecting my boundaries and showing they trust me");
        String response = this.scanner.nextLine();
        if(!validateResponse(response)){
            System.out.println("You response is not valid, Tried again");
            SecondQuestion();
        }
        this.points += returnPoints(response);}

    @Override
    protected void ThirdQuestion() {
            System.out.println("When it comes to affection, what is most meaningful to you in day-to-day interactions ?");
            System.out.println("a) Frequent small gestures, like hand-holding, cuddling, and physical closeness");
            System.out.println("b) Compliments and verbal affirmations that make me feel valued");
            System.out.println("c) Helping out without being asked showing attentiveness through actions");
            System.out.println("d) Giving me space while still being there for me when I need support");
            String response = this.scanner.nextLine();
            if(!validateResponse(response)){
                System.out.println("You response is not valid, Tried again");
                ThirdQuestion();
            }
            this.points += returnPoints(response);
        }

        @Override
        public void FourthQuestion() {
            System.out.println("If you and your partner have limited time together, how would you most want to spend it ?");
            System.out.println("a) Just enjoying quality time, like a quiet night in or an adventure together");
            System.out.println("b) Talking openly about life, dreams, and building a deep connection");
            System.out.println("c) Focusing on practical things like planning or working on something together");
            System.out.println("d) Respecting each other's space and then reconnecting when we're both free");
            String response = this.scanner.nextLine();

            if(!validateResponse(response)){
                System.out.println("You response is not valid, Tried again");
                FourthQuestion();
            }
            this.points += returnPoints(response);
        }

        @Override
        public void FifthQuestion() {
            System.out.println("How important is it for you that your partner goes out of their way to make you feel special on important dates (anniversaries, birthdays, tsc.) ?");
            System.out.println("a) very important, I love when my partner plans something memorable and thoughtful");
            System.out.println("b) It's meaningful, but even a heartfelt message or note is enough");
            System.out.println("c) Nice, but I prefer small gestures year-round rather than big celebrations");
            System.out.println("d) I don't place much emphasis on these dates, it's about how treat me daily");
            String response = this.scanner.nextLine();
            if(!validateResponse(response)){
                System.out.println("You response is not valid, Tried again");
                FifthQuestion();
            }
            this.points += returnPoints(response);
        }
}
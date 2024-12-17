package com.mycompany.proyectouveg.FindCouple.LoveLenguageAndAffectionQuestions;

import com.mycompany.proyectouveg.FindCouple.Couples;
import com.mycompany.proyectouveg.Users.User;
import java.util.Scanner;

public class ManLoveLenguageQuestions extends Couples {
    private int points = 0;
    private Scanner scanner;
    public love_lenguage_states love_lenguage_partner;
    public ManLoveLenguageQuestions(Scanner sn, User user) {
        super(user);
        this.scanner = sn;
    }
    @Override
    public void start() {
        boolean user_could_play = couldPlay();
        if(!user_could_play){
            System.out.println("Finish the game");
            return;
        };
        executeQuestions();
        if(points <= 5){
            love_lenguage_partner = love_lenguage_states_woman.reserved_independent_partner;
        }else if(points <= 10){
            love_lenguage_partner = love_lenguage_states_woman.low_key_independent_partner;
        }else if(points <= 15){
            love_lenguage_partner = love_lenguage_states_woman.balanced_supportive_partner;
        }else{
            love_lenguage_partner = love_lenguage_states_woman.warm_affection_partner;
        }
        this.user.setLoveLenguagePartner(love_lenguage_partner);
    }

    @Override
    protected void FirstQuestion() {
        System.out.println("How important is physical affection in your relationship?");
        System.out.println("a) It's essential - I need a partner who's comfortable with lots of affection");
        System.out.println("b) I value affection but in more subtle, personal ways");
        System.out.println("c) I'm okay with affection, but it doesn't need to be constant");
        System.out.println("d) I don't place a lot of emphasis on physical affection");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)){
            FirstQuestion();
        };
        this.points += returnPoints(response);
    }

    @Override
    protected void SecondQuestion(){
        System.out.println("How do you feel about verbal affirmations and compliments from your partner ?");
        System.out.println("a) I love frequent affirmations, they make me feel valued and close");
        System.out.println("b) I appreciate them when they feel genuine and meaningful");
        System.out.println("c) They're nice, but I don't need them all the time");
        System.out.println("d) I don't rely much on words of affirmation, I show and feel love in other ways");
        String response = this.scanner.nextLine();
        if(!validateResponse(response)){
            SecondQuestion();
        };
        this.points += returnPoints(response);}
    @Override
    protected void ThirdQuestion (){
        System.out.println("When it comes to spending quality time, what's your preference ?");
        System.out.println("a) I prefer frequent one-on-one time with my partner, engaging in shared interests ");
        System.out.println("b) I like quality time together but also value some independence ");
        System.out.println("c) I enjoy it, but as long we connect regularly, it doesn't need to be constant");
        System.out.println("d) I value having my own time and space and prefer less focused attention");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)){
            ThirdQuestion();
        };
        this.points += returnPoints(response);}

    @Override
    protected void FourthQuestion () {
        System.out.println("How do you feel about gifts as a form of expressing love?");
        System.out.println("a) Gifts are a key part of showing love,I like giving and receiving them often");
        System.out.println("b) I appreciate thoughtful gifts on meaningful occasions");
        System.out.println("c) I'm fine with gifts ut don't need them to feel connected");
        System.out.println("d) I don't place much emphasis on gifts as an expression of love");
        String response = this.scanner.nextLine();
       if (!validateResponse(response)){
           FourthQuestion();
       };
        this.points += returnPoints(response);
    }

    @Override
    protected void FifthQuestion () {
        System.out.println("How important is it that your partner offers practical support (like helping with tasks or planning) ?");
        System.out.println("a) Very important I feel loved when my partner is actively supportive");
        System.out.println("b) I appreciate help but don't expect it all the time");
        System.out.println("c) It's nice occasionally, but I prefer independence in tasks");
        System.out.println("d) I don't expect or need practical support as a show of love");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)){
            FifthQuestion();
        };
        this.points += returnPoints(response);
    }

    @Override
    public String[] getAdvices() {
        ManLoveLenguageTips man_love_lenguage = new ManLoveLenguageTips(this.user);
        return man_love_lenguage.getTips();
    }
}

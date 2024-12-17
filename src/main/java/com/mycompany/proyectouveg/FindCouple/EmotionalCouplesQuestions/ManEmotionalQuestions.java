package com.mycompany.proyectouveg.FindCouple.EmotionalCouplesQuestions;

import com.mycompany.proyectouveg.FindCouple.LoveLenguageAndAffectionQuestions.ManLoveLenguageTips;
import com.mycompany.proyectouveg.Users.User;
import com.mycompany.proyectouveg.FindCouple.*;
import java.util.Scanner;

public final class  ManEmotionalQuestions  extends Couples {
    private int points = 0;
    private emotional_states_woman emotions_partner;
    private Scanner scanner;
    public ManEmotionalQuestions(Scanner scanner, User user) {
        super(user);
        this.scanner = scanner;
    }

    public void start(){
        boolean user_could_play = couldPlay();
        if (!user_could_play) {
            System.out.println("Finish the game");
            return;
        }
        executeQuestions();
        if (points < 8) {
            emotions_partner = emotional_states_woman.emotionally_reserved;
        } else if (points <= 12) {
            emotions_partner = emotional_states_woman.emotionally_independent;
        } else if (points <= 17) {
            emotions_partner = emotional_states_woman.emotionally_balanced;
        } else {
            emotions_partner = emotional_states_woman.emotionally_engaged;
        }
        this.user.setEmotionalPartner(emotions_partner);
    }

    @Override
    protected void FirstQuestion() {
        System.out.println("How important is emotional vulnerability in your partner ?");
        System.out.println("a) I appreciate when she feels comfortable being open and vulnerable with me about her feelings");
        System.out.println("b) I like when she shares her emotions, but I also value her ability to maintain composure during tough times");
        System.out.println("c) I want her to be emotionally strong most of the time, sharing feelings only when necessary ");
        System.out.println("d) I prefer if she remains private about her emotions and deals with them independetly");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)) {
            System.out.println("Your response is not valid Tried again");
            FirstQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    protected void SecondQuestion() {
        System.out.println("When your partner is upset, how would you like her to express it ?");
        System.out.println("a) Share her emotions openly with me, so we can talk through it together");
        System.out.println("b) Express her feelings but do calmly without letting emotions take over");
        System.out.println("c) Keep her feelings mostly to herself and talk about it only if absolutely needed");
        System.out.println("d) Try to handle it on her own, showing that she's strong enough to manage without much support");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)) {
            System.out.println("Your response is invalid,tried again");
            SecondQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    protected void ThirdQuestion() {
        System.out.println("What king of emotional balance do you seek in a partner?");
        System.out.println("a) I want a partner who is emotionally open but also resilient- someone who can be vulnerable and strong at the same time");
        System.out.println("b) A woman who can talk about her feelings when necessary, but who is also capable of handling difficult emotions on her own");
        System.out.println("c) A partner who values stability and prefers to keep her emotional experiences private most of the time");
        System.out.println("d) I prefer someone who doesn't rely too much on emotions, focusing more on practical solutions rather than emotional discussions");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)) {
            System.out.println("Your response is invalid,tried again");
            ThirdQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    protected void FourthQuestion() {
        System.out.println("How should your partner support you emotionally ?");
        System.out.println("a) Be emotionally engaged , offering empathy and understanding when I need it");
        System.out.println("b) Provide emotional support when I need it but remain calm and focused");
        System.out.println("c) Offer minimal emotional support, as I prefer to deal with my won feelings");
        System.out.println("d) Stay detached emotionally  and let me handle my own issues");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)) {
            System.out.println("Your response is invalid,tried again");
            FourthQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    protected void FifthQuestion() {
        System.out.println("How do you feel about emotional conflict in a relationship?");
        System.out.println("a) I prefer a partner who is open about her emotions, even during conflict,so we can work through issues together");
        System.out.println("b) I want her to express her feelings but remain respectful calm , even when things get hated");
        System.out.println("c) I prefer a partner who stays calm and avoids getting too emotional during conflicts ");
        System.out.println("d) I'de like her to remain composed and focus on finding solutions without letting emotions affect the conversation");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)) {
            System.out.println("Your response is invalid,tried again");
            FifthQuestion();
        }
        this.points += returnPoints(response);
    }
    public String[] getAdvices(){
        ManLoveLenguageTips man_love_lenguage = new ManLoveLenguageTips(this.user);
        return man_love_lenguage.getTips();
    }
}
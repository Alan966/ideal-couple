package com.mycompany.proyectouveg.FindCouple.LifeGoalsAndAmbitionsQuestions;

import com.mycompany.proyectouveg.FindCouple.Couples;
import com.mycompany.proyectouveg.Users.User;

import java.util.Scanner;

public class WomanLifeGoalsQuestions extends Couples {
    private int points = 0;
    private life_and_ambitions_states_man life_and_ambition_partner;
    private final Scanner scanner;

    public WomanLifeGoalsQuestions(Scanner _scanner, User _user) {
        super(_user);
        this.scanner = _scanner;
    }

    @Override
    public void start() {
        boolean user_could_play = couldPlay();
        if (!user_could_play) {
            System.out.println("Finish the game");
            return;
        }
        ;
        executeQuestions();
        if (points <= 5) {
            life_and_ambition_partner = life_and_ambitions_states_man.traditional_provider_led_relationship;
        } else if (points <= 10) {
            life_and_ambition_partner = life_and_ambitions_states_man.more_traditional_family_focused;
        } else if (points <= 15) {
            life_and_ambition_partner = life_and_ambitions_states_man.balanced_team_oriented_partner;
        } else {
            life_and_ambition_partner = life_and_ambitions_states_man.highly_ambitious_supportive_partner;
        }
        this.user.setLifeAndAmbitionPartner(life_and_ambition_partner);
    }

    @Override
    protected void FirstQuestion() {
        System.out.println("How do you view your career ambitions in a relationship?");
        System.out.println("a) My career is my top priority, and I expect my partner to support my ambitions fully.");
        System.out.println("b) My career is important, but I am open to compromising when needed for the relationship");
        System.out.println("c) I prefer to balance my career and personal life equally with my partner");
        System.out.println("d) I see myself focusing more on family and supporting my partner's career");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)) {
            FirstQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    protected void SecondQuestion() {
        System.out.println("How do you approach long-term goals with a partner?");
        System.out.println("a) I want us to pursue our individual goals while supporting each other from a distance");
        System.out.println("b) I want us to pursue goals together but maintain some independence");
        System.out.println("c) I prefer us to set mutual goals ad work as a team");
        System.out.println("d) I expect my partner to lead while I support and follow the shared goals");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)) {
            SecondQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    protected void ThirdQuestion() {
        System.out.println("How important is financial independence for you in a relationship?");
        System.out.println("a) I want to maintain complete financial independence from my partner");
        System.out.println("b) I prefer to keep some financial independence but share certain responsabilities");
        System.out.println("c) I believe in sharing all financial responsabilities equally");
        System.out.println("d) I am comfortable relying on my partner for financial support");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)) {
            ThirdQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    protected void FourthQuestion() {
        System.out.println("How do you view family planning in relation to your personal ambitions?");
        System.out.println("a) I prefer to focus on my career for now and think about family planning much later");
        System.out.println("b) I'd like to balance both family and personal goals from the start");
        System.out.println("c) I am open to focusing on family sooner, but I want to keep working on personal ambitions");
        System.out.println("d) I would prioritize family over personal ambitions when the time comes");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)) {
            FourthQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    protected void FifthQuestion() {
        System.out.println("How do you feel about traveling or relocating for career opportunities ?");
        System.out.println("a) I am very open to relocating or traveling often for career growth, even if it means long-distance");
        System.out.println("b) I would consider relocating or traveling for work if my partner is onboard with it");
        System.out.println("c) I prefer stability but would relocate if it's important for us as a couple");
        System.out.println("d) I don't like the idea of relocating and prefer a stable, settled life");
        String response = this.scanner.nextLine();
        if (!validateResponse(response)) {
            FifthQuestion();
        }
        this.points += returnPoints(response);
    }

    @Override
    public String[] getAdvices() {
        final WomanLifeAndGoalsTips woman_life_and_goals = new WomanLifeAndGoalsTips(this.user);
        return woman_life_and_goals.getTips();
    }
}

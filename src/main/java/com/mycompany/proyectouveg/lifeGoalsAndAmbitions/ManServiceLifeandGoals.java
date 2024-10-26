package com.mycompany.proyectouveg.lifeGoalsAndAmbitions;
import com.mycompany.proyectouveg.Students.User;
import com.mycompany.proyectouveg.enums.enumsLifeandAmbitions.*;
import com.mycompany.proyectouveg.interfaces.Services;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ManServiceLifeandGoals implements Services {
    private int points;
    private life_and_ambitions_woman life_and_ambitions_partner;
    private Scanner scanner;
    private User user;
    ManServiceLifeandGoals(Scanner scanner, User user){
        this.scanner = scanner;
        this.user = user;
    }

    @Override
    public void start() {
        boolean user_could_play = StartGame(this.user);
        if(!user_could_play){
            System.out.println("Finish the game");
            return;
        }
        System.out.println("This is the first part for know what do you want");
        FistQuestion(this.scanner);
        SecondQuestion(this.scanner);
        ThirdQuestion(this.scanner);
        FourthQuestion(this.scanner);
        FifthQuestion(this.scanner);
    }

    @Override
    public boolean StartGame(User user) {
        boolean response = false;
        Calendar now = new GregorianCalendar();
        int difference = user.getBirthday().getYear() - now.getTime().getYear();
        if(difference > 18 || difference < -18){
            System.out.println("Hora de Coitorrear!!!");
            response = true;
        }else {
            System.out.println("Cierra la computadora");
        };
        return response;
    }
    public String isValidresponse(String response){
        if(!response.equals("a") && !response.equals("b")&& !response.equals("c") && !response.equals("d")){
            System.out.println("Wrong response");
            return "Not_valid";
        }
        return "valid";
    }
    public void addPoints(String response){
        switch (response) {
            case "a":
                points += 4;
                break;
            case "b":
                points += 3;
                break;
            case "c":
                points += 2;
                break;
            case "d":
                points += 1;
                break;
        }
    }
    @Override
    public void FistQuestion(Scanner sn) {

    }

    @Override
    public void SecondQuestion(Scanner sn) {

    }

    @Override
    public void ThirdQuestion(Scanner sn) {

    }

    @Override
    public void FourthQuestion(Scanner sn) {

    }

    @Override
    public void FifthQuestion(Scanner sn) {

    }
}

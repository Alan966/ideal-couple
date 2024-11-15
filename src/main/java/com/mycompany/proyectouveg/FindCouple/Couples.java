package com.mycompany.proyectouveg.FindCouple;

import com.mycompany.proyectouveg.Users.User;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public abstract class Couples {
    public User user;
    public Couples(User user){
        this.user = user;
    }
    public void executeQuestions(){
        FirstQuestion();
        SecondQuestion();
        ThirdQuestion();
        FourthQuestion();
        FifthQuestion();
    }
    public abstract void start();
    public boolean couldPlay(){
        Calendar now = new GregorianCalendar();
        int difference = this.user.getBirthday().getYear() - now.getTime().getYear();
        if (difference > 18 || difference < -18 ) {
            System.out.println("Hora de Coitorrear!!");
            return true;
        }
        System.out.println("Cierra la computadora");
        return false;
    };
    public boolean validateResponse(String response){
        return  response.equals("a") || response.equals("b") || response.equals("c") || response.equals("d");
    }
    public int returnPoints(String response){
        switch (response) {
            case "a":
                return 4;
            case "b":
                return 3;
            case "c":
                return 2;
            case "d":
                return  1;
            default:
                return 0;
        }
    }
    protected abstract void FirstQuestion();
    protected abstract  void SecondQuestion();
    protected abstract void ThirdQuestion();
    protected abstract  void FourthQuestion();
    protected abstract void FifthQuestion();

}

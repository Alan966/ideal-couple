package com.mycompany.proyectouveg.Services;

import com.mycompany.proyectouveg.Students.User;

import java.util.Scanner;

public class ManServiceEmotions {
    int points;
    emotional_woman emotions_woman;
    public void StartGame(User user){
        if(user.getAge() > 28){
            System.out.println("Hora de Coitorrear!!");
        }else{
            System.out.println("Cierra la computadora");
        }
    }
    public String isValidresponse(String response){
        if(response != "a" || response != "b" || response != "c" || response != "d") {
            System.out.println("Wrong response");
            return "Not_valid";
        }
        return "valid";
    }
    public void addPoints(String response){
        switch (response){
            case "a":
                points+=4;
                break;
            case "b":
                points+=3;
                break;
            case "c":
                points+=2;
                break;
            case "d":
                points+=1;
                break;
        }
    }
    public void FistQuestion(Scanner sn){
        System.out.println();
    };
    public void SecondQuestion(Scanner sn);
    public void ThirdQuestion(Scanner sn);
    public void FourthQuestion(Scanner sn);
    public void FifthQuestion(Scanner sn);
}

package com.mycompany.proyectouveg.FindCouple;

import com.mycompany.proyectouveg.Users.*;

import java.util.Scanner;

public interface Services {
    void start();

    boolean StartGame(User user);

    void FistQuestion(Scanner sn);

    void SecondQuestion(Scanner sn);

    void ThirdQuestion(Scanner sn);

    void FourthQuestion(Scanner sn);

    void FifthQuestion(Scanner sn);

}

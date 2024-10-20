package com.mycompany.proyectouveg.Services;
import com.mycompany.proyectouveg.Students.*;

import java.util.Scanner;

public interface ServicesEmotionals {
    void start();
    boolean StartGame(User user);
    void FistQuestion(Scanner sn);
    void SecondQuestion(Scanner sn);
    void ThirdQuestion(Scanner sn);
    void FourthQuestion(Scanner sn);
    void FifthQuestion(Scanner sn);
}

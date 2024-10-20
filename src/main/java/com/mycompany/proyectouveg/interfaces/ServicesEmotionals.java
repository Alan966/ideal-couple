package com.mycompany.proyectouveg.interfaces;
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

    interface IUser {
        String getFullName();
        String getFirstName();
        String getLastName();
        int getAge();
        Gender getGender();
        String getEmail();
        void setFistName(String first_name);
        void setLastName(String last_name);
        void setBirthday(String birthday);
        void setAge(int age);
        void setGender(Gender gender);
        void setEmail(String email);
        void getAction(Actions_enums action);
        void Authentication(String username, String password);
        boolean isAuthenticated();
        void generateToken(String username);
    }
}

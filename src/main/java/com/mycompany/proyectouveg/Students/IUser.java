package com.mycompany.proyectouveg.Students;

public interface IUser {
    String getFullName();
    String getFirstName();
    String getLastName();
    int getAge();
    Gender getGender();
    String getEmail();
    void setFistName(String first_name);
    void setLastName(String last_name);
    void setAge(int age);
    void setGender(Gender gender);
    void setEmail(String email);
    void getAction(Actions_enums action);
    void Authentication(String username, String password);
    boolean isAuthenticated();
    void generateToken(String username);
}

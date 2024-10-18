/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectouveg;

import com.mycompany.proyectouveg.Services.WomanServiceEmotionals;
import com.mycompany.proyectouveg.Students.Gender;

import java.util.Scanner;

/**
 *
 * @author alanu
 */
public class ProyectoUVEG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa los siguientes valores para crear un Usuario: ");
        System.out.println("Ingresa el nombre");
        String first_name  = sc.nextLine();
        System.out.println("Ingresa el apellido");
        String last_name  = sc.nextLine();
        System.out.println("Ingresa la edad");
        int age;
        age = Integer.parseInt(sc.nextLine());
        System.out.println("Ingresa el sexo");
        Gender gender = Gender.valueOf(sc.nextLine());
        System.out.println("Ingresa email");
        String email = sc.nextLine();
        System.out.println("Ingresa Password");
        String password = sc.nextLine();
        WomanServiceEmotionals user_service = new WomanServiceEmotionals();
        user_service.addUser(first_name, last_name, age, gender, email, password);
    }
}
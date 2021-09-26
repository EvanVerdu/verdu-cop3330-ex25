package ex25;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Evan Verdu
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class ex25Test {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        int strength;
        String StrengthString = " ";

        System.out.print("Please enter your password: ");
        String password = scanner.nextLine();


        strength = PasswordValidator(password);

        if(strength == 0){
            System.out.print("Please enter a new password.");
            System.exit(0);
        }
        else if (strength == 1){
            StrengthString = " very weak ";
        }
        else if (strength == 2){
            StrengthString = " weak ";
        }
        else if (strength == 3){
            StrengthString = " strong ";
        }
        else if (strength == 4){
            StrengthString = " very strong ";
        }

        System.out.print("The password " + "'" + password + "'" + "is a" + StrengthString + "password.");
    }

    public static int PasswordValidator(String password){

        int length = password.length();
        int value;

        Pattern p = Pattern.compile("[^a-zA-Z0-9]");
        Matcher m = p.matcher(password);

        if (password.matches("[0-9]+") && length < 8){
            value = 1;
            return value;
        }
        else if (password.matches("[a-zA-Z]+") && length < 8){
            value = 2;
            return value;
        }
        else if (password.matches("[A-Za-z0-9]+") && length >= 8) {
            value = 3;
            return value;
        }

        else if (m.find() && length >= 8) {
            value = 4;
            return value;
        }

        return 0;
    }


}
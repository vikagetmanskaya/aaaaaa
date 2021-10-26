package com.company;
import java.util.Scanner;
import javax.swing.*;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if(a==1) {
            WorkWithBD.addUser();
        }else if(a==2) {
            WorkWithBD.changeUser();
        }else if(a==3){
            WorkWithBD.deleteUser();
        } else if(a==4){
            WorkWithBD.getUsers();
        }else {

            System.out.println("Вы не выбрали действие!");
        }
    }
}

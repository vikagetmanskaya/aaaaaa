package com.company;
import java.sql.*;

public class WorkWithBD {
    public static void addUser() {
        try {
            String url = "jdbc:mysql://localhost:3306/itproger";//адрес локальной базы
            String username = "root";
            String password = "vikaget11";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();//загрузка драйвера
//Class.forName() - в параметре путь к классу драйвера
            //getDeclaredConstructor() - возвращает конструктор класса драйвера
            //newInstance() - создаёт с помощью конструктора объект класса
            try (Connection conn = DriverManager.getConnection(url, username, password)) //метод для создания объекта  java.sql.Connection(для того, чтобы подключиться к БД)
            {

                Statement statement = conn.createStatement();
                int rows = statement.executeUpdate("INSERT users(firstname, lastname, username, password, location, gender, idusers) VALUES ('Вика', 'Гетманская', 'vikagetmanskaya', '12345', 'Белар3усь', 'Женский', '5')");
                System.out.printf("Added %d rows", rows);
            }
        }

        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
    public static void changeUser(){
        try{
            String url = "jdbc:mysql://localhost:3306/itproger";
            String username = "root";
            String password = "vikaget11";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();

                int rows = statement.executeUpdate("UPDATE users SET lastname = 'Михайлов' WHERE idusers = '3'");
                System.out.printf("Updated %d rows", rows);
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
    public static void deleteUser () {
        try {
            String url = "jdbc:mysql://localhost:3306/itproger";
            String username = "root";
            String password = "vikaget11";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                Statement statement = conn.createStatement();

                int rows = statement.executeUpdate("DELETE FROM users WHERE idusers = '5'");
                System.out.printf("%d row(s) deleted", rows);
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
    public static void getUsers(){
        try{
            String url = "jdbc:mysql://localhost:3306/itproger";
            String username = "root";
            String password = "vikaget11";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                while(resultSet.next()){
                    String firstname = resultSet.getString(1);
                    String lastname = resultSet.getString(2);
                    String userName = resultSet.getString(3);
                    String passwordcol = resultSet.getString(4);
                    String location = resultSet.getString(5);
                    String gender = resultSet.getString(6);
                    String id = resultSet.getString(7);

                    System.out.printf("%s, %s, %s, %s, %s, %s, %s \n", firstname, lastname, userName, passwordcol, location, gender, id);
                }
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exam_julydb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author biar
 */
public class DBInizialization {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "biar");
        if(conn != null){
            System.out.println("Connected!");
        }else{
            System.out.println("Failed to make connection!");
        }
        
        Statement s = conn.createStatement();
        
        //Create database
        String createDB = "CREATE DATABASE moviesdb;";
        s.executeUpdate(createDB);
        
        //Use database
        String useDB = "USE moviesdb;";
        s.executeUpdate(useDB);
        
        //Create tables
        String tableD = "CREATE TABLE directors("
                + "ID INT AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(30),"
                + "yearOfBirth VARCHAR(30)"
                + ");";
        
        String tableM = "CREATE TABLE movies("
                + "ID INT AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(30),"
                + "year VARCHAR(30),"
                + "directorID INT,"
                + "FOREIGN KEY (directorID) REFERENCES directors(ID)"
                + ");";
        
        s.executeUpdate(tableD);
        s.executeUpdate(tableM);

        //Populate Tables
        s.executeUpdate("insert into directors values(1, 'Nolan', '1976');");
        s.executeUpdate("insert into directors values(2, 'Quentin Tarantulina', '1976');");
        s.executeUpdate("insert into directors values(3, 'Marvel directors', '1976');");
        s.executeUpdate("insert into directors values(4, 'DC directors', '1976');");
        
        s.executeUpdate("insert into movies values(1, 'Batman Begins', '2007','1');");
        s.executeUpdate("insert into movies values(2, 'Inception', '2006','1');");
        s.executeUpdate("insert into movies values(3, 'Bojack', '2018','2');");
        s.executeUpdate("insert into movies values(4, 'IronMan', '2010','3');");
        s.executeUpdate("insert into movies values(5, 'Thor', '2005','3');");
        s.executeUpdate("insert into movies values(6, 'Hulk', '2008','3');");
        s.executeUpdate("insert into movies values(7, 'Spiderman', '2019','3');");
        s.executeUpdate("insert into movies values(8, 'Batman e Robin', '1999','4');");
        s.executeUpdate("insert into movies values(9, 'Catwoman', '2002','4');");
        s.executeUpdate("insert into movies values(10, 'Wonder Woman', '2018','4');");
        s.executeUpdate("insert into movies values(11, 'AcquaMan', '2017','4');");
        s.executeUpdate("insert into movies values(12, 'Green Arrow', '2011','4');");
        s.executeUpdate("insert into movies values(13, 'Flash', '2013','4');");
        s.executeUpdate("insert into movies values(14, 'Atom', '2000','4');");
        s.executeUpdate("insert into movies values(15, 'Batman il cavalirere oscuro', '2009','1');");
        
    }
    
}

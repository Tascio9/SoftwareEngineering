/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exam_julyserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.jws.WebService;

/**
 *
 * @author biar
 */
@WebService(endpointInterface = "com.mycompany.exam_julyserver.Movie")
public class MovieImpl implements Movie {

    @Override
    public String getAllMovies() throws SQLException {
        String answer = "";
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/moviesdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "biar");
        if (conn != null) {
            System.out.println("Connected!");
        } else {
            System.out.println("Failed to make connection!");
        }
        
        Statement s = conn.createStatement();
        
        String query = "SELECT * FROM movies";
        
        ResultSet rs = s.executeQuery(query);
        
        while (rs.next()){
            answer = answer + rs.getString("ID") + " " + rs.getString("name") + " " + rs.getString("year") + "\n";
        }
        
       return answer;
    }

    @Override
    public String getMovie(int id) throws SQLException {
        String answer = "";

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/moviesdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "biar");
        if (conn != null) {
            System.out.println("Connected!");
        } else {
            System.out.println("Failed to make connection!");
        }

        Statement s = conn.createStatement();

        String query = "SELECT movies.ID, movies.name, movies.year, directors.name, directors.yearOfBirth "
                     + "FROM movies, directors "
                     + "WHERE movies.ID = \"" + Integer.toString(id) + "\" AND directorID = directors.id";

        ResultSet rs = s.executeQuery(query);

        while (rs.next()) {
            answer = answer + rs.getString("movies.ID") + " " 
                            + rs.getString("movies.name") + " " 
                            + rs.getString("movies.year") + " "
                            + rs.getString("directors.name") + " "
                            + rs.getString("directors.yearOfBirth") + "\n";
        }

        return answer;
    }

}

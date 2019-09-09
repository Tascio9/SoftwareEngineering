/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exam_julyserver;

import java.sql.SQLException;
import javax.jws.WebService;

/**
 *
 * @author biar
 */
@WebService
public interface Movie {

    public String getAllMovies() throws SQLException;

    public String getMovie(int id)throws SQLException;

}

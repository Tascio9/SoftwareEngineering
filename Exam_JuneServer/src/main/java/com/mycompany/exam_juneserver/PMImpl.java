/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exam_juneserver;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author biar
 */
@WebService(endpointInterface = "com.mycompany.exam_juneserver.ProfessorManagement")
public class PMImpl implements ProfessorManagement {

    List<Professor> listOfProfessor = new ArrayList<>();

    Professor p1 = new Professor("1", "Massimo", "Mecella");
    Professor p2 = new Professor("2", "Umberto", "Nanni");
    Professor p3 = new Professor("3", "Giuseppe", "De Giacomo");
    Professor p4 = new Professor("4", "Maurizio", "Lenzerini");
    Professor p5 = new Professor("5", "Domenico", "Lembo");
    Professor p6 = new Professor("6", "Roberto", "Baldoni");
    Professor p7 = new Professor("7", "Riccardo", "Rosati");
    Professor p8 = new Professor("8", "Giuseppe", "Santucci");

    {
        listOfProfessor.add(p1);
        listOfProfessor.add(p2);
        listOfProfessor.add(p3);
        listOfProfessor.add(p4);
        listOfProfessor.add(p5);
        listOfProfessor.add(p6);
        listOfProfessor.add(p7);
        listOfProfessor.add(p8);    
    }

    @Override
    public String getDetails(String id) {
        for (Professor p : listOfProfessor) {
            if (p.getId().equals(id)) {
                return p.getName() + " " + p.getSurname();
            }
        }
        return "NOT FOUND";
    }

}

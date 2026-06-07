/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lcjo_revisao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    final private String URL =  "jdbc:mysql://localhost:3306/";
    final private String USER = "root";
    final private String PASSWORD = "";

    public Connection conectar(){
        try{
            return DriverManager.getConnection(URL,USER,PASSWORD);

        }catch (SQLException e){
            throw new RuntimeException("Erro ao conectar com banco.", e);
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lcjo_revisao.dao;

import com.mycompany.lcjo_revisao.model.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lucas
 */
public class VeiculoDao {
    public void salvarVeiculo(Veiculo veiculo){
        String sql = "INSERT INTO veiculo (placa, marca, modelo) Values (?, ?, ?)";
        
        try(Connection conn = new Conexao().conectar();
           PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ){
            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getMarca());
            stmt.setString(3, veiculo.getModelo());
            
            stmt.executeUpdate();
            
            try(ResultSet rs = stmt.getGeneratedKeys()){
                if(rs.next()){
                    int idGerado = rs.getInt(1);
                    veiculo.setIdVeiculo(idGerado);
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("Erro ao salvar veiculo", e);
        }
    }
    
    public void listaVeiculo(){
        String sql = "SELECT * FROM veiculo";
        
        try(Connection conn = new Conexao().conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id_veiculo");
                String placa = rs.getString("placa");
                String modelo = rs.getString("modelo");
                
                System.out.println("id = " + id + 
                        "placa = " + placa + 
                        "modelo = " + modelo
                        );
            }
        } catch (SQLException e) {
        throw new RuntimeException("Erro ao listar veículos", e);
        }
    }
    
    
    public void updateVeiculo(String placa, String novo){
        String sql = "UPDATE veiculo FROM modelo = ? WHERE placa = ?";
        
        try(Connection conn = new Conexao().conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ){
            stmt.setString(1, novo);
            stmt.setString(2, placa);
            
            stmt.executeUpdate();
            
        }catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar veículo.", e);
        }
    }
}
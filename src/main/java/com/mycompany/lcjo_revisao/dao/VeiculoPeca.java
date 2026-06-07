/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lcjo_revisao.dao;

import com.mycompany.lcjo_revisao.model.Peca;
import com.mycompany.lcjo_revisao.model.Veiculo;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class VeiculoPeca {
    
    public void salvarVeiculoPeca(int idVeiculo, int idPeca){
        String sql = "INSERT INTO veiculo_peca (id_veiculo, id_peca) VALUES (?, ?)";

        try(Connection conn = new Conexao().conectar();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ){
            stmt.setInt(1, idVeiculo);
            stmt.setInt(2, idPeca);
            
            stmt.executeUpdate();
            
        }catch (SQLException e){
            throw new RuntimeException("Erro ao salvar veiculo", e);
        }
    }
    
    public void listaVeiculoPeca(String placa){
        String sql = "SELECT v.placa, p.nome "
                + "FROM Veiculo_Peca vp "
                + "JOIN veiculo v ON vp.id_veiculo = v.id_veiculo "
                + "JOIN peca p ON vp.id_peca = p.id_peca "
                + "WHERE v.placa = ?";
                
        try(Connection conn = new Conexao().conectar();
           PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1, placa);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                System.out.println(" - " + rs.getString("nome"));
            }
        }catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar peças", e);
        }
    }
    
    public void apagarPecaVeiculo(int id_veiculo, int id_peca){
        String sql = "DELETE FROM veiculo_peca WHERE id_veiculo = ? AND id_peca = ?";
        
        try (Connection conn = new Conexao().conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, id_veiculo);
        stmt.setInt(2, id_peca);
        
        stmt.executeUpdate();
        
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao desvincular veículo e peça.", e);
    }
    }
}

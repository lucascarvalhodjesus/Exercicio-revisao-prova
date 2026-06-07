/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lcjo_revisao.dao;

import com.mycompany.lcjo_revisao.model.Peca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lucas
 */
public class PecaDao {
    
    
    public void salvarPeca(Peca peca){
        String sql = "INSERT INTO peca (nome, fabricante, valor) VALUES (?, ?, ?)";
    
    
        try(Connection conn = new Conexao().conectar();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ){
            stmt.setString(1, peca.getNome());
            stmt.setString(2, peca.getVabricante());
            stmt.setDouble(3, peca.getValor());
            
            stmt.executeUpdate();
            
            try(ResultSet rs = stmt.getGeneratedKeys()){
                if(rs.next()){
                    int idGerado = rs.getInt(1);
                    peca.setIdPeca(idGerado);
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("Erro ao salvar veiculo", e);
        }
    }
    
    public void listaPeca(){
        String sql = "SELECT * FROM peca";
        
        try(Connection conn = new Conexao().conectar();
           PreparedStatement stmt = conn.prepareStatement(sql)
        ){
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id_peca");
                String nome = rs.getString("nome");
                String fabricante = rs.getString("fabricante");
                
                System.out.println("id = " + id + 
                        "nome = " + nome +
                        "fabricante = " + fabricante
                        );
            }
        }catch (SQLException e){
            throw new RuntimeException("Erro ao listar peca", e);
        }
    }
    
    public void updatepeca(String nome, String fabricante, double novoValor){
        String sql = "UPDATE peca FROM valor = ? WHERE nome = ? AND fabricante = ?";
        
        try(Connection conn = new Conexao().conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ){
            stmt.setDouble(1, novoValor);
            stmt.setString(2, nome);
            stmt.setString(3, fabricante);
            
            stmt.executeUpdate();
            
        }catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar peça.", e);
        }
    }
    
    public void deletaPeca(String nome, String fabricante){
        String sql = "DELETE FROM peca WHERE nome = ? AND fabricante = ?";
        
        try(Connection conn = new Conexao().conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ){
            stmt.setString(1, nome);
            stmt.setString(2, fabricante);
            
            stmt.executeUpdate();
            
        }catch (SQLException e) {
            throw new RuntimeException("Erro a apagar peça.", e);
        }
    }
   
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lcjo_revisao.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class Peca {
    private int idPeca;
    private String nome;
    private String vabricante;
    private double valor;
    
    private List<Veiculo> veiculo;
    
    public Peca(){}

    public Peca(String nome, String vabricante, double valor) {
        this.nome = nome;
        this.vabricante = vabricante;
        this.valor = valor;
        
        this.veiculo = new ArrayList<>();
    }

    public int getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVabricante() {
        return vabricante;
    }

    public void setVabricante(String vabricante) {
        this.vabricante = vabricante;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<Veiculo> getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(List<Veiculo> veiculo) {
        this.veiculo = veiculo;
    }
    
    
}

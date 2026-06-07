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
public class Veiculo {
    private int idVeiculo;
    private String placa;
    private String marca;
    private String modelo;
    
    private List<Peca> peca;
    
    public Veiculo(){};

    public Veiculo(String placa, String marca, String modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        
        this.peca = new ArrayList<>();
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public List<Peca> getPeca() {
        return peca;
    }

    public void setPeca(List<Peca> peca) {
        this.peca = peca;
    }
    
    
}

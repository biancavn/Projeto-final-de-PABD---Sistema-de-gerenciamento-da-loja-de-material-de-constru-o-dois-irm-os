/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Bianca
 */
public class FrotaVeiculos {

    public static Object getSelectionModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private Integer IDFrotaVeiculos;
    private String nomeVeiculo;
    private String marca;
    private String funcao;
    private String disponibilidade;
    
    public FrotaVeiculos(String nomeVeiculo, String marca, String funcao, String disponibilidade) {
        this.nomeVeiculo = nomeVeiculo;
        this.marca = marca;
        this.funcao = funcao;
        this.disponibilidade = disponibilidade;
    }

    public FrotaVeiculos() {
    }

    public Integer getIDFrotaVeiculos() {
        return IDFrotaVeiculos;
    }

    public void setIDFrotaVeiculos(Integer IDFrotaVeiculos) {
        this.IDFrotaVeiculos = IDFrotaVeiculos;
    }

    public String getNomeVeiculo() {
        return nomeVeiculo;
    }

    public void setNomeVeiculo(String nomeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    
    
    
}

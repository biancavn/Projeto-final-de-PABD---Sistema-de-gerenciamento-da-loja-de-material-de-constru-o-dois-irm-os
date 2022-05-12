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
public class Produto {
    private Integer IDProduto;
    private String nome;
    private String categoria;
    private Integer quantidade;
    private String marca;
    private String tamanho; //string porque é para colocar a variavel também 1,25 litros ou 1,25 mentros
    
    public Produto(String nome, String categoria, Integer quantidade, String marca, String tamanho) {
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.marca = marca;
        this.tamanho = tamanho;
    }

    public Produto() {
        
    }

    public Integer getIDProduto() {
        return IDProduto;
    }

    public void setIDProduto(Integer IDProduto) {
        this.IDProduto = IDProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }


    





    
}

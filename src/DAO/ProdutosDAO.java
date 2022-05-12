/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Bianca
 */
public class ProdutosDAO {

    
     // Produto é  o primeiro metodo do model
        public boolean criar(Produto produto) {
        
        try {
            
            String comando = "INSERT INTO produtos (nome, categoria,quantidade,marca, tamanho) VALUES (?, ?, ?, ?, ?)"; 

            Connection conn = FabricaConexao.getConnection(); 
        
            PreparedStatement ps = conn.prepareStatement(comando);
            
            ps.setString(1, produto.getNome()); 
            ps.setString(2, produto.getCategoria());
            ps.setFloat(3, produto.getQuantidade());
            ps.setString(4, produto.getMarca());
            ps.setString(5, produto.getTamanho());

            //colocando dados no banco
            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                return true;
            }
             FabricaConexao.fecharConexao(conn); 
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
        public boolean atualizar(Produto produto) {

        String sql = "UPDATE loja_doisirmaos.produtos SET nome = ?, categoria = ?, quantidade = ?, marca=?, tamanho = ? WHERE produtos.id_produto = ?";

        try {
            Connection conn = FabricaConexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getCategoria());
            ps.setFloat(3, produto.getQuantidade());
            ps.setString(4, produto.getMarca());
            ps.setString(5, produto.getTamanho());
            ps.setInt(6, produto.getIDProduto());

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Produto> buscarTodos() {
        String sql = "SELECT * FROM loja_doisirmaos.produtos"; 

        // Responsável em guardar o resultado
        ResultSet resultado = null; 

        ArrayList<Produto> lista = new ArrayList<Produto>();

        Connection conn = FabricaConexao.getConnection();

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            resultado = ps.executeQuery(); 

            while (resultado.next()) { 
                Produto a = new Produto(); 
                a.setIDProduto(resultado.getInt("id_produto"));
                a.setNome(resultado.getString("nome"));
                a.setCategoria(resultado.getString("categoria")); 
                a.setQuantidade(resultado.getInt("quantidade"));
                a.setMarca(resultado.getString("marca"));
                a.setTamanho(resultado.getString("tamanho"));
                
                
                lista.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        FabricaConexao.fecharConexao(conn);

        return lista;
    }

    public boolean apagar(Integer id) {
        if (id == null || id < 0) {
            throw new IllegalArgumentException();
        }
        //"DELETE FROM funcionario WHERE funcionario.id_funcionario = ?"
        String sql = "DELETE FROM produtos WHERE produtos.id_produto  = ?";
        try {
            Connection conn = FabricaConexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
        
    }


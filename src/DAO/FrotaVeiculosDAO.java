/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.FrotaVeiculos;

/**
 *
 * @author Bianca
 */
public class FrotaVeiculosDAO {
    public boolean criar(FrotaVeiculos frotaVeiculos) {
        
        try {
            
            String comando = "INSERT INTO frotaVeiculos (nomeVeiculo, marca, função, disponibilidade) VALUES (?, ?, ?, ?)"; 

            Connection conn = FabricaConexao.getConnection(); 
        
            PreparedStatement ps = conn.prepareStatement(comando);
            
            ps.setString(1, frotaVeiculos.getNomeVeiculo()); 
            ps.setString(2, frotaVeiculos.getMarca());
            ps.setString(3, frotaVeiculos.getFuncao());
            ps.setString(4, frotaVeiculos.getDisponibilidade());

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
        public boolean atualizar(FrotaVeiculos frotaVeiculos) {

        String sql = "UPDATE loja_doisirmaos.frotaVeiculos SET nomeVeiculo = ?, marca = ?, função = ?, disponibilidade=? WHERE frotaVeiculos.id_frotaVeiculos = ?";

        try {
            Connection conn = FabricaConexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, frotaVeiculos.getNomeVeiculo());
            ps.setString(2, frotaVeiculos.getMarca());
            ps.setString(3, frotaVeiculos.getFuncao());
            ps.setString(4, frotaVeiculos.getDisponibilidade());
            ps.setInt(5, frotaVeiculos.getIDFrotaVeiculos());

                        
            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<FrotaVeiculos> buscarTodos() {
        String sql = "SELECT * FROM loja_doisirmaos.frotaVeiculos"; 

        ResultSet resultado = null; 

        ArrayList<FrotaVeiculos> lista = new ArrayList<FrotaVeiculos>();

        Connection conn = FabricaConexao.getConnection();

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            resultado = ps.executeQuery(); 

            while (resultado.next()) { 
                FrotaVeiculos a = new FrotaVeiculos(); 
                a.setIDFrotaVeiculos(resultado.getInt("id_frotaVeiculos"));
                a.setNomeVeiculo(resultado.getString("nomeVeiculo"));
                a.setMarca(resultado.getString("marca")); 
                a.setFuncao(resultado.getString("função"));
                a.setDisponibilidade(resultado.getString("disponibilidade"));                
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
        String sql = "DELETE FROM frotaVeiculos WHERE frotaVeiculos.id_frotaVeiculos = ?;";
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

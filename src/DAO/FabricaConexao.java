/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bianca
 */

public class FabricaConexao {
    private static final String URL = "jdbc:mysql://localhost:3306/Loja_DoisIrmaos"; 
    private static final String USER = "root";
    private static final String PASS = "23042004"; 


    public static Connection getConnection() {  
        try {
            return DriverManager.getConnection(URL, USER, PASS); 
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            System.out.println("erro nas conexões");
            return null;
        }
    }

    public static void fecharConexao(Connection conn) { 
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fecharConexao(Connection conn, Statement s) {
        fecharConexao(conn);
        try {
            if (s != null) {
                s.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    }

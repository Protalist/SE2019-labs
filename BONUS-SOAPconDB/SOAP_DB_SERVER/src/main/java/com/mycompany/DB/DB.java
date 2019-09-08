/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DB;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lorenzo
 */
public class DB {
    
    static String db = "SOAP.db";
    static String url = "jdbc:sqlite:/home/lorenzo/" + db;
    
    private static void createNewDatabase(Connection conn) {
 
		try {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("Il nome del driver è " + meta.getDriverName());
				System.out.println("E' stato creato il datadase " + db);
			}	
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
    }
    
    public static void createNewTable(Connection conn,String txt) {
            String sql="";
	if (txt.equals("")){
            sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
			+ "	id integer PRIMARY KEY,\n"
			+ "	name text NOT NULL,\n"
			+ "	capacity real\n"
			+ ");";
        }
        else{
            sql =txt;
        }
            System.out.println(sql);
	Statement stmt;
	try {
		stmt = conn.createStatement();
		// create a new table
		System.out.println("E' stata creata la tabella");
		stmt.execute(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
    
    private static String createStringSqlCREATETABLE(String nome,String[] attr){  // attributes in the form " [name] [TYPE] [Primary K/FOREIGNk/NOT NULL]"
            String res = "CREATE TABLE IF NOT EXISTS ";
            res+=nome+" (\n     ";
            int i = attr.length;
            System.out.println(i);
            for(String s:attr){
                if(i==1){ res+=s+"\n";break;}
                res+=s+",\n     ";
                i--;
            }
            res+=");";
            return res;
        }
	
	private static void FirstSetUp() {
 
		Connection conn = SQLiteJDBCDriverConnection.connect(url);
		createNewDatabase(conn);
		SQLiteJDBCDriverConnection.closeConnection(conn);
               
	}
        
         public static List<String> selectAllAuto(){
             ArrayList<String> res = new ArrayList<>();
            Connection conn = SQLiteJDBCDriverConnection.connect(url);
            String sql = "SELECT * "
			+ "FROM Auto";
            try {
		PreparedStatement pstmt  = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                String tmp="";
                while(rs.next()){
                   tmp+="< "+rs.getString("brand")+", "+rs.getString("name")+" ,"+rs.getInt("hp");
                   res.add(tmp);
                   tmp="";
                }
                return res;
            }catch(SQLException e){
                
            }
            return new ArrayList<String>();
         }
        
        public static void insertAuto(String values) {
        Connection conn = SQLiteJDBCDriverConnection.connect(url);
	String sql = "INSERT INTO Auto (brand,name,hp) VALUES(?,?,?)";
        
	try {
                String [] splitter = values.split(",");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, splitter[0]);
                
                pstmt.setString(2, splitter[1]);
                
                pstmt.setInt(3, new Integer(splitter[2]));
		pstmt.executeUpdate();
                
                conn.close();
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
        
        
    } 
        
        
        public static void main(String[] args) {
            /*
            FirstSetUp();
            
            Connection conn = SQLiteJDBCDriverConnection.connect(url); //always needed to start working with  DB
            
            
            String [] attrAuto = {"id integer PRIMARY KEY","brand text NOT NULL","name text NOT NULL","hp integer"};
            createNewTable(conn,createStringSqlCREATETABLE("Auto",attrAuto));
            insertAuto("BMW,X5,446"); insertAuto("FIAT,Panda,72");insertAuto("RENAULT,CLIO,70");insertAuto("FERRARI,458,509");
            //insertUser(conn,"User","Dio44,Pino,32");
            //insertUser(conn,"User","Babilone31,Ezio,58");
        */
    }
}

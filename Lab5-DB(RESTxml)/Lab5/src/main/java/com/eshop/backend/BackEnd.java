/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshop.backend;

import com.eshop.backend.services.Item;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class BackEnd {
    static String db = "eshop.db";
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
        
        public static void insertUser(Connection conn,String Tablename,String values) {
	String sql = "INSERT INTO "+Tablename+"(pwd,name,age) VALUES(?,?,?)";
        
	try {
                String [] splitter = values.split(",");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, splitter[0]);
                pstmt.setString(2, splitter[1]);
                pstmt.setInt(3, new Integer(splitter[2]));
		pstmt.executeUpdate();
		
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
        
        
    } 
        
        
         public static void insertItem(String Tablename,String values) {
             Connection conn = SQLiteJDBCDriverConnection.connect(url);
	String sql = "INSERT INTO "+Tablename+"(name,type,price) VALUES(?,?,?)";
        
	try {
                String [] splitter = values.split(",");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, splitter[0]);
                pstmt.setString(2, splitter[1]);
                pstmt.setFloat(3, new Float(splitter[2]));
		pstmt.executeUpdate();
		
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
        
        
    } 
        
        public static void insertBasket(String Tablename,String values) {
        Connection conn = SQLiteJDBCDriverConnection.connect(url);
	String sql = "INSERT INTO "+Tablename+"(idUser,items,pricetotal) VALUES(?,?,?)";
        
	try {
                String [] splitter = values.split(",");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, new Integer(splitter[0]));
                
                pstmt.setString(2, splitter[1]);
                
                pstmt.setFloat(3, new Float(splitter[2]));
		pstmt.executeUpdate();
                
                conn.close();
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
        
        
    } 
        
        public static void deleteBasket(int iduser){
            Connection conn = SQLiteJDBCDriverConnection.connect(url);
            String sql = "DELETE FROM BASKET WHERE idUser = ?";
            try{
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,iduser);
              pstmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BackEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
         public static void insertOrder(String Tablename,String values) {
             Connection conn = SQLiteJDBCDriverConnection.connect(url);
	String sql = "INSERT INTO "+Tablename+"(data,idUser,items,pricetotal) VALUES(?,?,?,?)";
        
	try {
                String [] splitter = values.split(",");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, splitter[0]);
		pstmt.setInt(2, new Integer(splitter[1]));
                pstmt.setString(3, splitter[2]);
                pstmt.setFloat(4, new Float(splitter[3]));
		pstmt.executeUpdate();
		
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
        
        
    } 
         
        public static void selectAllUser(Connection conn) {
	String sql = "SELECT * FROM User";
 
	try {
		Statement stmt  = conn.createStatement();
		ResultSet rs    = stmt.executeQuery(sql);
 
		// loop through the result set
		while (rs.next()) {
			System.out.println(rs.getInt("id") +  "\t" + 
					rs.getString("name") + "\t" +
					rs.getInt("age"));
		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
    }
        
        
        public static List<Item> selectAllItem() {
        Connection conn = SQLiteJDBCDriverConnection.connect(url);
	String sql = "SELECT * FROM Item";
 
	try {
		Statement stmt  = conn.createStatement();
		ResultSet rs    = stmt.executeQuery(sql);
 
		Item i ; List<Item> lista = new ArrayList<>();
		while (rs.next()) {
			i=new Item();i.setId(rs.getInt("id"));i.setName(rs.getString("name"));i.setType(rs.getString("type"));i.setPrice(rs.getFloat("price")); 
                        lista.add(i);
                        
		}
                conn.close();
                return lista;
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
        return null;
    }
        
        public static int selectUserLogin(String nome,String pass){
            Connection conn = SQLiteJDBCDriverConnection.connect(url);
            String sql = "SELECT * "
			+ "FROM User WHERE name = ? AND pwd = ?";
            try {
		PreparedStatement pstmt  = conn.prepareStatement(sql); 
 
		// set the value
		pstmt.setString(1,nome);
                pstmt.setString(2, pass);
		
		ResultSet rs  = pstmt.executeQuery();
                if(rs.next()!= false){
                    
                    int ris=rs.getInt("id");conn.close();
                    return ris;
                }
                else{
                    conn.close();
                    return -1;}
            } catch(SQLException e) {
		System.out.println(e.getMessage());}
            return -1;
            
        }
        public static String selectBasketofUser(int id){
            Connection conn = SQLiteJDBCDriverConnection.connect(url);
            String sql = "SELECT * "
			+ "FROM Basket WHERE idUser = ?";
            try {
		PreparedStatement pstmt  = conn.prepareStatement(sql); 
 
		// set the value
		pstmt.setInt(1,id);
		//
		ResultSet rs  = pstmt.executeQuery();
 
		// loop through the result set
		String res ="";
		while (rs.next()) {
			res+=rs.getString("items")+" - TOT = "+ rs.getFloat("pricetotal");
		}
                conn.close();
                return res;
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
            return null;
            
    }  
        
        public static void selectUserAgeGreater(Connection conn, int ageObj){
	String sql = "SELECT * "
			+ "FROM User WHERE age > ?";
 
	try {
		PreparedStatement pstmt  = conn.prepareStatement(sql); 
 
		// set the value
		pstmt.setDouble(1,ageObj);
		//
		ResultSet rs  = pstmt.executeQuery();
 
		// loop through the result set
		while (rs.next()) {
			System.out.println(rs.getInt("id") +  "\t" + 
					rs.getString("name") + "\t" +
					rs.getInt("age"));
		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
}
        
        
        private static void DeleteallRows(String TableName) {
            Connection conn = SQLiteJDBCDriverConnection.connect(url);
            String sql = "DELETE  FROM "+TableName;
            PreparedStatement pstmt; 
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BackEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
        }
        public static void main(String[] args) {
            //FirstSetUp();     //Create new db
            
            DeleteallRows("Basket");
           // Connection conn = SQLiteJDBCDriverConnection.connect(url); //always needed to start working with  DB
            
            
            //String [] attUser = {"id integer PRIMARY KEY","pwd text NOT NULL","name text NOT NULL","age integer"};
            //createNewTable(conn,createStringSqlCREATETABLE("User",attUser));
            //insertUser(conn,"User","Cristo22,Giovanni,46");
            //insertUser(conn,"User","Dio44,Pino,32");
            //insertUser(conn,"User","Babilone31,Ezio,58");
            
            //String [] attrItem = {"id integer PRIMARY KEY","name text NOT NULL","type text NOT NULL","price float NOT NULL"};
            //createNewTable(conn,createStringSqlCREATETABLE("Item",attrItem));
           /* insertItem(conn,"Item","Caciocavallo,Food,10.50");
            insertItem(conn,"Item","La Scienza Bella,book,30.99");
            insertItem(conn,"Item","Computer,Tech,1110.70");
            insertItem(conn,"Item","Panino,Food,3.50");
            insertItem(conn,"Item","Salame,Food,1.50");
            insertItem(conn,"Item","TV,Tech,400.40");
            insertItem(conn,"Item","Harry Potter,book,14.50"); */
           
           
           //String [] attrBasket = {"id integer PRIMARY KEY","idUser integer NOT NULL","items text","pricetotal float NOT NULL","FOREIGN KEY (idUser) REFERENCES User(id)"};
            //createNewTable(conn,createStringSqlCREATETABLE("Basket",attrBasket));
            
         //   String [] attrOrder = {"id integer PRIMARY KEY","data text NOT NULL","idUser integer NOT NULL","items text","pricetotal float NOT NULL","FOREIGN KEY (idUser) REFERENCES User(id)"};
          //  createNewTable(conn,createStringSqlCREATETABLE("Orders",attrOrder));
            //QUERIES
            //selectAllUser(conn);
            //selectUserAgeGreater(conn,40);
    }
}

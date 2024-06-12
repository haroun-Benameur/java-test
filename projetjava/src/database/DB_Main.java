package database;

import java.sql.*;

public class DB_Main {

    public static void main(String[] arges){
        GestionEtudiant e1 =new GestionEtudiant();
        //connet a la base de donner
        String url="jdbc:mysql://127.0.0.1/DB_tpjava";
        String username="root";
        String password="";
        EtudiantDAO e=new EtudiantDAO(url,username,password);
      int a= e.insertEtudiant("azer","azerr",123,10);
      System.out.println(a);
       e.afficheALL("select * from etudiant");


    }
}

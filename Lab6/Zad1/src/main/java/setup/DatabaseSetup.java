package setup;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSetup {

    public static void main(String[] args) throws SQLException, FileNotFoundException {

        /*Setup
         1. create database library in pgsql -> CREATE DATABASE library;
         2. Run the WebApp -> Hibernate will create entities
         3. Run this main -> it will fill DB with data*/

        DriverManager.registerDriver(new org.postgresql.Driver());
        String mysqlUrl = "jdbc:postgresql://localhost:5432/library";
        Connection con = DriverManager.getConnection(mysqlUrl, "postgres", "postgres");
        System.out.println("Connection established......");
        ScriptRunner sr = new ScriptRunner(con);
        String filePath = new File("").getAbsolutePath();
        BufferedReader reader = new BufferedReader(new FileReader(filePath+"/src/main/java/setup/library.sql"));
        sr.runScript(reader);
    }
}

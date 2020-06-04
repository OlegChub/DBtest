package org.example;

import java.sql.*;

public class MySQLconnection {
    public static void main(String[] args) throws SQLException {
        String host = "localhost";
        String port = "3306";
        String dbName = "Qadbt";
        // убирает ошибку с несоответствием времени и временной зоны, установленными на сервере
        String timeZoneSet = "?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
        Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + dbName + timeZoneSet, "root", "180387");
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery("select * from Credentials where login='admin'");
        while (result.next()) {
            System.out.println(result.getString("login"));
            System.out.println(result.getString("password"));
            System.out.println(result.getString("info"));
        }
    }
}

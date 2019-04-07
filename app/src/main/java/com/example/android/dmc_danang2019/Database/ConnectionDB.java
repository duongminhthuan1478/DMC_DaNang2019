package com.example.android.dmc_danang2019.Database;


import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by NhatThanh on 2/28/2017.
 */

public class ConnectionDB {
   // static String url = "jdbc:jtds:sqlserver://localhost:1433;databaseName=QuanLiKyTrucXa";
    String ip = "192.168.134.2";
    static String classs = "net.sourceforge.jtds.jdbc.Driver";
    static String db = "QuanLiKyTrucXa";
    static String  userName = "thuan";
    static String password = "Dmt123456";

    @SuppressLint("NewApi")
    public Connection CONN() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {

            Class.forName(classs);
            ConnURL = "jdbc:jtds:sqlserver://" + ip + ";"
                    + "databaseName=" + db + ";user=" + userName + ";password="
                    + password + ";";
          /*  ConnURL = "jdbc:jtds:sqlserver://localhost:1433;"
                    + "databaseName=" + db + ";user=" + un + ";password="
                    + password + ";";*/

            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        return conn;

    }

}

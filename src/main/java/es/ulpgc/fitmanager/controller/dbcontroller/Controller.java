package es.ulpgc.fitmanager.controller.dbcontroller;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class Controller {
    protected Connection connectToDB() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) { log.error(ex.getLocalizedMessage()); }
        String url = "jdbc:sqlite:db" + File.separator + "fitManager.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) { log.error(ex.getLocalizedMessage()); }
        return conn;
    }
}
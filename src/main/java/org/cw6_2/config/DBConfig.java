package org.cw6_2.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
    public static final Connection connection;

    static {
        try {
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/","postgres","a*1294278F");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

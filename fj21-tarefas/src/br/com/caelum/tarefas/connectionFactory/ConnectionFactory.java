package br.com.caelum.tarefas.connectionFactory; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * A Hello World Java application
 * 
 * @author test
 *
 */
public class ConnectionFactory {
    /** 
     * Conex�o com o banco
     *
     */
    public final Connection getConnection() throws SQLException {
        System.out.println("conectando ...");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }

        return DriverManager.getConnection("jdbc:mysql://localhost/tarefa",
                "root", "123456");
    }
}

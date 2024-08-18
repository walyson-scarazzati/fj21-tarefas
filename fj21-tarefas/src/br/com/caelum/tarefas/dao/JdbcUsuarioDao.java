package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.caelum.tarefas.connectionFactory.ConnectionFactory;
import br.com.caelum.tarefas.model.Usuario;

/**
 * A Hello World Java application
 * 
 * @author test
 *
 */
public class JdbcUsuarioDao {
    private Connection connection;

    /**
     * para fazer conex�o
     * 
     * @author test
     *
     */
    public JdbcUsuarioDao() {
        try {
            connection = new ConnectionFactory().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean existeUsuario(Usuario usuario) {

        if (usuario == null) {
            throw new IllegalArgumentException("Usu�rio n�o deve ser nulo");
        }

        try {
            PreparedStatement stmt = this.connection
                    .prepareStatement("select * from usuarios where login = ? and senha = ?");
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            ResultSet rs = stmt.executeQuery();

            boolean encontrado = rs.next();
            rs.close();
            stmt.close();

            return encontrado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

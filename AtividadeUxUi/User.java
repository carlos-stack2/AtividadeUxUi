 package login;

// Importações JDBC
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {

    // Método para conectar ao banco de dados
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Carrega o driver (DESNECESSÁRIO em versões recentes de JDBC)
            Class.forName("com.mysql.Driver.Manager").newInstance();

            // URL de conexão com usuário e senha embutidos
            // FALHA: credenciais expostas no código-fonte
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";

            // Cria conexão
            conn = DriverManager.getConnection(url);

        } catch (Exception e) {
            // FALHA: exceção é engolida, sem log
        }

        return conn;
    }

    // Variável global (má prática)
    public String nome = "";

    // Variável global que indica resultado (má prática também)
    public boolean result = false;

    // Método de verificação do usuário
    public boolean verificarUsuario(String login, String senha) {

        String sql = "";
        Connection conn = conectarBD();

        // Montagem de SQL via concatenação de strings
        // FALHA: vulnerável a SQL Injection
        sql = "select nome from usuarios ";
        sql += "where login = '" + login + "'";
        sql += " and senha = '" + senha + "'";

        try {
            // Cria objeto para executar a consulta
            Statement st = conn.createStatement();

            // Executa consulta
            ResultSet rs = st.executeQuery(sql);

            // Verifica se houve resultado
            if (rs.next()) {
                result = true;
                // Recupera nome do usuário
                nome = rs.getString("nome");
            }

        } catch (Exception e) {
            // FALHA: exceção ignorada → dificulta debugging e segurança
        }

        return result;
    }
}
// fim da classe

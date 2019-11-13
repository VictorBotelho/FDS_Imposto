package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DadosComuns.PessoaFisica;
import dao.CadastroDAOJavaDataBase;
import negocio.CadastroDAO;
import negocio.Pessoa;

public class CadastroDAOJavaDataBase implements CadastroDAO{
    private static CadastroDAOJavaDataBase ref;
    
    public static CadastroDAOJavaDataBase getInstance() throws CadastroDAOException {
        if (ref == null)
            ref = new CadastroDAOJavaDataBase();
        return ref;
    }
    
    private CadastroDAOJavaDataBase() throws CadastroDAOException {
        try {
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException ex) {
            throw new CadastroDAOException("JdbcOdbDriver not found!!");
        }
        // Cria o banco de dados vazio
        // Retirar do comentário se necessário
        /*
        try {
            createDB();
        } catch (Exception ex) {
            System.out.println("Problemas para criar o banco: "+ex.getMessage());
            System.exit(0);
        }
        */
        //
    }
    
    private static void createDB() throws CadastroDAOException {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby:derbyDB;create=true");
            Statement sta = con.createStatement();
            String sqlPessoaFisica = "CREATE TABLE PessoasFisica ("
                    + "ID_PESSOA INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "NOME VARCHAR(100) NOT NULL,"
                    + "CPF CHAR(11) NOT NULL,"
                    + "IDADE CHAR(2),"
                    + "NUMERO_DEPENDENTES CHAR(2)"
                    + ")";
            String sqlRendaPessoaFisica = "CREATE TABLE RendaPessoaFisica ("
                    + "ID_DECLARACAO INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                   //como fazer a FK desta bosta com o ID pessoa //+ "FK_PESSOA(1) NOT NULL,"
                    + "CONTRIBUICAO_PREVIDENCIARIA(100) NOT NULL,"
                    + "TOTAL_RENDIMENTOS CHAR(11) NOT NULL,"
                    + "IDADE CHAR(2),"
                    + "NUMERO_DEPENDENTES CHAR(2)"
                    + ")";
            sta.executeUpdate(sqlPessoaFisica);
            sta.close();
            con.close();
        } catch (SQLException ex) {
            throw new CadastroDAOException(ex.getMessage());
        }
    }
    
    private static Connection getConnection() throws SQLException {
        //derbyDB sera o nome do diretorio criado localmente
        return DriverManager.getConnection("jdbc:derby:derbyDB");
    }
    
    @Override
    public boolean adicionar(PessoaFisica p) throws CadastroDAOException {
        try {
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO PESSOAS (NOME, TELEFONE, SEXO) VALUES (?,?,?)" //                             1        2         3            4          5             6
                    );
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getTelefone());
            stmt.setString(3, Character.toString(p.getSexo()));
            int ret = stmt.executeUpdate();
            con.close();
            return (ret>0);
        } catch (SQLException ex) {
            throw new CadastroDAOException("Falha ao adicionar.", ex);
        }
    }

    @Override
    public PessoaFisica getPessoaPorNome(String n) throws CadastroDAOException {
        try {
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT * FROM PESSOAS WHERE NOME=?"
                    );
            stmt.setString(1, n);
            ResultSet resultado = stmt.executeQuery();
            PessoaFisica p = null;
            if(resultado.next()) {
                String nome = resultado.getString("NOME");
                String telefone = resultado.getString("TELEFONE");
                String sexo = resultado.getString("SEXO");
                p = new PessoaFisica(nome, telefone, sexo.equals("M"));
            }
            return p;
        } catch (SQLException ex) {
            throw new CadastroDAOException("Falha ao buscar.", ex);
        }
    }

    @Override
    public List<PessoaFisica> getHomens() throws CadastroDAOException {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PESSOAS WHERE SEXO='M'");
            List<PessoaFisica> lista = new ArrayList<PessoaFisica>();
            while(resultado.next()) {
                String nome = resultado.getString("NOME");
                String telefone = resultado.getString("TELEFONE");
                String sexo = resultado.getString("SEXO");
                PessoaFisica p = new PessoaFisica(nome, telefone, sexo.equals("M"));
                lista.add(p);
            }
            return lista;
        } catch (SQLException ex) {
            throw new CadastroDAOException("Falha ao buscar.", ex);
        }
    }

    @Override
    public List<PessoaFisica> getMulheres() throws CadastroDAOException {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PESSOAS WHERE SEXO='F'");
            List<PessoaFisica> lista = new ArrayList<PessoaFisica>();
            while(resultado.next()) {
                String nome = resultado.getString("NOME");
                String telefone = resultado.getString("TELEFONE");
                String sexo = resultado.getString("SEXO");
                PessoaFisica p = new PessoaFisica(nome, telefone, sexo.equals("M"));
                lista.add(p);
            }
            return lista;
        } catch (SQLException ex) {
            throw new CadastroDAOException("Falha ao buscar.", ex);
        }    }

    @Override
    public List<PessoaFisica> getTodos() throws CadastroDAOException {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PESSOAS");
            List<PessoaFisica> lista = new ArrayList<PessoaFisica>();
            while(resultado.next()) {
                String nome = resultado.getString("NOME");
                String telefone = resultado.getString("TELEFONE");
                String sexo = resultado.getString("SEXO");
                PessoaFisica p = new PessoaFisica(nome, telefone, sexo.equals("M"));
                lista.add(p);
            }
            return lista;
        } catch (SQLException ex) {
            throw new CadastroDAOException("Falha ao buscar.", ex);
        }    }
    
}

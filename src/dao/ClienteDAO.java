package dao;

import classes.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class ClienteDAO {

    public String gravarCliente(Cliente cliente) {

        String resp = "";
        try {
            Connection con = Conecta.getConexao();

            String sql = "INSERT INTO clientes(cpf, nome, sexo, cep, rua, bairro, numero, complemento, cidade, estado, email, celular)";
            sql += "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getSexo());
            ps.setString(4, cliente.getCep());
            ps.setString(5, cliente.getRua());
            ps.setString(6, cliente.getBairro());
            ps.setString(7, cliente.getNumero());
            ps.setString(8, cliente.getComplemento());
            ps.setString(9, cliente.getCidade());
            ps.setString(10, cliente.getEstado());
            ps.setString(11, cliente.getEmail());
            ps.setString(12, cliente.getCelular());

            ps.execute();

            ps.close();
            con.close();

            resp = "OK";
        } catch (Exception e) {
            resp = "ERRO: " + e.toString();
            JOptionPane.showMessageDialog(null, e + "Erro");

        }
        return resp;
    }

    public String alteraClinte(Cliente cliente) {   // usar no alugar
        String resp = "";

        try {

            Connection con = Conecta.getConexao();
            String sql = " UPDATE clientes SET nome=?, sexo=?, cep=?, rua=?, bairro=?, numero=?, complemento=?, cidade=?, estado=?, email=?, celular=? WHERE cpf=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getSexo());
            ps.setString(3, cliente.getCep());
            ps.setString(4, cliente.getRua());
            ps.setString(5, cliente.getBairro());
            ps.setString(6, cliente.getNumero());
            ps.setString(7, cliente.getComplemento());
            ps.setString(8, cliente.getCidade());
            ps.setString(9, cliente.getEstado());
            ps.setString(10, cliente.getEmail());
            ps.setString(11, cliente.getCelular());
            ps.setString(12, cliente.getCpf());

            ps.executeUpdate();

            ps.close();
            con.close();
            resp = "OK";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }

    public Cliente buscaCliente(String cpf) {
        Cliente cli = new Cliente();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM clientes WHERE cpf=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();  // guarda o retorno de selects
            if (rs.next()) {
                cli.setCpf(rs.getString("cpf"));
                cli.setNome(rs.getString("nome"));
                cli.setSexo(rs.getString("sexo"));
                cli.setCep(rs.getString("cep"));
                cli.setRua(rs.getString("rua"));
                cli.setBairro(rs.getString("bairro"));
                cli.setNumero(rs.getString("numero"));
                cli.setComplemento(rs.getString("complemento"));
                cli.setCidade(rs.getString("cidade"));
                cli.setEstado(rs.getString("estado"));
                cli.setEmail(rs.getString("email"));
                cli.setCelular(rs.getString("celular"));

            } else {
                cli = null;
            }
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            cli = null;
            JOptionPane.showMessageDialog(null, "Cliente encontrado");

        }
        return cli;
    }

}

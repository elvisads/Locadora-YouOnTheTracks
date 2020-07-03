package dao;

import classes.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VeiculoDAO {

    public String gravarVeiculo(Veiculo veiculo) {

        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            /// placa, idMarca
            String sql = "INSERT INTO veiculos(placa, modelo, marca, cor, portas, ano, preco, categoria, classe)";
            sql += "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getNome());
            ps.setString(3, veiculo.getMarca());
            ps.setString(4, veiculo.getCor());
            ps.setString(5, veiculo.getPortas());
            ps.setString(6, veiculo.getAno());
            ps.setFloat(7, veiculo.getPreco());
            ps.setString(8, veiculo.getCategoria());
            ps.setString(9, veiculo.getClasse());

            ps.execute();

            ps.close();
            con.close();

            resp = "OK";
        } catch (Exception e) {
            resp = "ERRO: " + e.toString();
            JOptionPane.showMessageDialog(null, "Placa Existente");

        }
        return resp;
    }

    public Veiculo pegaVeiculo(Veiculo veiculo) {
        Veiculo veiculoExistente = new Veiculo();
        //boolean votou = false;
        String acessos;
        String sql;
        try {
            Connection con = Conecta.getConexao();

            sql = "SELECT marca FROM veiculos WHERE marca= ? ";

            PreparedStatement ps = con.prepareStatement(sql);
            //ps.setString(1, veiculo.getClasse());
            ps.setString(1, veiculo.getMarca());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                //rs.getString("nome");
                veiculoExistente.setPlaca(rs.getString("marca"));
            } else {
                ps.close();
                return veiculoExistente;
            }

            con.close();
        } catch (SQLException e) {

        }
        return veiculoExistente;

    }

    public Veiculo buscaVeiculo(Veiculo veiculo) {

        Veiculo veiculoExistente = new Veiculo();
        //boolean votou = false;

        String sql;
        try {
            Connection con = Conecta.getConexao();

            sql = "SELECT marca FROM veiculos WHERE placa= ?, nome=?, marca=?, cor=?, portas=?, ano=?, preco=?, categoria=?, classe=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getNome());
            ps.setString(3, veiculo.getMarca());
            ps.setString(4, veiculo.getCor());
            ps.setString(5, veiculo.getPortas());
            ps.setString(6, veiculo.getAno());
            ps.setFloat(7, veiculo.getPreco());
            ps.setString(8, veiculo.getCategoria());
            ps.setString(9, veiculo.getClasse());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                veiculoExistente.setPlaca(rs.getString("marca"));
            } else {
                ps.close();
                return veiculoExistente;
            }

            con.close();
        } catch (SQLException e) {

        }
        return veiculoExistente;

    }

    public List<Veiculo> listarVeiculos() {

        List<Veiculo> veiculos = new ArrayList<>();
        Veiculo umVeiculo;

        try {

            Connection db = Conecta.getConexao();
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM veiculos");

            while (rs.next()) {
                DefaultTableModel model = new DefaultTableModel();

                umVeiculo = new Veiculo();

                umVeiculo.setPlaca(rs.getString(1));
                umVeiculo.setNome(rs.getString(2));
                umVeiculo.setMarca(rs.getString(3));
                umVeiculo.setCor(rs.getString(4));
                umVeiculo.setPortas(rs.getString(5));
                umVeiculo.setAno(rs.getString(6));
                umVeiculo.setPreco(rs.getFloat(7));
                umVeiculo.setCategoria(rs.getString(8));
                umVeiculo.setClasse(rs.getString(9));
                umVeiculo.setAlugado(rs.getString(10));
                veiculos.add(umVeiculo);

            }

            rs.close();
            st.close();

        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }

        return veiculos;
    }

    public String excluirVeiculo(Veiculo veiculo) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            String sql = "DELETE FROM veiculos WHERE placa=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, veiculo.getPlaca());
            int deleteCount = ps.executeUpdate();
            ps.execute();
            resp = "OK";

        } catch (Exception e) {
            resp = "ERRO: " + e.toString();
        }

        return resp;
    }

    public Veiculo psqVeiculo(String placa) {
        Veiculo veic = new Veiculo();
        String acessos;

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM veiculos WHERE placa= ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, placa);
            ResultSet rs = ps.executeQuery();  // guarda o retorno de selects
            if (rs.next()) {

                veic.setPlaca(rs.getString("placa"));
                veic.setMarca(rs.getString("marca"));
                veic.setCor(rs.getString("cor"));
                veic.setPortas(rs.getString("portas"));
                veic.setAno(rs.getString("ano"));
                veic.setPreco(rs.getFloat("praco"));
                veic.setCategoria(rs.getString("categoria"));
                veic.setClasse(rs.getString("classe"));
                veic.setAlugado(rs.getString("alugado"));

            } else {
                veic = null;
            }
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            veic = null;

        }
        return veic;
    }

    public Veiculo pegaCarro(String marca) {
        Veiculo veiculo = new Veiculo();
        //boolean votou = false;
        String acessos;
        String sql;
        try {
            Connection con = Conecta.getConexao();

            sql = "SELECT * FROM veiculos WHERE marca= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, marca);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                //rs.getString("nome");
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setPreco(rs.getFloat("preco"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setPortas(rs.getString("portas"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setAno(rs.getString("ano"));
                veiculo.setCategoria(rs.getString("categoria"));
                veiculo.setClasse(rs.getString("classe"));
                veiculo.setAlugado(rs.getString("alugado"));

            } else {
                ps.close();
                return veiculo;
            }

            con.close();
        } catch (SQLException e) {

        }
        return veiculo;

    }

    public List<Veiculo> pegaCarrosMarca(Veiculo marca, Veiculo classe, Veiculo nome) {
        List<Veiculo> veiculos = new ArrayList<>();
        Veiculo umVeiculo;
        Veiculo veiculo = new Veiculo();
        //boolean votou = false;
        String acessos;
        String sql;
        try {
            Connection con = Conecta.getConexao();

            sql = "SELECT * FROM veiculos WHERE marca=? or classe=? or nome=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, marca.getMarca());
            ps.setString(2, classe.getClasse());
            ps.setString(3, marca.getNome());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DefaultTableModel model = new DefaultTableModel();

                umVeiculo = new Veiculo();
                //rs.getString("nome");
                umVeiculo.setMarca(rs.getString("marca"));
                umVeiculo.setNome(rs.getString("nome"));
                umVeiculo.setPlaca(rs.getString("placa"));
                umVeiculo.setPreco(rs.getFloat("preco"));
                umVeiculo.setCor(rs.getString("cor"));
                umVeiculo.setPortas(rs.getString("portas"));
                umVeiculo.setPlaca(rs.getString("placa"));
                umVeiculo.setAno(rs.getString("ano"));
                umVeiculo.setCategoria(rs.getString("categoria"));
                umVeiculo.setClasse(rs.getString("classe"));
                umVeiculo.setAlugado(rs.getString("alugado"));
                veiculos.add(umVeiculo);

            }
            ps.close();
            con.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("" + e);

        }
        return veiculos;
    }

    public String updateAlugado(Veiculo veiculo) {   // usar no alugar
        String resp = "";

        try {

            Connection con = Conecta.getConexao();
            String sql = " UPDATE veiculos SET alugado='S' WHERE placa=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, veiculo.getPlaca());

            ps.executeUpdate();

            ps.close();
            con.close();
            resp = "OK";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }

    public String alterarVeiculo(Veiculo veiculo) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            String sql = "UPDATE veiculos SET marca=?, nome=?, cor=?, portas=?, ano=?, preco=?, categoria=?, classe=? WHERE placa=? ";

            PreparedStatement ps = con.prepareStatement(sql);
            //  classse marca cor ano placa categoria alugado portas preço

            ps.setString(1, veiculo.getMarca());
            ps.setString(2, veiculo.getNome());
            ps.setString(3, veiculo.getCor());
            ps.setString(4, veiculo.getPortas());
            ps.setString(5, veiculo.getAno());
            ps.setFloat(6, veiculo.getPreco());
            ps.setString(7, veiculo.getCategoria());
            ps.setString(8, veiculo.getClasse());
            ps.setString(9, veiculo.getPlaca());

            ps.execute();
            resp = "OK";

        } catch (Exception e) {
            resp = "ERRO: " + e.toString();
        }

        return resp;
    }

}

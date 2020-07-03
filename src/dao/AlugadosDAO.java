package dao;

import classes.Alugados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Util;
 
public class AlugadosDAO {
    

    /**
     * Metodo retorna tudo ou especifico dos alugados
     *
     * @author Flavio Ever
     * @param placa placa do carro
     * @param cpf cpf do cliente
     * @return String resultado da remocao
     * @since 10/05/2020
     */
    public List<Alugados> index(String placa, String cpf) {
        List<Alugados> ToDoList = new ArrayList<>();
        
        Util util = new Util();
        // Se houver algo então usar condição;
        String wherePlaca = placa.equals("") ? "" : "WHERE placa LIKE ?";
        String whereCpf = cpf.equals("") ? "" : "WHERE cpf = ?";

        try {

            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM alugados_view " + wherePlaca + whereCpf + ";";
            PreparedStatement ps = con.prepareStatement(sql);
            
            if (!placa.equals("")) {
                ps.setString(1, "%" + placa + "%");
            }

            if (!cpf.equals("")) {
                ps.setString(1, util.parserCpf(cpf));
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alugados alugados = new Alugados();

                // All
                alugados.setPlaca(rs.getString("placa"));
                alugados.setMarca(rs.getString("marca"));
                alugados.setModelo(rs.getString("modelo"));
                alugados.setPrecoTotal(Float.parseFloat(rs.getString("preco_total")));
                alugados.setDataAluguel(util.dbParserDataPtBr(rs.getString("data_aluguel")));
                alugados.setDataRetorno(util.dbParserDataPtBr(rs.getString("data_retorno")));
                alugados.setCpf(rs.getString("cpf"));                
                alugados.setNome(rs.getString("nome"));

                // Cria lista
                ToDoList.add(alugados);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return ToDoList;
    }

    /**
     * Metodo remove o alugado a partir da chave primaria (placa)
     *
     * @author Flavio Ever
     * @param placa chave primaria
     * @return String resultado da remocao
     * @since 10/05/2020
     */
    public String remove(String placa) {
        String resp = "";

        try {
            Connection conn = Conecta.getConexao();

            // Estrutura objeto
            PreparedStatement psmtIn = conn.prepareStatement("DELETE FROM alugados WHERE veiculo_placa=?");

            // Primary Key
            psmtIn.setString(1, placa);

            psmtIn.execute();
            resp = "ok";

            // Fecha possíveis conexões
            psmtIn.close();
            conn.close();
        } catch (Exception e) {
            resp = e.toString();
        }

        return resp;
    }
}

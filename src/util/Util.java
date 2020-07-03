package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    /**
     * REGEX que remove os caracteres especiais do CPF
     *
     * @author Flavio Ever
     * @param cpf cpf do cliente
     * @return Boolean
     * @since 10/05/2020
     */
    public String parserCpf(String cpf) {
        return cpf.replaceAll("[.-]", "");
    }

    
    /**
     * REGEX que remove os caracteres especiais do CELULAR
     *
     * @author Flavio Ever
     * @param celular celular do cliente
     * @return Boolean
     * @since 10/05/2020
     */
    public String parserCelular(String celular) {
        return celular.replaceAll("[(/)/-]", "");
    }
    

    /**
     * REGEX que valida CPF
     *
     * @author Flavio Ever
     * @param cpf cpf do cliente
     * @return Boolean
     * @since 10/05/2020
     */
    public boolean cpfIsValid(String cpf) {
        final String CPF = "^(\\d{3}).(\\d{3}).(\\d{3})-(\\d{2})$" ;
        return cpf.matches(CPF);
    }
    
    /**
     * REGEX que valida a estrutura da data passada
     *
     * @author Flavio Ever
     * @param date data
     * @return Boolean se a data é valida ou não
     * @since 10/05/2020
     */
    public boolean dateIsValid(String date) {
        final String DATE = "^(?=\\d{2}([-.,\\/])\\d{2}\\1\\d{4}$)(?:0[1-9]|1"
                + "\\d|[2][0-8]|29(?!.02.(?!(?!(?:[02468][1-35-79]|[13579][0-13-57-9])00)\\d{2}"
                + "(?:[02468][048]|[13579][26])))|30(?!.02)|31(?=.(?:0[13578]|10|12))).(?:0[1-9]|1[012]).\\d{4}$";

        return date.matches(DATE);
    }

    /**
     * Faz a conversão da data dd/mm/yyyy em yyyy-mm-dd
     *
     * @author Flavio Ever
     * @param data data do todo
     * @return String data formatada no padrao default
     * @throws java.text.ParseException excessao
     * @since 10/05/2020
     */
    public String dbParserData(String data) throws ParseException {
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dt.parse(data);

        SimpleDateFormat dtp = new SimpleDateFormat("yyyy-MM-dd");
        return dtp.format(date);
    }

    /**
     * Faz a conversão da data yyyy-mm-dd em dd/mm/yyyy
     *
     * @author Flavio Ever
     * @param data data do todo
     * @return String data formatada no padrao ptBr
     * @throws java.text.ParseException excessao
     * @since 10/05/2020
     */
    public String dbParserDataPtBr(String data) throws ParseException {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dt.parse(data);

        SimpleDateFormat dtp = new SimpleDateFormat("dd/MM/yyyy");
        return dtp.format(date);
    }
}

package models;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Create extends dbConection{
    public void create(String nome, int idade, String foto, int categoria){

        String sql = "INSERT INTO programadores(nome, foto, idade, id_categoria) VALUES(?,?,?,?) ";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = createConnectionToMySql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1,nome);
            pstm.setString(2, foto);
            pstm.setInt(3, idade);
            pstm.setInt(4, categoria);

            pstm.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (pstm !=null){
                    pstm.close();
                }

                if (conn != null){
                    conn.close();
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

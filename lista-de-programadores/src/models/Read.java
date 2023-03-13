package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Read extends dbConection {
    public void mostrarProgramador(int id){
        String sql = "SELECT * FROM programadores where id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = createConnectionToMySql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1,id);

            rset = pstm.executeQuery();

            pstm.execute();

            System.out.println(rset.getString("nome"));
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

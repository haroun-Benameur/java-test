package IHM;

import database.MyConnection;

import java.sql.*;

public class FormationDOA implements FormationDAOCRUD{
    Connection con = null;
    Statement st = null;
    FormationDOA(String url, String username, String password){
        this.con = MyConnection.getConnection(url, username, password);
        try {
            st = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int insertFormation(String Titre, Date date, String lieu, int id, boolean cert) {
        String sql1 = "INSERT INTO formation VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql1);
            ps.setInt(1, id);
            ps.setString(2, Titre);
            ps.setString(3, lieu);
            ps.setDate(4, date);
            ps.setBoolean(5,cert);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("erreur sql "+ e.getMessage());
            return 0;
        }
    }

    @Override
    public int modifFormation(String Titre, Date date, String lieu, int id, boolean cert) {
        String sql = "UPDATE ETUDIANT SET idF=?,titre=?,lieu=?, dateF=?,certif=?;";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, Titre);
            ps.setString(3, lieu);
            ps.setDate(4,date);
            ps.setBoolean(5, cert);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error sql : "+e.getMessage());
            return 0;
        }
    }

    @Override
    public int suprimFormation(int reference) {
        return 0;
    }

    @Override
    public void afficheALL(String req) {

    }
}

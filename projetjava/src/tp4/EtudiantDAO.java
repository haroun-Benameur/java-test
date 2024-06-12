package tp4;
import java.sql.*;

public class EtudiantDAO implements EtudiantDAOCRUD{
    Connection con = null;
    Statement st = null;
    EtudiantDAO(String url, String username, String password){
        this.con = MyConnection.getConnection(url, username, password);
        try {
            st = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insertEtudiant(String nom, String prenom, int Netd, double moyenne) {
        return 0;
    }

    @Override
    public int modifEtudiant(String nom, String prenom, int Netd, double moyenne) {
        return 0;
    }

    @Override
    public int suprimEtudiant(int cin) {
        return 0;
    }

    ResultSet selection(String req){
        try{
            PreparedStatement ps = con.prepareStatement(req);
            return ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Erreur sql + "+ e.getMessage());
            return null;
        }
    }
    void afficheResultSet(ResultSet rs){
        try {
            while(rs.next()){
                String nom = rs.getString(1);
                String prenom = rs.getString(2);
                int cin = rs.getInt(3);
                double moyenne = rs.getDouble(4);
                System.out.println("Nom: "+nom+" Prénom: "+prenom+ " cin: "+cin+ " moyenne: "+ moyenne);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void afficheALL(String req) {
        afficheResultSet(selection(req));
    }
}

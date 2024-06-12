package IHM;

import java.sql.Date;

public interface FormationDAOCRUD {
    public int insertFormation(String Titre, Date date, String lieu,int id,boolean cert);
    public int modifFormation(String Titre, Date date, String lieu,int id,boolean cert);
    public int suprimFormation(int reference);
    public void afficheALL(String req);
}

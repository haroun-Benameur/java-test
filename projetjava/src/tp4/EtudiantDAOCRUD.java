package tp4;



public interface EtudiantDAOCRUD {
    public int insertEtudiant(String nom,String prenom,int Netd,double moyenne);
    public int modifEtudiant(String nom,String prenom,int Netd,double moyenne);
    public int suprimEtudiant(int cin);
    public void afficheALL(String req);

}

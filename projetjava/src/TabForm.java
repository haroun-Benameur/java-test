public class TabForm {
    public Formulaire f;
    public Profil p;
    TabForm(String nom, String prenom, String pseudo){
        p = new Profil(nom, prenom, pseudo);
        f = new Formulaire(p);
    }
}

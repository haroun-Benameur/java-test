package IHM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principale extends JFrame {
    JMenuBar menuBar;
    JMenu formationMenu;
    JMenu etudiantMenu;
    JMenu enseignantMenu;
    JDesktopPane desktop;
    JMenuItem ajouterFormation;
    JMenuItem rechercherFormation;
    JMenuItem afficherFormation;
    JMenuItem ajouterEtudiant;
    JMenuItem rechercherEtudiant;
    JMenuItem afficherEtudiant;
    JMenuItem ajouterEnseignant;
    JMenuItem rechercherEnseignant;
    JMenuItem afficherEnseignant;

    public Principale(){
        desktop = new JDesktopPane();
        this.setTitle("TP java");
        this.setSize(1500,1500);
        this.add(desktop);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuBar = new JMenuBar();
        formationMenu = new JMenu("Formation");
        etudiantMenu = new JMenu("Etudiant");
        enseignantMenu = new JMenu("Enseignant");

        ajouterFormation = new JMenuItem("Ajouter");
        rechercherFormation = new JMenuItem("Rechercher");
        afficherFormation = new JMenuItem("Afficher");
        ajouterEtudiant = new JMenuItem("Ajouter");
        rechercherEtudiant = new JMenuItem("Rechercher");
        afficherEtudiant = new JMenuItem("Afficher");
        ajouterEnseignant = new JMenuItem("Ajouter");
        rechercherEnseignant = new JMenuItem("Rechercher");
        afficherEnseignant = new JMenuItem("Afficher");

        formationMenu.add(ajouterFormation);
        formationMenu.add(rechercherFormation);
        formationMenu.add(afficherFormation);
        etudiantMenu.add(ajouterEtudiant);
        etudiantMenu.add(rechercherEtudiant);
        etudiantMenu.add(afficherEtudiant);
        enseignantMenu.add(ajouterEnseignant);
        enseignantMenu.add(rechercherEnseignant);
        enseignantMenu.add(afficherEnseignant);
        menuBar.add(formationMenu);
        menuBar.add(etudiantMenu);
        menuBar.add(enseignantMenu);
        this.setJMenuBar(menuBar);
        this.setVisible(true);

        ajouterFormation.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        IHMAjout i=new IHMAjout();
                    }
                }
        );
    }

    public static void main(String[] args){
        Principale p = new Principale();
    }
}


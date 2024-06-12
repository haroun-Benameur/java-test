package database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class GestionEtudiant extends JFrame {

    JTextField nomField,prenomField,cinField,Moyenne;
    JLabel nomFieldlabel,prenomFieldlabel,cinFieldlabel,Moyennelabel;
    JButton valider;
    JTable jtetudiant;
    MytableModel Model;
    EtudiantDAO dao=new EtudiantDAO(Config.url,Config.username,Config.password);
    public GestionEtudiant(){
        this.setTitle("Gestion de profile");
        this.setSize(1000, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(true);
        JPanel panel = new JPanel();
        this.add(panel, BorderLayout.NORTH);
        nomFieldlabel = new JLabel("Nom");
        nomField = new JTextField(15);

        prenomFieldlabel = new JLabel("prenom");
        prenomField = new JTextField(15);

        cinFieldlabel = new JLabel("Cin");
        Moyenne = new JTextField(15);
        Moyennelabel = new JLabel("Moyenne");
        cinField = new JTextField(15);
        nomField.setName("Nom");
        prenomField.setName("Prenom");
        cinField.setName("Cin");
        Moyenne.setName("Moyenne");
        valider = new JButton("valider");
        panel.add(nomFieldlabel);
        panel.add(nomField);
        panel.add(prenomFieldlabel);
        panel.add(prenomField);
        panel.add(cinFieldlabel);
        panel.add(cinField);
        panel.add(Moyennelabel);
        panel.add(Moyenne);
        panel.add(valider);

        valider.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
            String nom= nomField.getText();
            String prenom=prenomField.getText();
            int cin= Integer.parseInt(cinField.getText());  ;
            double moyenne=Double.parseDouble(Moyenne.getText()) ;
                    Model.insertEtudiant(nom,prenom,cin,moyenne);
                    }}
        );

        jtetudiant=new JTable();
        String req="Select * from etudiant";

        ResultSet rs= dao.selection(req);
        Model=new MytableModel(rs,dao);
        jtetudiant.setModel(Model);

       this.add(new JScrollPane(jtetudiant));

        this.setVisible(true);
    }



}

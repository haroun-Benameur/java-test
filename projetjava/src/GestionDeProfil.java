import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GestionDeProfil extends JInternalFrame implements ActionListener {
    ArrayList<Profil> data = new ArrayList<>();
    JTextField nomField,prenomField,pseudoField;
    JSplitPane jsp;
    JList jl;
    DefaultListModel model;
    JTabbedPane jtp;
    JButton valider;
    JLabel helpLabel;
    ArrayList<TabForm> modelTab= new ArrayList<TabForm>();
    public GestionDeProfil() {
        this.setTitle("Gestion de profile");
        this.setSize(1000, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(true);
        this.setClosable(true);
        this.setMaximizable(true);
        this.setIconifiable(true);
        JPanel panel = new JPanel();
        this.add(panel,BorderLayout.NORTH);
        JLabel nom = new JLabel("Nom");
        nomField = new JTextField(15);

        JLabel prenom = new JLabel("prenom");
        prenomField = new JTextField(15);

        JLabel pseudo = new JLabel("pseudo");
        pseudoField = new JTextField(15);

        nomField.setName("Nom");
        prenomField.setName("Prenom");
        pseudoField.setName("Pseudo");

        nomField.setText("saisir le nom");
        prenomField.setText("saisir le prenom");
        pseudoField.setText("saisir le pseudo");
        nomField.addFocusListener(new EcouteurFocus(this));
        prenomField.addFocusListener(new EcouteurFocus(this));
        pseudoField.addFocusListener(new EcouteurFocus(this));


        valider = new JButton("valider");

        panel.add(nom);
        panel.add(nomField);
        panel.add(prenom);
        panel.add(prenomField);
        panel.add(pseudo);
        panel.add(pseudoField);
        panel.add(valider);

        helpLabel = new JLabel("");
        this.add(helpLabel,BorderLayout.SOUTH);

        jsp = new JSplitPane();
        this.add(jsp,BorderLayout.CENTER);
        jl = new JList<>();
        model = new DefaultListModel<>();


        jl.setModel(model);
        jl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    String pseudoCourant = list.getSelectedValue().toString();
                    for(TabForm tf : modelTab){
                        if(tf.p.getPseudo().equals(pseudoCourant)){
                            jtp.addTab(pseudoCourant, tf.f);
                            //navigate to that tab
                            for(int i = 0; i < jtp.getTabCount(); i++) {
                                if (jtp.getTitleAt(i).equals(pseudoCourant)) {
                                    jtp.setSelectedIndex(i);
                                }
                            }
                            return;
                        }
                    }
                } else if (evt.getButton()==MouseEvent.BUTTON3) {

                    JPopupMenu popupMenu = new JPopupMenu();
                    JMenuItem supprimer = new JMenuItem("Supprimer");
                    JMenuItem modifier = new JMenuItem("Modifier");
                    JMenuItem supprimerTout = new JMenuItem("Supprimer tout");
                    popupMenu.add(modifier);
                    popupMenu.add(supprimer);
                    popupMenu.add(supprimerTout);
                    // events
                    supprimer.addActionListener((e)->{
                        String pseudoCourant = list.getSelectedValue().toString();
                        for(int i = 0; i < modelTab.size(); i++){
                            if (modelTab.get(i).p.getPseudo().equals(pseudoCourant)) {
                                modelTab.remove(modelTab.get(i));
                                model.removeElement(pseudoCourant);
                                for(int j = 0; j < jtp.getTabCount(); j++) {
                                    if (jtp.getTitleAt(j).equals(pseudoCourant)) {
                                        jtp.remove(j);
                                    }
                                }
                            }
                        }
                    });
                    supprimerTout.addActionListener((e) ->{
                        modelTab.clear();
                        model.removeAllElements();
                        jtp.removeAll();
                    });
                    modifier.addActionListener((e)->{
                        String pseudoCourant = list.getSelectedValue().toString();
                        String nouveauNom = JOptionPane.showInputDialog(GestionDeProfil.this, "Donner un nouveau nom.","Edition");
                        String nouveauPrenom = JOptionPane.showInputDialog(GestionDeProfil.this, "Donner un nouveau prénom.","Edition");
                        for(TabForm tf: modelTab){
                            if(tf.p.getPseudo().equals(pseudoCourant)){
                                tf.p.setNom(nouveauNom);
                                tf.p.setPrenom(nouveauPrenom);
                            }
                            return;
                        }
                    });

                    popupMenu.show(list, evt.getX(), evt.getY());
                }
            }
        });
        jtp = new JTabbedPane();
        jsp.setLeftComponent(jl);
        jsp.setRightComponent(jtp);

        // ActionListener for the validation button
        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newPseudo = pseudoField.getText();
                // Check if the pseudo already exists
                boolean pseudoExists = false;
                for (Profil profile : data) {
                    if (profile.getPseudo().equals(newPseudo)) {
                        pseudoExists = true;
                        break;
                    }
                }
                if (!pseudoExists) {
                    model.addElement(newPseudo);
                    data.add(new Profil(nomField.getText(), prenomField.getText(), newPseudo));
                }
            }
        });

        LabelColorChanger labelColorChanger = new LabelColorChanger();
        nom.addMouseListener(labelColorChanger);
        prenom.addMouseListener(labelColorChanger);

        HelpLabelUpdater helpLabelUpdater = new HelpLabelUpdater(helpLabel);
        nomField.addMouseListener(helpLabelUpdater);
        prenomField.addMouseListener(helpLabelUpdater);
        pseudoField.addMouseListener(helpLabelUpdater);


        valider.addActionListener(new ValidationButtonListener(this));

        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}




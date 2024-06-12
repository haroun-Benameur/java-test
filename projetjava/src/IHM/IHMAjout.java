package IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IHMAjout extends JFrame {

    private JLabel referenceLabel, titleLabel, dateLabel, lieuLabel, certificationLabel;
    private JTextField referenceField, titleField;
    private JTextField dateTextField, lieuTextField;
    private JCheckBox certificationCheckbox;
    private JButton addButton, cancelButton;

    public IHMAjout() {
        super("Ajout d'une formation");
        initializeComponents();
        createLayout();
        addEventListeners();
    }

    private void initializeComponents() {
        referenceLabel = new JLabel("Référence :");
        titleLabel = new JLabel("Titre :");
        dateLabel = new JLabel("Date :");
        lieuLabel = new JLabel("Lieu :");
        certificationLabel = new JLabel("Certification :");

        referenceField = new JTextField(15);
        titleField = new JTextField(20);

        // Sample data for comboboxes (replace with actual data source)
        dateTextField = new JTextField(15);
        lieuTextField = new JTextField(15);

        certificationCheckbox = new JCheckBox();

        addButton = new JButton("Ajouter");
        cancelButton = new JButton("Annuler");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             String titre= titleField.getText();
             String date=dateTextField.getText();
             String lieu=lieuTextField.getText();
             String ref=referenceField.getText();


                DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                Date datesql= null;
                try {
                    datesql = sdf.parse(date);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }

                boolean cert = certificationCheckbox.isSelected();

                FormationDOA e1 = new FormationDOA(Config.url, Config.username, Config.password);
                e1.insertFormation(titre, new java.sql.Date(datesql.getTime()), lieu, Integer.parseInt(ref), cert);



            }
        });
    }

    private void createLayout() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Add labels and corresponding components
        c.fill = GridBagConstraints.HORIZONTAL;
        addComponent(panel, referenceLabel, c, 0, 0, 1, 1);
        addComponent(panel, referenceField, c, 1, 0, 2, 1);
        addComponent(panel, titleLabel, c, 0, 1, 1, 1);
        addComponent(panel, titleField, c, 1, 1, 2, 1);
        addComponent(panel, dateLabel, c, 0, 2, 1, 1);
        addComponent(panel, dateTextField, c, 1, 2, 2, 1);
        addComponent(panel, lieuLabel, c, 0, 3, 1, 1);
        addComponent(panel, lieuTextField, c, 1, 3, 2, 1);
        addComponent(panel, certificationLabel, c, 0, 4, 1, 1);
        addComponent(panel, certificationCheckbox, c, 1, 4, 1, 1);

        // Add buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);
        c.fill = GridBagConstraints.NONE;
        c.gridy = 5;
        c.gridwidth = 3;
        addComponent(panel, buttonPanel, c, 0, 5, 3, 1);

        getContentPane().add(panel);
        setSize(500,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addComponent(JPanel panel, JComponent component, GridBagConstraints c, int x, int y, int width, int height) {
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.gridheight = height;
        panel.add(component, c);
    }

    private void addEventListeners() {
        // Add functionality to buttons here (e.g., handle form submission and cancellation)
    }

    public static void main(String[] args) {
        new IHMAjout();
    }

}

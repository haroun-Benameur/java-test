import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ValidationButtonListener implements ActionListener {
    private GestionDeProfil parent;

    public ValidationButtonListener(GestionDeProfil parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String newPseudo = parent.pseudoField.getText();
        // Check if the pseudo already exists
        boolean pseudoExists = false;
        for (Profil profile : parent.data) {
            if (profile.getPseudo().equals(newPseudo)) {
                pseudoExists = true;
                break;
            }
        }
        if (!pseudoExists) {
            parent.model.addElement(newPseudo);
            parent.data.add(new Profil(parent.nomField.getText(), parent.prenomField.getText(), newPseudo));
        }
    }
}

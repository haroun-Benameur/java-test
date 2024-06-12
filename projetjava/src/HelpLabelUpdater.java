import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HelpLabelUpdater extends MouseAdapter {
    private JLabel helpLabel;

    public HelpLabelUpdater(JLabel helpLabel) {
        this.helpLabel = helpLabel;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JTextField textField = (JTextField) e.getSource();
        if (textField.getName().equals("Nom")) {
            helpLabel.setText("saisir votre nom");
        } else if (textField.getName().equals("Prenom")) {
            helpLabel.setText("saisir votre prénom");
        } else if (textField.getName().equals("Pseudo")) {
            helpLabel.setText("saisir votre pseudo");
        }
    }


    @Override
    public void mouseExited(MouseEvent e) {
        helpLabel.setText("");
    }


}

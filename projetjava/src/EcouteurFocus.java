import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class EcouteurFocus extends FocusAdapter {
    GestionDeProfil parent;
    EcouteurFocus(GestionDeProfil parent){
        this.parent=parent;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource()==parent.nomField){
            if(parent.nomField.getText().equals("saisir le nom")){
                parent.nomField.setText("");
            }
        }
       else if (e.getSource()==parent.prenomField) {
            if(parent.prenomField.getText().equals("saisir le prenom")){
                parent.prenomField.setText("");
            }
        }
        else{
            if(parent.pseudoField.getText().equals("saisir le pseudo")){
                parent.pseudoField.setText("");
            }
        }

    }

    @Override
    public void focusLost(FocusEvent e) {
        if(e.getSource()==parent.nomField){
        if(parent.nomField.getText().isEmpty()){
            parent.nomField.setText("saisir le nom");
        }}
        else if (e.getSource()==parent.prenomField) {
            if(parent.prenomField.getText().isEmpty()){
                parent.prenomField.setText("saisir le prenom");
        }
    }
        else{
            if(parent.pseudoField.getText().isEmpty()){
                parent.pseudoField.setText("saisir le pseudo");
            }
        }
    }
}

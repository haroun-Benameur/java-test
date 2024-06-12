import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principale extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu menutp ;

    JMenuItem tp1;
    JMenuItem tp2;
    JDesktopPane desktop;
    public Principale(){
        desktop=new JDesktopPane();
        this.setTitle("TP java");
        this.setSize(1500,1500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(desktop);
        menuBar=new JMenuBar();
        menutp = new JMenu("TP");
        tp1=new JMenuItem("TP1");
        tp2=new JMenuItem("TP2");
        menutp.add(tp1);
        menutp.add(tp2);
        menuBar.add(menutp);
        this.setJMenuBar(menuBar);
        tp1.addActionListener(this);
        tp2.addActionListener(this);
        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==tp2){
            GestionDeProfil g= new GestionDeProfil();
            desktop.add(g);
        }
    }
}

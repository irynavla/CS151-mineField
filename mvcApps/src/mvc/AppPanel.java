package mvc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppPanel extends JPanel implements ActionListener {
    protected JPanel controlPanel;
    protected View view;

    public AppPanel() {
        controlPanel = new JPanel();
        setLayout(new BorderLayout());
//        add(view, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args){
        AppPanel app = new AppPanel();
    }
}

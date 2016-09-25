package JavaBook;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Panel1 implements ItemListener{
    public static void main(String[] args) {
        Panel1 gui = new Panel1();
        gui.go();
    }

    private void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        panel.setBackground(Color.darkGray);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton button = new JButton("Shock me!");
        JButton buttonTwo = new JButton("bliss");
        JCheckBox checkBox = new JCheckBox("test");

        panel.add(button);
        panel.add(buttonTwo);
        panel.add(checkBox);
        checkBox.addItemListener(this);
        frame.getContentPane().add(BorderLayout.EAST, panel);

        frame.setSize(250,250);
        frame.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println(1);
    }
}

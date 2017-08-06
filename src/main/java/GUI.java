import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import usd_rub.Pairs;
//import usd_rub.Requests;
//import usd_rub.ToJSON;

@SuppressWarnings("serial")
public class GUI extends JFrame {

    JPanel panel;
    JLabel label;

    // constructor
    GUI(String title) {
        super(title);                      // invoke the JFrame constructor
        setLocation(300, 300);
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        panel = new JPanel();
//        add(panel);
//        buttonTest();
        test();
    }

    private void buttonTest() {
        JButton buttonTest = new JButton("Test");
        panel.add(buttonTest);
        buttonTest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void test() {
        panel = new JPanel();

        // вирівнювання за замовчуванням (CENTER)
        JLabel label1 = new JLabel("Багато левів, ");
        // вирівнювання вліво
        JLabel label2 = new JLabel("тигрів з тигрицями", SwingConstants.LEFT);
        // мітка без тексту, вирівнювання за замовчуванням
        JLabel label3 = new JLabel();
        // створюємо іконку
        Icon icon = new ImageIcon("icon.jpeg");
        // створюємо мітку із зображенням
        JLabel label4 = new JLabel(icon);
        // задаємо текст для label3
        label3.setText("і ведмедів");
        // встановлюємо вирівнювання
        label3.setHorizontalAlignment(SwingConstants.RIGHT);
        //додаємо мітки в панель

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        //додаємо панель у фрейм
        this.add(panel);
    }
}

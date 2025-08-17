import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class logins extends JFrame implements ActionListener {
    JPanel jpp;
    JLabel jl, jl2;
    JTextField jf;
    JPasswordField jp;
    JButton log, out;

    logins() {

        jl = new JLabel();
        jl.setText("  username");
        jl2 = new JLabel();
        jl2.setText("  password");
        jf = new JTextField();
        jp = new JPasswordField();
        log = new JButton("Login");
        out = new JButton("logout");
        jpp = new JPanel(new GridLayout(3, 2));
        jpp.add(jl);

        jpp.add(jf);
        jpp.add(jl2);
        jpp.add(jp);
        jpp.add(log);
        jpp.add(out);

        log.addActionListener(this);
        add(jpp);
        setSize(450, 350);
        setVisible(true);
    }

    public static void main(String args[]) {
        logins l = new logins();
    }

    public void actionPerformed(ActionEvent e) {
        String un = jf.getText();
        String pw = jp.getText();
        if (un.equals("abc") && pw.equals("abc")) {
            log.setText("Valid login");
        } else {
            log.setText("in Valid login");
        }
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginForm(){
        super("Login");
        txtUsername = new JTextField(15);
        txtPassword = new JPasswordField(15);
        txtPassword.setEchoChar('*');
        btnLogin = new JButton("Login");

        JPanel pnMain  = new JPanel();
        pnMain.setSize(this.getSize().width-5, this.getSize().height);
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.PAGE_AXIS));
        pnMain.add(Box.createRigidArea(new Dimension(0,10)));

        JLabel lbHome = new JLabel("Login");
        lbHome.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbHome.setFont(lbHome.getFont().deriveFont(20.0f));
        pnMain.add(lbHome);
        pnMain.add(Box.createRigidArea(new Dimension(0,20)));

        JPanel pnUsername = new JPanel();
        pnUsername.setLayout(new FlowLayout());
        pnUsername.add(new JLabel("Username:"));
        pnUsername.add(txtUsername);
        pnMain.add(pnUsername);

        JPanel pnPassword = new JPanel();
        pnPassword.setLayout(new FlowLayout());
        pnPassword.add(new JLabel("Password:"));
        pnPassword.add(txtPassword);
        pnMain.add(pnPassword);

        pnMain.add(btnLogin);
        pnMain.add(Box.createRigidArea(new Dimension(0,10)));
        btnLogin.addActionListener(this);

        this.setSize(400,200);
        this.setLocation(200, 10);
        this.setContentPane(pnMain);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if((e.getSource() instanceof JButton) && (((JButton)e.getSource()).equals(btnLogin))){
            Staff staff = new Staff();
            staff.setUsername(txtUsername.getText());
            staff.setPassword(txtPassword.getText());

            StaffDAO sd = new StaffDAO();

            if(sd.login(staff)) {
                if (staff.getPosition().equalsIgnoreCase("manager")) {
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "The function of the role " + staff.getPosition() + " is under contruction!");
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Incorrect username and/or password");
            }
        }
    }

    public static void main(String[] args){
        LoginForm myFrame = new LoginForm();
        myFrame.setVisible(true);
    }
}

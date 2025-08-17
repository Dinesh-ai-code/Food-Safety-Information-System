import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception;  
import java.sql.*;

public class Registraion extends JFrame implements ActionListener {
    JPanel newPanel;  
    JButton b1;
    JLabel userLabel, passLabel;  
    final JTextField  textField1, textField2;  
   
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    Registraion()  
    {   setDefaultCloseOperation(javax.swing.  
        WindowConstants.DISPOSE_ON_CLOSE); 
        con = Dbconnection.ConnectionDB();
        userLabel = new JLabel();  
        b1 = new JButton("SignUp");
        userLabel.setText("Username");    
        textField1 = new JTextField(15);     
  
        passLabel = new JLabel();  
        passLabel.setText("Password");       
          
        textField2 = new JPasswordField(15);   
         
        newPanel = new JPanel();
        newPanel.add(userLabel);     
        newPanel.add(textField1);   
        newPanel.add(passLabel);      
        newPanel.add(textField2);   
        newPanel.add(b1) ;
       
        add(newPanel, BorderLayout.CENTER);  
        b1.addActionListener(this);
        setTitle("REGISTRATION FORM");          
    }  
      
    public void actionPerformed(ActionEvent ae)      
    {  
        String userValue = textField1.getText();          
        String passValue = textField2.getText();                 
        String sql = "INSERT INTO Accounts VALUES (?, ?);";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, userValue);
            pst.setString(2, passValue);
            pst.execute();
           
            JOptionPane.showMessageDialog(null,"User created successfully");         
            con.close();
            
        }
        catch(Exception e){
            System.out.println(e);
        }    
    }
}

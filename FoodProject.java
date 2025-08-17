// run project commands
//javac FoodProject.java
//java -classpath ".;sqlite-jdbc-3.20.1.jar" FoodProject
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception;  
import java.sql.*;
  
 
class CreateLoginForm extends JFrame implements ActionListener  
{  
    JPanel newPanel;  
    JButton loginBtn, signUP;
    JLabel userLabel, passLabel;  
    final JTextField  textField1, textField2;  
   
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    CreateLoginForm()  
    {     
        setDefaultCloseOperation(javax.swing.  
        WindowConstants.DISPOSE_ON_CLOSE);  
        con = Dbconnection.ConnectionDB();
        userLabel = new JLabel();  
        loginBtn = new JButton("Login");
        signUP = new JButton("SignUp");
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
        newPanel.add(loginBtn) ;
        newPanel.add(signUP) ;
       
        add(newPanel, BorderLayout.CENTER);  
        loginBtn.addActionListener(this);
        signUP.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent ae)      
            {
                Registraion reg = new Registraion();
                reg.setSize(600,500);  
                reg.setVisible(true);
            } 
            });
        setTitle("LOGIN FORM");          
    }  
    
    public void actionPerformed(ActionEvent ae)      
    {  
        String userValue = textField1.getText();          
        String passValue = textField2.getText();                 
        String sql = "SELECT * from Accounts WHERE userName = ?1 AND password = ?2;";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, userValue);
            pst.setString(2, passValue);
            rs = pst.executeQuery();
            if(rs.next()){
                FoodDetails page = new FoodDetails();                  
            con.close();
            }
            else{  
                JOptionPane.showMessageDialog(null,"Please enter valid username and password");
            }
        }
        catch(Exception e){

        }    
    }  
}  
public class FoodProject {
    public static void main(String[] args) {        
        try  
        {  
            CreateLoginForm form = new CreateLoginForm();  
            form.setSize(500,500);  
            form.setVisible(true);   
        }  
        catch(Exception e)  
        {     
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
    }
  }
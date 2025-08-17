import javax.swing.*;
import java.awt.event.*; 
import java.lang.Exception;  
import java.sql.*;  

public class FoodDetails extends JFrame  
{
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    JFrame f;    
    FoodDetails(){  
         setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);   
        f=new JFrame("Food Items");   
        final JLabel label = new JLabel();          
        final JLabel labelEmail = new JLabel();          
        label.setSize(400,100);  
        label.setText("select the food items");
        JButton b=new JButton("Show");  
        b.setBounds(200,100,75,20);  
        labelEmail.setText("If you want suggest any item, Please mail to server adminstrator_9920004387@klu.ac.in");
        JComboBox cb = new JComboBox();  
        String sql = "SELECT foodName FROM FoodDetails;";
        try{
            con = Dbconnection.ConnectionDB();
            pst = con.prepareStatement(sql);            
            rs = pst.executeQuery();
            while(rs.next()){
                cb.addItem(rs.getString(1));
            }       
            con.close();     
        }
        catch(Exception err){

        }           
        cb.setBounds(50, 100,90,20); 
        labelEmail.setBounds(0, 250, 600, 100);   
        f.add(cb); f.add(label); f.add(b);f.add(labelEmail);    
        f.setLayout(null);    
        f.setSize(600,400);    
        f.setVisible(true);       
        b.addActionListener(new ActionListener() {  
        public void actionPerformed(ActionEvent e) { 
            String sql = "SELECT foodName, adultrants,test,harmful FROM FoodDetails WHERE foodName = ?1;";
            try{
                con = Dbconnection.ConnectionDB();
                pst = con.prepareStatement(sql);   
                String passValue = ""+cb.getItemAt(cb.getSelectedIndex());
                pst.setString(1, passValue);         
                rs = pst.executeQuery();
                if(rs.next()){                                   
                    String foodDesc = "<html>Name: " + rs.getString(1)+"<br/><br/>Adultrants: "+rs.getString(2)+"<br/><br/>Test: "+rs.getString(3)+"<br/><br/>Harmful Effects: "+rs.getString(4)+"<html>";
                    FoddDetailsData page = new FoddDetailsData();  
              
                    page.setVisible(true);  
                    
                    JLabel wel_label = new JLabel(foodDesc);  
                    page.getContentPane().add(wel_label);
                }    
                con.close();        
            }
            catch(Exception exp){
                System.out.println(exp);
            }             
            }  
        });           
    }
}
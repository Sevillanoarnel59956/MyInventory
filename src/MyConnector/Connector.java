
package MyConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;

public class Connector {
    
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            return (Connection)java.sql.DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/productinformation?serverTimezone=UTC","root", "root");
        }catch(SQLException e){
          
          e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    public void closeConnection(Connection connection){
        try{
            if (connection != null &&  ! connection.isClosed()) {
                connection.close();
            }
        }catch(Exception e){
       }
    }
    
    public static void main(String[] args) {
        Connector connector = new Connector();
        Connection connection = connector.getConnection();

        if (connection != null) {
            System.out.println("Connection successful!");
        } else {
            System.out.println("Failed to establish a connection.");
        }
        connector.closeConnection(connection);
    }
 
}

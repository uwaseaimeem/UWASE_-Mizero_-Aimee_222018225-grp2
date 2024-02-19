package Myentity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Visitor {
	 private int id;
	    private String VName;
	    private String location;
	    private String Gender;
	    private String Email;
	    private String PhoneNumber;
	    private String Site_id;
	    public Visitor(int id,String name,String location,String Gender,String Email,String PhoneNumber,String Site_id ) {
	    
	    	super();
	    	this.id=id;
	    	this.VName=name;
	    	this.location=location;
	    	this.Gender=Gender;
	    	this.Email=Email;
	    	this.PhoneNumber=PhoneNumber;
	    	this.Site_id=Site_id;
	    	
	    }
	
		
		public Visitor() {
			// TODO Auto-generated constructor stub
		}


		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getVName() {
			return VName;
		}
		public void setVName(String name) {
			this.VName = name;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getGender() {
			return Gender;
		}
		public void setGender(String gender) {
			Gender = gender;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getPhoneNumber() {
			return PhoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			PhoneNumber = phoneNumber;
		}
		public String getSite_id() {
			return Site_id;
		}
		public void setSite_id(String site_id) {
			Site_id = site_id;
		}

public void makeconnection() {
}
public void insertData() {
// JDBC URL, username, and password of MySQL server
String host = "jdbc:mysql://localhost/aimee_mizero_uwase_ams_grpb";
String user = "222018225";
String password = "222018225";

// SQL query to insert dataFirst_Name
String sql = "INSERT INTO Visitor( VName,Location ,Gender,Email,PhoneNumber,Site_id) VALUES (?,?,?,?,?,?)";
//Visitor_id	VName	Location	Gender	Email	PhoneNumber	Site_id
try (
// Establish the connection
Connection con = DriverManager.getConnection(host, user, password);

// Create a prepared statement
	   PreparedStatement preparedStatement = con.prepareStatement(sql);
    ) {
// Set the values for the prepared statement

preparedStatement.setString(1, this. VName);
preparedStatement.setString(2, this. location);
preparedStatement.setString(3, this. Gender);
preparedStatement.setString(4, this. Email);
preparedStatement.setString(5, this. PhoneNumber);
preparedStatement.setString(6, this. Site_id);
// Execute the query
int rowsAffected = preparedStatement.executeUpdate();

// Check the result
if (rowsAffected > 0) {
	System.out.println("Data inserted sucessfully");
    JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
} else {
    System.out.println("Failed to insert data.");
    JOptionPane.showMessageDialog(null, "Failed to insert data.!","After insert",JOptionPane.ERROR_MESSAGE);

}

} catch (SQLException e) {
e.printStackTrace();
}	
}

public static ResultSet viewData() {
      String host = "jdbc:mysql://localhost/aimee_mizero_uwase_ams_grpb";
      String user = "222018225";
      String password = "222018225";

      String sql = "SELECT * FROM Visitor ";

      try {
          Connection con = DriverManager.getConnection(host, user, password);
          PreparedStatement preparedStatement = con.prepareStatement(sql);
          return preparedStatement.executeQuery();
      } catch (SQLException e) {
          e.printStackTrace();
          return null;
      }
  }

       
    
public  void update(int inputid) {
// JDBC URL, username, and password of MySQL server
String url = "jdbc:mysql://localhost/aimee_mizero_uwase_ams_grpb";
String user = "222018225";
String password = "222018225";

// SQL query to update data

String sql = "UPDATE Visitor SET  VName=?,Location=?,Gender=?,Email=?,PhoneNumber=?,Site_id=? WHERE Visitor_id= ?";

try (
// Establish the cone
Connection co = DriverManager.getConnection(url, user, password);

// Create a prepared statement
PreparedStatement Ar= co.prepareStatement(sql);
) {
// Set the new values for the update
 Ar.setString(1, this.getVName());
 Ar.setString(2, this.getLocation());
 Ar.setString(3, this.getGender());
 Ar.setString(4, this.getEmail());
 Ar.setString(5, this.getPhoneNumber());
 Ar.setString(6, this.getSite_id()); // Assuming there is a column named 'id' for the WHERE clause
 
 Ar.setInt(7, inputid);

// Execute the update
int rowsAffected = Ar.executeUpdate();

// Check the result
if (rowsAffected > 0) {
    System.out.println("Data updated successfully!");
    JOptionPane.showMessageDialog(null, "Data updated successfully!","After update",JOptionPane.INFORMATION_MESSAGE);
} else {
    System.out.println("Failed to update data. No matching record found.");
    JOptionPane.showMessageDialog(null, "Failed to update data!","After update",JOptionPane.INFORMATION_MESSAGE);
}

} catch (SQLException e) {
e.printStackTrace();
}   
}
public void delete(int inputid) {
// JDBC URL, username, and password of MySQL server
String url = "jdbc:mysql://localhost/aimee_mizero_uwase_ams_grpb";
String user = "222018225";
String password = "222018225";

// SQL query to delete data
String sql = "DELETE FROM  Visitor WHERE Visitor_id = ?";

try (
// Establish the 
Connection co = DriverManager.getConnection(url, user, password);

// Create a prepared statement
PreparedStatement pl = co.prepareStatement(sql);
) {
// Set the value for the WHERE clause
pl.setInt(1, inputid); // Assuming there is a column named 'id' for the WHERE clause

// Execute the delete
int rowsAffected = pl.executeUpdate();

// Check the result
if (rowsAffected > 0) {
    System.out.println("Data deleted successfully!");
    JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
} else {
    System.out.println("Failed to delete data. No matching record found.");
    JOptionPane.showMessageDialog(null, "Failed to delete data!","After delete",JOptionPane.INFORMATION_MESSAGE);
}

} catch (SQLException e) {
e.printStackTrace();
}}}


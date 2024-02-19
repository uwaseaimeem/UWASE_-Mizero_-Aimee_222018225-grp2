package Myentity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Booking {
	 private int id;
	 private String visitor_id;
	 private String SiteName;
	 private String CheckinDate;
	 private String CheckoutDate;
	 private String TotalPrice;
	
	    
	    public Booking(int id, String visitor_id,String SiteName,String CheckinDate,String ChechoutDate,String TotalPrice) {
	    
	    	super();
	    	this.id=id;
	    	this.visitor_id= visitor_id;
	    	this.SiteName=SiteName;
	    	this.CheckinDate=CheckinDate;
	        this.TotalPrice=TotalPrice;
	        
	    }


		public Booking() {
			// TODO Auto-generated constructor stub
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getVisitor_id() {
			return visitor_id;
		}


		public void setVisitor_id(String visitor_id) {
			this.visitor_id = visitor_id;
		}


		public String getSiteName() {
			return SiteName;
		}


		public void setSiteName(String siteName) {
			SiteName = siteName;
		}


		public String getCheckinDate() {
			return CheckinDate;
		}


		public void setCheckinDate(String checkinDate) {
			CheckinDate = checkinDate;
		}


		public String getCheckoutDate() {
			return CheckoutDate;
		}


		public void setCheckoutDate(String checkoutDate) {
			CheckoutDate = checkoutDate;
		}


		public String getTotalPrice() {
			return TotalPrice;
		}


		public void setTotalPrice(String totalPrice) {
			TotalPrice = totalPrice;
		}
	    

public void makeconnection() {
}
public void insertData() {
// JDBC URL, username, and password of MySQL server
String host = "jdbc:mysql://localhost/adventourmanagementsystem";
String user = "root";
String password = "";

// SQL query to insert dataFirst_Name
String sql = "INSERT INTO Booking(SiteName ,visitor_id,CheckinDate ,CheckoutDate,TotalPrice) VALUES (?,?,?,?,?)";
//Booking_id	SiteName	CheckinDate CheckoutDate	TotalPrice	visitor_id	
try (
// Establish the connection
Connection con = DriverManager.getConnection(host, user, password);

// Create a prepared statement
	   PreparedStatement preparedStatement = con.prepareStatement(sql);
    ) {
// Set the values for the prepared statement

preparedStatement.setString(1, this.SiteName);
preparedStatement.setString(2, this.visitor_id);
preparedStatement.setString(3, this.CheckinDate);
preparedStatement.setString(4, this.CheckoutDate);
preparedStatement.setString(5, this.TotalPrice);
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
    String host = "jdbc:mysql://localhost/adventourmanagementsystem";
    String user = "root";
    String password = "";

    String sql = "SELECT * FROM Booking ";

    try {
        Connection con = DriverManager.getConnection(host, user, password);
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        return preparedStatement.executeQuery();
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}

public void update(int inputid) {
// JDBC URL, username, and password of MySQL server
String url = "jdbc:mysql://localhost/adventourmanagementsystem";
String user = "root";
String password = "";

// SQL query to update data

String sql = "UPDATE Booking SET SiteName=?, visitor_id=?,CheckinDate=?, CheckoutDate=?, TotalPrice=? WHERE Booking_id=?";

try (
// Establish the cone
Connection co = DriverManager.getConnection(url, user, password);

// Create a prepared statement
PreparedStatement Bk = co.prepareStatement(sql);
) {
// Set the new values for the update
	Bk.setString(1, this.getSiteName());
	Bk.setString(2, this.getVisitor_id());
	Bk.setString(3, this.getCheckinDate()); // Assuming there is a column named 'id' for the WHERE clause
	Bk.setString(4, this.getCheckoutDate());
	Bk.setString(5, this.getTotalPrice());
 
	Bk.setInt(6, inputid);

// Execute the update
int rowsAffected = Bk.executeUpdate();

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
String url = "jdbc:mysql://localhost/adventourmanagementsystem";
String user = "root";
String password = "";

// SQL query to delete data
String sql = "DELETE FROM  Booking WHERE Booking_id=?";

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

package Myentity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Payment {
	 private int Payment_id;
	 private String Booking_id;
	 private String Amount;
	 private String PaymentDate;
	 private String PaymentMethod;
	
	    
	    public Payment(int  Payment_id, String Booking_id, String Amount,String PaymentDate,String PaymentMethod) {
	    
	    	super();
	    	this.Payment_id= Payment_id;
	    	this.Booking_id= Booking_id;
	    	this.Amount=Amount;
	    	this.PaymentDate=PaymentDate;
	    	this.PaymentMethod=PaymentMethod;
}


		public Payment() {
			// TODO Auto-generated constructor stub
		}


		public int getPayment_id() {
			return Payment_id;
		}


		public void setPayment_id(int payment_id) {
			Payment_id = payment_id;
		}


		public String getBooking_id() {
			return Booking_id;
		}


		public void setBooking_id(String booking_id) {
			Booking_id = booking_id;
		}


		public String getAmount() {
			return Amount;
		}


		public void setAmount(String amount) {
			Amount = amount;
		}


		public String getPaymentDate() {
			return PaymentDate;
		}


		public void setPaymentDate(String paymentDate) {
			PaymentDate = paymentDate;
		}


		public String getPaymentMethod() {
			return PaymentMethod;
		}


		public void setPaymentMethod(String paymentMethod) {
			PaymentMethod = paymentMethod;
		}



public void makeconnection() {
}
public void insertData() {
// JDBC URL, username, and password of MySQL server
String host = "jdbc:mysql://localhost/adventourmanagementsystem";
String user = "root";
String password = "";

// SQL query to insert dataFirst_Name
String sql = "INSERT INTO Payment(Amount ,Booking_id,PaymentDate,PaymentMethod)VALUES(?,?,?,?)";
//Payment_id	Amount	PaymentDate	PaymentMethod	Booking_id	
try (
// Establish the connection
Connection con = DriverManager.getConnection(host, user, password);

// Create a prepared statement
	   PreparedStatement preparedStatement = con.prepareStatement(sql);
    ) {
// Set the values for the prepared statement

preparedStatement.setString(1, this.Amount);
preparedStatement.setString(2, this.Booking_id);
preparedStatement.setString(3, this.PaymentDate);
preparedStatement.setString(4, this.PaymentMethod);
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

    String sql = "SELECT * FROM Payment";

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

String sql = "UPDATE Payment SET Amount=?, Booking_id=?,PaymentDate=?,PaymentMethod=? WHERE Payment_id=?";

try (
// Establish the cone
Connection co = DriverManager.getConnection(url, user, password);

// Create a prepared statement
PreparedStatement  p= co.prepareStatement(sql);
) {
// Set the new values for the update
	p.setString(1, this.getAmount());
	p.setString(2, this.getBooking_id());
	p.setString(3, this.getPaymentDate()); // Assuming there is a column named 'id' for the WHERE clause
	p.setString(4, this.getPaymentMethod());
	
 
	p.setInt(5, inputid);

// Execute the update
int rowsAffected = p.executeUpdate();

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
String sql = "DELETE FROM Payment WHERE Payment_id=?";

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

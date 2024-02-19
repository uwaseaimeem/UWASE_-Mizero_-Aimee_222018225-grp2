package Myentity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Site {
    private int id;
    private String name;
    private String location;
    private String historicalperiod;
    private String description;
    private String preservationstatus;
    
    public Site(int id, String name,String location,String historicalperiod,String description,String preservationstatus ) {
    
    	super();
    	this.id=id;
    	this.name=name;
    	this.location=location;
    	this.historicalperiod=historicalperiod;
    	this.description=description;
    	this.preservationstatus=preservationstatus;
    	
    	
    }
	public Site() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getHistoricalperiod() {
		return historicalperiod;
	}
	public void setHistoricalperiod(String historicalperiod) {
		this.historicalperiod = historicalperiod;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getPreservationstatus() {
		return preservationstatus;
	}

	public void setPreservationstatus(String preservationstatus) {
		this.preservationstatus = preservationstatus;
	}
	  public void makeconnection() {
	  }
	  public void insertData() {
	  // JDBC URL, username, and password of MySQL server
	  String host = "jdbc:mysql://localhost/adventourmanagementsystem";
	  String user = "root";
	  String password = "";

	  // SQL query to insert dataFirst_Name
	  String sql = "INSERT INTO Site(SiteName ,Location,HistoricalPreiod,Description,PreservationStatus) VALUES (?,?,?,?,?)";
//Site_id	SiteName	Location	HistoricalPreiod	Description	PreservationStatus
	  try (
	  // Establish the connection
	  Connection con = DriverManager.getConnection(host, user, password);

	  // Create a prepared statement
	  	   PreparedStatement preparedStatement = con.prepareStatement(sql);
	      ) {
	  // Set the values for the prepared statement

	  preparedStatement.setString(1, this.name);
	  preparedStatement.setString(2, this. location);
	  preparedStatement.setString(3, this. historicalperiod);
	  preparedStatement.setString(4, this. description);
	  preparedStatement.setString(5, this. preservationstatus);
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

	        String sql = "SELECT * FROM site";

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

	  String sql = "UPDATE Site SET SiteName=?, Location=?, HistoricalPreiod=?, Description=?, PreservationStatus=? WHERE Site_id = ?";

	  try (
	  // Establish the cone
	  Connection co = DriverManager.getConnection(url, user, password);

	  // Create a prepared statement
	  PreparedStatement St = co.prepareStatement(sql);
	  ) {
	  // Set the new values for the update
	   St.setString(1, this.getName());
	   St.setString(2, this.getLocation());
	   St.setString(3, this.getHistoricalperiod()); // Assuming there is a column named 'id' for the WHERE clause
	   St.setString(4, this.getDescription());
	   St.setString(5, this.getPreservationstatus());
	   
	   St.setInt(6, inputid);

	  // Execute the update
	  int rowsAffected = St.executeUpdate();

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
	  String sql = "DELETE FROM  Site WHERE Site_id = ?";

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















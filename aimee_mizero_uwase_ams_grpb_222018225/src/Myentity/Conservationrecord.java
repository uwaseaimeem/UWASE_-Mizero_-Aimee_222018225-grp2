package Myentity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conservationrecord {
	 private int Conservationrecord_id;
	 private String conservator;
	 private String ConservationDate;
	 private String TreatmentDescription;
	 private String Artifact_id;
	    
	    public Conservationrecord (int Conservationrecord_id, String conservator,String ConservationDate,String TreatmentDescription,String Artifact_id) {
	    
	    	super();
	    	this.Conservationrecord_id=Conservationrecord_id;
	    	this.conservator=conservator;
	    	this.ConservationDate=ConservationDate;
	    	this.TreatmentDescription=TreatmentDescription;
	    	this.Artifact_id=Artifact_id;
	    }

		public Conservationrecord() {
		
		}

		

		public int getConservationrecord_id() {
			return Conservationrecord_id;
		}

		public void setConservationrecord_id(int conservationrecord_id) {
			Conservationrecord_id = conservationrecord_id;
		}

		public String getConservator() {
			return conservator;
		}

		public void setConservator(String conservator) {
			this.conservator = conservator;
		}

		public String getConservationDate() {
			return ConservationDate;
		}

		public void setConservationDate(String conservationDate) {
			ConservationDate = conservationDate;
		}

		public String getTreatmentDescription() {
			return TreatmentDescription;
		}

		public void setTreatmentDescription(String treatmentDescription) {
			TreatmentDescription = treatmentDescription;
		}

		public String getArtifact_id() {
			return Artifact_id;
		}

		public void setArtifact_id(String artifact_id) {
			Artifact_id = artifact_id;
		}

		public void makeconnection() {
		}
		public void insertData() {
		// JDBC URL, username, and password of MySQL server
		String host = "jdbc:mysql://localhost/adventourmanagementsystem";
		String user = "root";
		String password = "";

		// SQL query to insert dataFirst_Name
		String sql = "INSERT INTO Conservationrecord( Conservator,Conservationdate ,TreatmentDescription,Artifact_id) VALUES (?,?,?,?)";
		//ConservationRecord_id	Conservator ,Conservationdate	TreatmentDescription	Artifact_id	
		try (
		// Establish the connection
		Connection con = DriverManager.getConnection(host, user, password);

		// Create a prepared statement
			   PreparedStatement preparedStatement = con.prepareStatement(sql);
		    ) {
		// Set the values for the prepared statement

		preparedStatement.setString(1, this.conservator);
		preparedStatement.setString(2, this.ConservationDate);
		preparedStatement.setString(3, this.TreatmentDescription);
		preparedStatement.setString(4, this.Artifact_id);

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

		      String sql = "SELECT * FROM Conservationrecord ";

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
        
		String sql = "UPDATE Conservationrecord SET  Conservator=?,Conservationdate=?,TreatmentDescription=?,Artifact_id=?WHERE ConservationRecord_id=?";

		try (
		// Establish the cone
		Connection co = DriverManager.getConnection(url, user, password);

		// Create a prepared statement
		PreparedStatement Cr= co.prepareStatement(sql);
		) {
		// Set the new values for the update
		 Cr.setString(1, this.getConservator());
		 Cr.setString(2, this.getConservationDate());
		 Cr.setString(3, this.getTreatmentDescription());
		 Cr.setString(4, this.getArtifact_id()); // Assuming there is a column named 'id' for the WHERE clause
		 
		 Cr.setInt(5, inputid);

		// Execute the update
		int rowsAffected = Cr.executeUpdate();

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
		String sql = "DELETE FROM  Conservationrecord WHERE ConservationRecord_id = ?";

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

    
	    
	    


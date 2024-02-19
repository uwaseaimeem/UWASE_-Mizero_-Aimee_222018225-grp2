package Myentity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Artifact {
	 private int id;
	 private String name;
	 private String description;
	 private String Artifactdate;
	 private String Orgin;
	 private String Materials;
	 private String CultureSignificance;
	 private String Site_id;
	 
	 public Artifact() {
		 //constr
	 }
	    
	    public Artifact(int id, String name,String description,String Artifactdate,String Orgin,String Materials,String CultureSignificance,String Site_id) {
	    
	    	super();
	    	this.id=id;
	    	this.name=name;
	    	this.description=description;
	    	this.Artifactdate=Artifactdate;	    	
	    	this.Orgin=Orgin;
	    	this.Materials=Materials;
	    	this.CultureSignificance=CultureSignificance;
	    	this.Site_id=Site_id;
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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getArtifactdate() {
			return Artifactdate;
		}

		public void setArtifactdate(String artifactdate) {
			Artifactdate = artifactdate;
		}

		public String getOrgin() {
			return Orgin;
		}

		public void setOrgin(String orgin) {
			Orgin = orgin;
		}

		public String getMaterials() {
			return Materials;
		}

		public void setMaterials(String materials) {
			Materials = materials;
		}

		public String getCultureSignificance() {
			return CultureSignificance;
		}

		public void setCultureSignificance(String cultureSignificance) {
			CultureSignificance = cultureSignificance;
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
		  String host = "jdbc:mysql://localhost/adventourmanagementsystem";
		  String user = "root";
		  String password = "";

		  // SQL query to insert dataFirst_Name
		  String sql = "INSERT INTO Artifact( Name,Description ,Artifactdate,Orgin,Materials,CultureSignificance,Site_id) VALUES (?,?,?,?,?,?,?)";
		 // Artifact_id	Name	Description	Artifactdate	Orgin	Materials	CultureSignificance	Site_id
		  try (
		  // Establish the connection
		  Connection con = DriverManager.getConnection(host, user, password);

		  // Create a prepared statement
		  	   PreparedStatement preparedStatement = con.prepareStatement(sql);
		      ) {
		  // Set the values for the prepared statement

		  preparedStatement.setString(1, this. name);
		  preparedStatement.setString(2, this. description);
		  preparedStatement.setString(3, this. Artifactdate);
		  preparedStatement.setString(4, this. Orgin);
		  preparedStatement.setString(5, this. Materials);
		  preparedStatement.setString(6, this. CultureSignificance);
		  preparedStatement.setString(7, this. Site_id);
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

		        String sql = "SELECT * FROM Artifact";

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

		  String sql = "UPDATE Artifact SET  Name=?, Description=?, Artifactdate=?,Orgin=?,Materials=?,CultureSignificance=?,Site_id=? WHERE Artifact_Id = ?";

		  try (
		  // Establish the cone
		  Connection co = DriverManager.getConnection(url, user, password);

		  // Create a prepared statement
		  PreparedStatement Ar= co.prepareStatement(sql);
		  ) {
		  // Set the new values for the update
		   Ar.setString(1, this.getName());
		   Ar.setString(2, this.getDescription());
		   Ar.setString(3, this.getArtifactdate());
		   Ar.setString(4, this.getOrgin());
		   Ar.setString(5, this.getMaterials());
		   Ar.setString(6, this.getCultureSignificance());
		   Ar.setString(7, this.getSite_id()); // Assuming there is a column named 'id' for the WHERE clause
		   
		   Ar.setInt(8, inputid);

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
		  String url = "jdbc:mysql://localhost/adventourmanagementsystem";
		  String user = "root";
		  String password = "";

		  // SQL query to delete data
		  String sql = "DELETE FROM  Artfact WHERE Artifact_Id = ?";

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





	
	
	
	
	
	
	
	
	


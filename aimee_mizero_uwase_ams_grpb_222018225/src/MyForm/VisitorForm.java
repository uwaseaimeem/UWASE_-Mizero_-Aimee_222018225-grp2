package MyForm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Myentity.Artifact;
import Myentity.Site;
import Myentity.Visitor;

public class VisitorForm implements ActionListener{
        
	JFrame frame;
	JLabel Visitor_id_lb=new JLabel("Visitor_id");
	JLabel Site_id_lb=new JLabel("Site_id");
	JLabel VName_lb=new JLabel("VName");
	JLabel location_lb= new JLabel("location");
	JLabel Gender_lb=new JLabel("Gender");
	JLabel Email_lb=new JLabel("Email");
	JLabel PhoneNumber_lb=new JLabel("Phonenumber");
    
    

	
	JTextField Visitor_id_txf=new JTextField();
	JTextField Site_id_txf=new JTextField();
	JTextField VName_txf=new JTextField();
	JTextField location_txf=new JTextField();
	JTextField Email_txf=new JTextField();
	JTextField PhoneNumber_txf=new JTextField();
	JTextField Gender_txf=new JTextField();
	
	String []gender={"Male", "Female"};
	JComboBox<String> genderBox = new JComboBox<>(gender);
	
	
	JButton insert_btn=new JButton("insert");
	JButton  view_btn=new JButton(" view");
	JButton update_btn=new JButton("update");
	JButton Delete_btn=new JButton("Delete");
	
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);

	Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) ScreenSize.getWidth();
	int H=(int) ScreenSize.getHeight();

	public VisitorForm() {
	    CreateForm();
	    ActionEvent();
	    SetLocationandSize();
	    SetFontforAll();
	    AddComponentToFrame();
	  //genderBox.addActionListener(this);
	}

		private void AddComponentToFrame() {
	    frame.add(Visitor_id_lb);
	    frame.add(Site_id_lb);
	    frame.add(VName_lb);
	    frame.add(location_lb);
	    frame.add(Gender_lb);
	    frame.add(Email_lb);
	    frame.add(PhoneNumber_lb);
	   
	    
	    
	    
	    frame.add(Visitor_id_txf);
	    frame.add(Site_id_txf);
	    frame.add(VName_txf);
	    frame.add(location_txf);
	    frame.add(genderBox);
	    frame.add(Email_txf);
	    frame.add(PhoneNumber_txf); 
	    
	    
	  //Buttons CRUD
	    frame.add(insert_btn);
		frame.add( view_btn);
		frame.add(update_btn);
		frame.add( Delete_btn);   
		frame.add(table);
	}

		private void SetFontforAll() {
		Font font=new Font("Georgia",Font.BOLD,18);
		Visitor_id_lb.setFont(font);
		Site_id_lb.setFont(font);
		VName_lb.setFont(font);
		location_lb.setFont(font);
		Gender_lb.setFont(font);
		Email_lb.setFont(font);
		PhoneNumber_lb.setFont(font);
	
		
	    Visitor_id_txf.setFont(font);
		Site_id_txf.setFont(font);
		VName_txf.setFont(font);
		location_txf.setFont(font);
	    genderBox.setFont(font);
		Email_txf.setFont(font);
		PhoneNumber_txf.setFont(font);
		
	
		//Buttons CRUD
		Font fonti=new Font("courier new",Font.ITALIC,12);
		 insert_btn.setFont(fonti);
		 view_btn.setFont(fonti);
		 update_btn.setFont(fonti);
		 Delete_btn.setFont(fonti);
		
	}

		private void SetLocationandSize() {
		Visitor_id_lb.setBounds(10,10,150,30);
		Site_id_lb.setBounds(10,60,150,30);
		VName_lb.setBounds(10,110,150,30);
		location_lb.setBounds(10,160,150,30);
	    Gender_lb.setBounds(10, 210, 150, 30);
		Email_lb.setBounds(10,260,150,30);
		PhoneNumber_lb.setBounds(10,310,150,30);
		  
		
		Visitor_id_txf.setBounds(220,10,100,30);
		Site_id_txf.setBounds(220,60,100,30);
		VName_txf.setBounds(220,110,100,30);
		location_txf.setBounds(220,160,100,30);
		genderBox.setBounds(220, 210, 100, 30);
		Email_txf.setBounds(220,260,100,30);
		PhoneNumber_txf.setBounds(220,310,100,30);
		 
		//Buttons CRUD
		insert_btn.setBounds(60,390,90,30);
		 view_btn.setBounds(160,390,90,30);
		update_btn.setBounds(260,390,90,30);
		Delete_btn.setBounds(360,390,90,30);
		table.setBounds(500, 10, 600, 250);	
		
	}

		private void CreateForm() {
		frame=new JFrame();
		frame.setTitle("VisitorForm");
		frame.setBounds(0,0,w/2,H/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);

		
		
	}

		private void ActionEvent() {
	     insert_btn.addActionListener(this);
	     view_btn.addActionListener(this);
	     update_btn.addActionListener(this);
	     Delete_btn.addActionListener(this);
	    }
		@Override
		public void actionPerformed(ActionEvent e) {
			Visitor Vs=new Visitor(); 
			if(e.getSource()==insert_btn) {
				
			 	Vs.setSite_id(Site_id_txf.getText());
				Vs.setVName(VName_txf.getText());
				Vs.setLocation(location_txf.getText());
				Vs.setEmail(Email_txf.getText());
				Vs.setPhoneNumber(PhoneNumber_txf.getText());
				String selectedOption = (String) genderBox.getSelectedItem();
				Vs.setGender(selectedOption);
				Vs.insertData();
				
			}
			else if (e.getSource() == view_btn) {
	            model.setColumnCount(0);
	            model.setRowCount(0);
	            model.addColumn("Visitor_id");
	            model.addColumn("Site_id");
	            model.addColumn("VName");
	            model.addColumn("location");
	            model.addColumn("Email");
	            model.addColumn("PhoneNumber");

	            ResultSet resultSet = Visitor.viewData();
	            if (resultSet != null) {
	                try {
	                    while (resultSet.next()) {
	                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
	                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
	                                resultSet.getString(6) });
	                    }
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }}
		    else if (e.getSource()==update_btn) {
				int id=Integer.parseInt(Visitor_id_txf.getText());
				Vs.setSite_id(Site_id_txf.getText());
				Vs.setVName(VName_txf.getText());
				Vs.setLocation(location_txf.getText());
				Vs.setEmail(Email_txf.getText());
				Vs.setPhoneNumber(PhoneNumber_txf.getText());
				Vs.setGender((String)genderBox.getSelectedItem());
				
				
				Vs.update(id);
		    }
		  else {
				int id=Integer.parseInt(Visitor_id_txf.getText());
				Vs.delete(id);}}}

		  
		 public static void main(String[] args) {
		VisitorForm vfc=new VisitorForm();
		System.out.println(vfc);
	}}

	
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Myentity.Artifact;
import Myentity.Booking;

public class BookingForm implements ActionListener {
   
	JFrame frame;
	JLabel Booking_id_lb=new JLabel("Booking_id");
	JLabel SiteName_lb=new JLabel("SiteName");
	JLabel Visitor_id_lb=new JLabel("Visitor_id");
	JLabel CheckinDate_lb=new JLabel("CheckinDate");
	JLabel CheckoutDate_lb= new JLabel("CheckoutDate");
	JLabel TotalPrice_lb=new JLabel("TotalPrice");
	
	

	JTextField Booking_id_txf=new JTextField();
	JTextField SiteName_txf=new JTextField();
	JTextField Visitor_id_txf=new JTextField();
	JTextField CheckinDate_txf=new JTextField();
	JTextField CheckoutDate_txf=new JTextField();
	JTextField TotalPrice_txf=new JTextField();


	JButton insert_btn=new JButton("insert");
	JButton view_btn=new JButton("view");
	JButton update_btn=new JButton("update");
	JButton Delete_btn=new JButton("Delete");

	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);


	Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) ScreenSize.getWidth();
	int H=(int) ScreenSize.getHeight();

	public BookingForm() {
	    CreateForm();
	    ActionEvent();
	    SetLocation();
	    SetFontforAll();
	    AddComponentToFrame();
		
	}

		private void AddComponentToFrame() {
	    frame.add(Booking_id_lb);
	    frame.add(SiteName_lb);
	    frame.add(Visitor_id_lb);
	    frame.add(CheckinDate_lb);
	    frame.add(CheckoutDate_lb);
	    frame.add(TotalPrice_lb);
	   
	    
	    frame.add(Booking_id_txf);
	    frame.add(SiteName_txf);
	    frame.add(Visitor_id_txf);
	    frame.add(CheckinDate_txf);
	    frame.add(CheckoutDate_txf);
	    frame.add(TotalPrice_txf);
	     
	    
	    frame.add(insert_btn);
		frame.add(view_btn);
		frame.add(update_btn);
		frame.add( Delete_btn);   
		frame.add(table);
	}

		private void SetFontforAll() {
		Font font=new Font("Georgia",Font.BOLD,18);
		Booking_id_lb.setFont(font);
		SiteName_lb.setFont(font);
		Visitor_id_lb.setFont(font);
		CheckinDate_lb.setFont(font);
		CheckoutDate_lb.setFont(font);
		TotalPrice_lb.setFont(font);
		
		
		
		Booking_id_txf.setFont(font);
		SiteName_txf.setFont(font);
		Visitor_id_txf.setFont(font);
		CheckinDate_txf.setFont(font);
		CheckoutDate_txf.setFont(font);
		TotalPrice_txf.setFont(font);
		
		
		Font fonti=new Font("courier new",Font.ITALIC,12);
		 insert_btn.setFont(fonti);
		 view_btn.setFont(fonti);
		 update_btn.setFont(fonti);
		 Delete_btn.setFont(fonti);
		
	}

		private void SetLocation() {
		Booking_id_lb.setBounds(10,10,150,30);
		SiteName_lb.setBounds(10,60,150,30);
		Visitor_id_lb.setBounds(10,110,150,30);
		CheckinDate_lb.setBounds(10,160,150,30);
		CheckoutDate_lb.setBounds(10,210,350,30);
		TotalPrice_lb.setBounds(10,260,350,30);
	
		
		
		
		Booking_id_txf.setBounds(220,10,150,30);
		SiteName_txf.setBounds(220,60,150,30);
		Visitor_id_txf.setBounds(220,110,150,30);
		CheckinDate_txf.setBounds(220,160,150,30);
		CheckoutDate_txf.setBounds(220,210,150,30);
		TotalPrice_txf.setBounds(220,260,150,30);
	
		 
		
		insert_btn.setBounds(50,290,90,30);
		view_btn.setBounds(160,290,90,30);
		update_btn.setBounds(260,290,90,30);
		Delete_btn.setBounds(360,290,90,30);
		table.setBounds(500, 10, 600, 250);
		
	}

		private void CreateForm() {
		frame=new JFrame();
		frame.setTitle("BookingForm");
		frame.setBounds(0,0,w/2,H/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.	green);
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
			Booking Bk=new Booking ();
			if(e.getSource()==insert_btn) {
				
				Bk.setVisitor_id(Visitor_id_txf.getText());
				Bk.setSiteName(SiteName_txf.getText());
				Bk.setCheckinDate(CheckinDate_txf.getText());
				Bk.setCheckoutDate(CheckoutDate_txf.getText());
				Bk.setTotalPrice(TotalPrice_txf.getText());
		         
				Bk.insertData();
			    }
			else if (e.getSource() == view_btn) {
	            model.setColumnCount(0);
	            model.setRowCount(0);
	            model.addColumn("Booking_id");
	            model.addColumn("Visitor_id");
	            model.addColumn("SiteName");
	            model.addColumn("CheckinDate");
	            model.addColumn("CheckoutDate");
	            model.addColumn("TotalPrice");
	            ResultSet resultSet =Booking.viewData();
	            if (resultSet != null) {
	                try {
	                    while (resultSet.next()) {
	                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
	                                resultSet.getString(3), resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)});
	                    }
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }}
	            else if (e.getSource()==update_btn) {
				int id=Integer.parseInt(Booking_id_txf.getText());
				
				 Bk.setVisitor_id(Visitor_id_txf.getText());
				 Bk.setSiteName(SiteName_txf.getText());
		         Bk.setCheckinDate(CheckinDate_txf.getText());
		         Bk.setCheckoutDate(CheckoutDate_txf.getText());
		         Bk.setTotalPrice(TotalPrice_txf.getText());
		        
				
				 Bk.update(id);
				}
	            else {
				int  Booking_id=Integer.parseInt(Booking_id_txf.getText());
				Bk.delete(Booking_id);
				}
		}
	      
	public static void main(String[] args) {
	 BookingForm bkf=new BookingForm();
	 System.out.println(bkf);
	}

		}

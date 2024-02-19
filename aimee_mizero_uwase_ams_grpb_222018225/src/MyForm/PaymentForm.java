package MyForm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sound.midi.Soundbank;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Myentity.Artifact;
import Myentity.Booking;
import Myentity.Payment;

public class PaymentForm  implements ActionListener{

	JFrame frame;
	JLabel Payment_id_lb=new JLabel("Payment_id");
	JLabel Booking_id_lb=new JLabel("Booking_id");
	JLabel Amount_lb=new JLabel("Amount");
	JLabel PaymentDate_lb= new JLabel("PaymentDate");
	JLabel PaymentMethod_lb=new JLabel("PaymentMethod");
	
	

	JTextField Payment_id_txf=new JTextField();
	JTextField Booking_id_txf=new JTextField();
	JTextField Amount_txf=new JTextField();
	JTextField PaymentDate_txf=new JTextField();
	JTextField PaymentMethod_txf=new JTextField();

	String []PaymentMethod={"Mpesa", "MobileMoney","Credit card","pay with cash","AirtelMoney","western union","Bank Acount"};
	JComboBox<String> PaymentMethodBox = new JComboBox<>(PaymentMethod);
	

	JButton insert_btn=new JButton("insert");
	JButton view_btn=new JButton("view");
	JButton update_btn=new JButton("update");
	JButton Delete_btn=new JButton("Delete");

	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);

	Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) ScreenSize.getWidth();
	int H=(int) ScreenSize.getHeight();

	public PaymentForm() {
	    CreateForm();
	    ActionEvent();
	    SetLocation();
	    SetFontforAll();
	    AddComponentToFrame();
		
	}

		private void AddComponentToFrame() {
	    frame.add(Payment_id_lb);
	    frame.add(Booking_id_lb);
	    frame.add(Amount_lb);
	    frame.add(PaymentDate_lb);
	    frame.add(PaymentMethod_lb);
	   
	    
	    frame.add(Payment_id_txf);
	    frame.add(Booking_id_txf);
	    frame.add(Amount_txf);
	    frame.add(PaymentDate_txf);
	    frame.add(PaymentMethodBox);
	     
	    
	    frame.add(insert_btn);
		frame.add(view_btn);
		frame.add(update_btn);
		frame.add( Delete_btn);   
		frame.add(table);
	}

		private void SetFontforAll() {
		Font font=new Font("Georgia",Font.BOLD,18);
		Payment_id_lb.setFont(font);
		Booking_id_lb.setFont(font);
		Amount_lb.setFont(font);
		PaymentDate_lb.setFont(font);
		PaymentMethod_lb.setFont(font);
		
		
		
		Payment_id_txf.setFont(font);
		Booking_id_txf.setFont(font);
		Amount_txf.setFont(font);
		PaymentDate_txf.setFont(font);
		PaymentMethodBox.setFont(font);
	
		
		Font fonti=new Font("courier new",Font.ITALIC,12);
		 insert_btn.setFont(fonti);
		 view_btn.setFont(fonti);
		 update_btn.setFont(fonti);
		 Delete_btn.setFont(fonti);
		
	}

		private void SetLocation() {
		Payment_id_lb.setBounds(10,10,150,30);
		Booking_id_lb.setBounds(10,60,150,30);
		Amount_lb.setBounds(10,110,150,30);
		PaymentDate_lb.setBounds(10,160,150,30);
		PaymentMethod_lb.setBounds(10,210,350,30);
	
		
		
		
		Payment_id_txf.setBounds(220,10,150,30);
		Booking_id_txf.setBounds(220,60,150,30);
		Amount_txf.setBounds(220,110,150,30);
		PaymentDate_txf.setBounds(220,160,150,30);
		PaymentMethodBox.setBounds(220,210,150,30);
	
		 
		
		insert_btn.setBounds(50,290,90,30);
		view_btn.setBounds(160,290,90,30);
		update_btn.setBounds(260,290,90,30);
		Delete_btn.setBounds(360,290,90,30);
		table.setBounds(600, 10, 600, 250);	
		
		
	}

		private void CreateForm() {
		frame=new JFrame();
		frame.setTitle("PaymentForm");
		frame.setBounds(0,0,w/2,H/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.cyan);
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
			Payment p=new Payment ();
			if(e.getSource()==insert_btn) {
				
				p.setBooking_id(Booking_id_txf.getText());
				p.setAmount(Amount_txf.getText());
				p.setPaymentDate(PaymentDate_txf.getText());
				String selectedOption = (String) PaymentMethodBox.getSelectedItem();
				p.setPaymentMethod(selectedOption);
				
		         
				p.insertData();
				}
				else if (e.getSource() == view_btn) {
		            model.setColumnCount(0);
		            model.setRowCount(0);
		            model.addColumn("Payment_id");
		            model.addColumn("(Booking_id");
		            model.addColumn("Amount");
		            model.addColumn("PaymentDate");
		       
		            
		            ResultSet resultSet =Payment.viewData();
		            if (resultSet != null) {
		                try {
		                    while (resultSet.next()) {
		                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
		                                resultSet.getString(3), resultSet.getString(4)});
		                    }
		                } catch (SQLException ex) {
		                    ex.printStackTrace();
		                }
		            }}
	            else if (e.getSource()==update_btn) {
				int id=Integer.parseInt(Payment_id_txf.getText());
				
				p.setBooking_id(Booking_id_txf.getText());
				p.setAmount(Amount_txf.getText());
				p.setPaymentDate(PaymentDate_txf.getText());
				p.setPaymentMethod((String)PaymentMethodBox.getSelectedItem());
				
				
				
				 p.update(id);
				}
	            else {
				int  Payment_id=Integer.parseInt(Payment_id_txf.getText());
				
				p.delete(Payment_id);
				}
		}
		
	public static void main(String[] args) {
	 PaymentForm pfv=new PaymentForm();	
	 System.out.println(pfv);
	}

}

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
import Myentity.Conservationrecord;
import Myentity.Site;

public class ConservationrecordForm implements ActionListener {
	
	JFrame frame;
	JLabel Conservationrecord_id_lb=new JLabel("Conservationrecord_id");
	JLabel conservator_lb=new JLabel("conservator");
	JLabel ConservationDate_lb=new JLabel("ConservationDate");
	JLabel TreatmentDescription_lb=new JLabel("TreatmentDescription");
	JLabel Artifact_id_lb= new JLabel("Artifact_id");

	JTextField Conservationrecord_id_txf=new JTextField();
	JTextField conservator_txf=new JTextField();
	JTextField ConservationDate_txf=new JTextField();
	JTextField TreatmentDescription_txf=new JTextField();
	JTextField Artifact_id_txf=new JTextField();

	JButton insert_btn=new JButton("insert");
	JButton view_btn=new JButton("view");
	JButton update_btn=new JButton("update");
	JButton Delete_btn=new JButton("Delete");
	
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);


	Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) ScreenSize.getWidth();
	int H=(int) ScreenSize.getHeight();

	public ConservationrecordForm() {
	    CreateForm();
	    ActionEvent();
	    SetLocation();
	    SetFontforAll();
	    AddComponentToFrame();
		
	}

		private void AddComponentToFrame() {
	    frame.add(Conservationrecord_id_lb);
	    frame.add(conservator_lb);
	    frame.add(ConservationDate_lb);
	    frame.add(TreatmentDescription_lb);
	    frame.add(Artifact_id_lb);
	    
	    frame.add(Conservationrecord_id_txf);
	    frame.add(conservator_txf);
	    frame.add(ConservationDate_txf);
	    frame.add(TreatmentDescription_txf);
	    frame.add(Artifact_id_txf);
	    
	    frame.add(insert_btn);
		frame.add(view_btn);
		frame.add(update_btn);
		frame.add( Delete_btn);   
		frame.add(table);
	}

		private void SetFontforAll() {
		Font font=new Font("Georgia",Font.BOLD,18);
		Conservationrecord_id_lb.setFont(font);
		conservator_lb.setFont(font);
		ConservationDate_lb.setFont(font);
		TreatmentDescription_lb.setFont(font);
		Artifact_id_lb.setFont(font);
		
		
		Conservationrecord_id_txf.setFont(font);
		conservator_txf.setFont(font);
		ConservationDate_txf.setFont(font);
		TreatmentDescription_txf.setFont(font);
		Artifact_id_txf.setFont(font);
		
		Font fonti=new Font("courier new",Font.ITALIC,12);
		 insert_btn.setFont(fonti);
		 view_btn.setFont(fonti);
	 	 update_btn.setFont(fonti);
		 Delete_btn.setFont(fonti);
		
	}

		private void SetLocation() {
	    Conservationrecord_id_lb.setBounds(10,10,150,30);
		conservator_lb.setBounds(10,60,150,30);
		ConservationDate_lb.setBounds(10,110,150,30);
		TreatmentDescription_lb.setBounds(10,160,150,30);
		Artifact_id_lb.setBounds(10,210,250,30);
	
		
		
		Conservationrecord_id_txf.setBounds(280,10,150,30);
		conservator_txf.setBounds(280,60,150,30);
		ConservationDate_txf.setBounds(280,110,150,30);
		TreatmentDescription_txf.setBounds(280,160,150,30);
		Artifact_id_txf.setBounds(280,210,150,30);
		 
		
		insert_btn.setBounds(50,290,85,30);
		view_btn.setBounds(160,290,85,30);
		update_btn.setBounds(260,290,85,30);
		Delete_btn.setBounds(360,290,85,30);
		table.setBounds(600, 10, 600, 250);	
		
	}

		private void CreateForm() {
		frame=new JFrame();
		frame.setTitle("conservationrecordForm");
		frame.setBounds(0,0,w/2,H/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.pink);
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
			Conservationrecord Cr=new Conservationrecord();
			if(e.getSource()==insert_btn) {
				
				 Cr.setArtifact_id(Artifact_id_txf.getText());
				 Cr.setConservator(conservator_txf.getText());
				 Cr.setConservationDate(ConservationDate_txf.getText());
				 Cr.setTreatmentDescription(TreatmentDescription_txf.getText());
				 
				 Cr.insertData();
			    }
			else if (e.getSource() == view_btn) {
	            model.setColumnCount(0);
	            model.setRowCount(0);
	            model.addColumn("Conservationrecord_id");
	            model.addColumn("Artifact_id");
	            model.addColumn("conservator");
	            model.addColumn("ConservationDate");
	            model.addColumn("TreatmentDescription");
	            ResultSet resultSet =Conservationrecord.viewData();
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
				int id=Integer.parseInt(Conservationrecord_id_txf.getText());
				 
				 Cr.setConservator(conservator_txf.getText());
				 Cr.setConservationDate(ConservationDate_txf.getText());
				 Cr.setTreatmentDescription(TreatmentDescription_txf.getText());
				 Cr.setArtifact_id(Artifact_id_txf.getText());
				 
		         
				 Cr.update(id);
				}
	            else {
				int id=Integer.parseInt(Conservationrecord_id_txf.getText());
				Cr.delete(id);}

	            }
	public static void main(String[] args) {
	ConservationrecordForm crf=new ConservationrecordForm();
	             System.out.println(crf);
	}}

	

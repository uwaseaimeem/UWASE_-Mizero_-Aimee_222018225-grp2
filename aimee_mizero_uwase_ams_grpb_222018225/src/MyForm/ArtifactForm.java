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
import Myentity.Site;
public class ArtifactForm implements ActionListener {
	JFrame frame;
	JLabel Artifact_id_lb=new JLabel("Artifact_id");
	JLabel Site_id_lb=new JLabel("Site_id_lb");
	JLabel name_lb=new JLabel("name");
	JLabel description_lb= new JLabel("description");
	JLabel ArtifactDate_lb=new JLabel("Artifactdate");
	JLabel Orgin_lb=new JLabel("Orgin");
	JLabel Materials_lb=new JLabel("Materials");
    JLabel CultureSignificance_lb=new JLabel("CultureSignificance");
    

	
	JTextField Artifact_id_txf=new JTextField();
	JTextField Site_id_txf=new JTextField();
	JTextField name_txf=new JTextField();
	JTextField description_txf=new JTextField();
	JTextField ArtifactDate_txf=new JTextField();
	JTextField Date_txf=new JTextField();
	JTextField Orgin_txf=new JTextField();
	JTextField Materials_txf=new JTextField();
    JTextField CultureSignificance_txf=new JTextField();
	
	
	JButton insert_btn=new JButton("insert");
	JButton view_btn=new JButton("view");
	JButton update_btn=new JButton("update");
	JButton Delete_btn=new JButton("Delete");
	
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);

	Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) ScreenSize.getWidth();
	int H=(int) ScreenSize.getHeight();

	public ArtifactForm() {
	    CreateForm();
	    ActionEvent();
	    SetLocation();
	    SetFontforAll();
	    AddComponentToFrame();
		
	}

		private void AddComponentToFrame() {
	    frame.add(Artifact_id_lb);
	    frame.add(Site_id_lb);
	    frame.add(name_lb);
	    frame.add(description_lb);
	    frame.add(ArtifactDate_lb);
	    frame.add(Orgin_lb);
	    frame.add(Materials_lb);
	    frame.add(CultureSignificance_lb);
	    
	    
	    
	    frame.add(Artifact_id_txf);
	    frame.add(Site_id_txf);
	    frame.add(name_txf);
	    frame.add(description_txf);
	    frame.add(ArtifactDate_txf);
	    frame.add(Orgin_txf);
	    frame.add(Materials_txf); 
	    frame.add(CultureSignificance_txf);
	    
	    
	    frame.add(insert_btn);
		frame.add(view_btn);
		frame.add(update_btn);
		frame.add(Delete_btn);   
		frame.add(table);
	}

		private void SetFontforAll() {
		Font font=new Font("Georgia",Font.BOLD,18);
		Artifact_id_lb.setFont(font);
		Site_id_lb.setFont(font);
		name_lb.setFont(font);
		description_lb.setFont(font);
		ArtifactDate_lb.setFont(font);
		Orgin_lb.setFont(font);
		Materials_lb.setFont(font);
		CultureSignificance_lb.setFont(font);
		
		Artifact_id_txf.setFont(font);
		Site_id_txf.setFont(font);
		name_txf.setFont(font);
		description_txf.setFont(font);
		ArtifactDate_txf.setFont(font);
		Orgin_txf.setFont(font);
		Materials_txf.setFont(font);
		CultureSignificance_txf.setFont(font);
	
	
		Font fonti=new Font("courier new",Font.ITALIC,12);
		 insert_btn.setFont(fonti);
		 view_btn.setFont(fonti);
		 update_btn.setFont(fonti);
		 Delete_btn.setFont(fonti);
		
	}

		private void SetLocation() {
		Artifact_id_lb.setBounds(10,10,150,30);
		Site_id_lb.setBounds(10,60,150,30);
		name_lb.setBounds(10 ,110,150,30);
		description_lb.setBounds(10,160,150,30);
		ArtifactDate_lb.setBounds(10,210,150,30);
		Orgin_lb.setBounds(10,260,150,30);
		Materials_lb.setBounds(10,310,150,30);
		CultureSignificance_lb.setBounds(10,360,250,30);
		
		
		
		Artifact_id_txf.setBounds(260,10,90,30);
		Site_id_txf.setBounds(260,60,90,30);
		name_txf.setBounds(260,110,90,30);
		description_txf.setBounds(260,160,90,30);
		ArtifactDate_txf.setBounds(260,210,90,30);
		Orgin_txf.setBounds(260,260,90,30);
		Materials_txf.setBounds(260,310,90,30);
		CultureSignificance_txf.setBounds(260,360,90,30);
		 
		
		insert_btn.setBounds(50,430,90,30);
		view_btn.setBounds(160,430,90,30);
		update_btn.setBounds(260,430,90,30);
		Delete_btn.setBounds(360,430,90,30);
		table.setBounds(500, 10, 600, 250);	
		
	}

		private void CreateForm() {
		frame=new JFrame();
		frame.setTitle("ArtifactForm");
		frame.setBounds(0,0,w/2,H/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.gray);
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
		Artifact Ar=new Artifact();
		if(e.getSource()==insert_btn) {
			
			 Ar.setSite_id(Site_id_txf.getText());
			 Ar.setName(name_txf.getText());
	         Ar.setDescription(description_txf.getText());
	         Ar.setArtifactdate(ArtifactDate_txf.getText());
	         Ar.setOrgin(Orgin_txf.getText());
	         Ar.setMaterials(Materials_txf.getText());
	         Ar.setCultureSignificance(CultureSignificance_txf.getText());
	         
		     Ar.insertData();
		    }
		else if (e.getSource() == view_btn) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("Artifact_id");
            model.addColumn("Site_id");
            model.addColumn("name");
            model.addColumn("description");
            model.addColumn("ArtifactDate");
            model.addColumn("Orgin");
            model.addColumn("Materials");
            model.addColumn("CultureSignificancs");
            
            ResultSet resultSet =Artifact.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                                resultSet.getString(6), resultSet.getString(7),resultSet.getString(8)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }}
            else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(Artifact_id_txf.getText());
			Ar.setSite_id(Site_id_txf.getText());
			 Ar.setName(name_txf.getText());
	         Ar.setDescription(description_txf.getText());
	         Ar.setArtifactdate(ArtifactDate_txf.getText());
	         Ar.setOrgin(Orgin_txf.getText());
	         Ar.setMaterials(Materials_txf.getText());
	         Ar.setCultureSignificance(CultureSignificance_txf.getText());
			
			 Ar.update(id);
            }
            else {
			int Artifact_id=Integer.parseInt(Artifact_id_txf.getText());
			Ar.delete(Artifact_id);}
		}
		
	

		public static void main(String[] args) {
			ArtifactForm Arti= new ArtifactForm();
		System.out.println(Arti);

}

	}
		


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

import Myentity.Site;


public class SiteForm  implements ActionListener{

JFrame frame;
JLabel site_id_lb=new JLabel("site_id");
JLabel name_lb=new JLabel("name");
JLabel location_lb= new JLabel("location");
JLabel historicalperiod_lb=new JLabel("historicalperiod");
JLabel description_lb=new JLabel("description");
JLabel preservationstatus_lb=new JLabel("preservationstatus");

JTextField site_id_txf=new JTextField();
JTextField name_txf=new JTextField();
JTextField location_txf=new JTextField();
JTextField historicalperiod_txf=new JTextField();
JTextField description_txf=new JTextField();
JTextField preservationstatus_txf=new JTextField();

JButton insert_btn=new JButton("insert");
JButton view_btn=new JButton("view");
JButton update_btn=new JButton("update");
JButton Delete_btn=new JButton("Delete");

DefaultTableModel model = new DefaultTableModel();
JTable table = new JTable(model);




Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
int w=(int) ScreenSize.getWidth();
int H=(int) ScreenSize.getHeight();

public SiteForm() {
    CreateForm();
    ActionEvent();
    SetLocation();
    SetFontforAll();
    AddComponentToFrame();
	
}

	private void AddComponentToFrame() {
    frame.add(site_id_lb);
    frame.add(name_lb);
    frame.add(location_lb);
    frame.add(historicalperiod_lb);
    frame.add(description_lb);
    frame.add(preservationstatus_lb);
    
    frame.add(site_id_txf);
    frame.add(name_txf);
    frame.add(location_txf);
    frame.add(historicalperiod_txf);
    frame.add(description_txf);
    frame.add(preservationstatus_txf); 
    
    frame.add(insert_btn);
	frame.add(view_btn);
	frame.add(update_btn);
	frame.add( Delete_btn);  
	frame.add(table);
	
}

	private void SetFontforAll() {
	Font font=new Font("Georgia",Font.BOLD,18);
	site_id_lb.setFont(font);
	name_lb.setFont(font);
	location_lb.setFont(font);
	historicalperiod_lb.setFont(font);
	description_lb.setFont(font);
	preservationstatus_lb.setFont(font);
	
	
	site_id_txf.setFont(font);
	name_txf.setFont(font);
	location_txf.setFont(font);
	historicalperiod_txf.setFont(font);
	description_txf.setFont(font);
	preservationstatus_txf.setFont(font);
	
	Font fonti=new Font("courier new",Font.ITALIC,12);
	 insert_btn.setFont(fonti);
	 view_btn.setFont(fonti);
	 update_btn.setFont(fonti);
	 Delete_btn.setFont(fonti);
	
}

	private void SetLocation() {
	site_id_lb.setBounds(10,10,150,30);
	name_lb.setBounds(10,60,150,30);
	location_lb.setBounds(10,110,150,30);
	historicalperiod_lb.setBounds(10,160,150,30);
	description_lb.setBounds(10,210,150,30);
	preservationstatus_lb.setBounds(10,260,250,30);
	
	
	
	site_id_txf.setBounds(280,10,130,30);
	name_txf.setBounds(280,60,130,30);
	location_txf.setBounds(280,110,130,30);
	historicalperiod_txf.setBounds(280,160,130,30);
	description_txf.setBounds(280,210,130,30);
	preservationstatus_txf.setBounds(280,260,130,30);
	 
	
	insert_btn.setBounds(50,390,90,30);
	view_btn.setBounds(160,390,90,30);
	update_btn.setBounds(260,390,90,30);
	Delete_btn.setBounds(360,390,90,30);
	table.setBounds(500, 10, 600, 250);
		
	
}

	private void CreateForm() {
	frame=new JFrame();
	frame.setTitle("SiteForm");
	frame.setBounds(0,0,w/2,H/2);
	frame.getContentPane().setLayout(null);
	frame.getContentPane().setBackground(Color.orange);
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
		Site St=new Site();
		if(e.getSource()==insert_btn) {
		     
			 St.setName(name_txf.getText());
	         St.setLocation(location_txf.getText());
	         St.setHistoricalperiod(historicalperiod_txf.getText());
	         St.setDescription(description_txf.getText());
	         St.setPreservationstatus(preservationstatus_txf.getText());
	         
	         
		     St.insertData();
		    }
		else if (e.getSource() == view_btn) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("site_id");
            model.addColumn("name");
            model.addColumn("location");
            model.addColumn("historicalperiod");
            model.addColumn("description");
            model.addColumn("preservationstatus");

            ResultSet resultSet = Site.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                                resultSet.getString(6) });
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } }
            else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(site_id_txf.getText());

			 St.setName(name_txf.getText());
	         St.setLocation(location_txf.getText());
	         St.setHistoricalperiod(historicalperiod_txf.getText());
	         St.setDescription(description_txf.getText());
	         St.setPreservationstatus(preservationstatus_txf.getText());
	         
			St.update(id);
			}
            else {
			int id=Integer.parseInt(site_id_txf.getText());
			St.delete(id);}

            }
	public static void main(String[] args) {
		SiteForm STF= new SiteForm();
	             System.out.println(STF);
   }
}

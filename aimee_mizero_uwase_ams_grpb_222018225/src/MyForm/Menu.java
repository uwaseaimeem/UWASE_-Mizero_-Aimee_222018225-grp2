package MyForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu implements ActionListener {
	JFrame frame;
	JMenu home,  Site, Artifact, Visitor,Conservationrecord, Booking,Payment, more;
	JMenuItem i1, i2, i3, i4, i5, i6, item1, item2,SiteDelete,SiteUpdate,Siteview;
	JMenuItem ArtifactDelete,ArtifactUpdate,Artifactview;
	JMenuItem VisitorDelete,VisitorUpdate,Visitorview;
	JMenuItem ConservationrecordDelete,ConservationrecordeUpdate,Conservationrecordview;
	JMenuItem BookingDelete,BookingUpdate,Bookingview;
	JMenuItem PaymentDelete,PaymentUpdate,Paymentview;
	
	
	
	   public Menu(){
		createWindow();
	}
	private void createWindow() {
		frame = new JFrame("Menu form with main Menu");
		frame.setSize(400, 400);

		JMenuBar mb = new JMenuBar(); // Create a new menu bar
		home = new JMenu("Home");
		Site = new JMenu("Site");
		Artifact= new JMenu("Artifact");
		Visitor= new JMenu("Visitor");
		Conservationrecord = new JMenu("Conservationrecord");
		Booking=new JMenu("Booking");
		Payment=new JMenu("Payment");

		more = new JMenu("More");
		i1 = new JMenuItem("Insert");
		i2 = new JMenuItem("view");
		i3 = new JMenuItem("Update");
		i4 = new JMenuItem("Delete");
		i5 = new JMenuItem("Item 5");
		i6 = new JMenuItem("Item 6");
		more.add(i5);
		more.add(i6);

		home.add(i1);
		home.add(more); // Add the 'more' submenu to the 'home' menu
		
		Siteview = new JMenuItem("view");
		SiteUpdate = new JMenuItem("Update");
		SiteDelete = new JMenuItem("Delete");
		Site.add(Siteview);
		Site.add(SiteUpdate);
		Site.add(SiteDelete);

		Artifactview =new JMenuItem("view");
		ArtifactUpdate =new JMenuItem("Update");
		ArtifactDelete =new JMenuItem("Delete");
		Artifact.add(Artifactview);
		Artifact.add(ArtifactUpdate);
		Artifact.add(ArtifactDelete);
		
		Visitorview =new JMenuItem("view");
		VisitorUpdate =new JMenuItem("Update");
		VisitorDelete =new JMenuItem("Delete");
		Visitor.add(Visitorview);
		Visitor.add(VisitorUpdate);
		Visitor.add(VisitorDelete);
		
		Conservationrecordview =new JMenuItem("view");
		ConservationrecordDelete =new JMenuItem("Update");
		ConservationrecordDelete =new JMenuItem("Delete");
		Conservationrecord.add(Conservationrecordview);
		Conservationrecord.add(ConservationrecordDelete);
		Conservationrecord.add(ConservationrecordDelete);
		
		Bookingview =new JMenuItem("view");
		BookingUpdate =new JMenuItem("Update");
		BookingDelete =new JMenuItem("Delete");
		Booking.add(Bookingview);
		Booking.add(BookingUpdate);
		Booking.add(BookingDelete);
		
		Paymentview =new JMenuItem("view");
		PaymentUpdate =new JMenuItem("Update");
		PaymentDelete =new JMenuItem("Delete");
		Payment.add(Paymentview);
		Payment.add(PaymentUpdate);
		Payment.add(PaymentDelete);
	
		
		
	
		mb.add(home);
		mb.add(Site);
		mb.add(Artifact);
		mb.add(Visitor);
		mb.add(Conservationrecord);
		mb.add(Booking);
		mb.add(Payment);
	
		frame.setJMenuBar(mb);// Set the menu bar to the frame

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		componentsOnFrame();

	}
	private void componentsOnFrame() {
		home = new JMenu("Home");
		Site = new JMenu("Site");
		Artifact = new JMenu("Artifact");
		Visitor = new JMenu("Visitor");
		Conservationrecord =new JMenu("Conservationrecord");
		Booking =new JMenu("Booking");
		Payment=new JMenu("Payment");
		
		
		
		more = new JMenu("More");
		i1 = new JMenuItem("Create");
		i2 = new JMenuItem("Read");
		i3 = new JMenuItem("Update");
		i4 = new JMenuItem("Delete");
		i5 = new JMenuItem("Item 5");
		i6 = new JMenuItem("Item 6");
		more.add(i5);
		more.add(i6);

		home.add(i1);
		home.add(more);
		Site.add(i2);
		Site.add(i3);
		Site.add(i4);
		Artifact.add(i2);
		Artifact.add(i3);
		Artifact.add(i4);
		Visitor.add(i2);
		Visitor.add(i3);
		Visitor.add(i4);
		Conservationrecord.add(i2);
		Conservationrecord.add(i3);
		Conservationrecord.add(i4);
		Booking.add(i2);
		Booking.add(i3);
		Booking.add(i4);
		Payment.add(i2);
		Payment.add(i3);
		Payment.add(i4);
		addactionEvent();

		
		
	}
	private void addactionEvent() {
		Siteview.addActionListener(this);
		Artifactview.addActionListener(this);
		Visitorview.addActionListener(this);
		Conservationrecordview.addActionListener(this);
		Bookingview.addActionListener(this);
		Paymentview.addActionListener(this);
		
		
	}
	public static void main(String[] args) {
		new Menu ();

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==Siteview) {
			SiteForm pf=new SiteForm();
			frame.dispose();
		}else if (e.getSource()==Artifactview) {
			ArtifactForm df=new ArtifactForm();
			frame.dispose();
		}else if (e.getSource()==Visitorview) {
			VisitorForm nf=new VisitorForm();
			frame.dispose();
		}else if (e.getSource()==Conservationrecordview) {
			ConservationrecordForm cf=new ConservationrecordForm();
			frame.dispose();
			}else if (e.getSource()==Bookingview) {
				BookingForm af=new BookingForm();
				frame.dispose();
				}else if (e.getSource()==Paymentview) {
					PaymentForm sf=new PaymentForm();
					frame.dispose();
	}

}
	}

		



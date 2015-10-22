import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class MainWindow {
	private JFrame mainFrame;
	private JPanel mainPanel;
	private JPanel fieldsPanel;
	private JMenuBar menuBar;
	private JMenu addressMenu;
	private JMenuItem save;
	private JMenuItem create;
	private JMenuItem addBuddy;
	private JMenuItem removeBuddy;
	private JMenuItem editBuddy;
	private JTextField nameField;
	private JTextField addressField;
	private JTextField phoneField;
	private JLabel nameLabel;
	private JLabel addressLabel;
	private JLabel phoneLabel;
	private JList listView;
	
	private AddressBook book;
	
	public MainWindow(AddressBook book){
	
		this.book = book;
		
		mainFrame = new JFrame("Address Book");
		mainPanel = new JPanel(new BorderLayout());
		fieldsPanel = new JPanel(new GridLayout(3,2));
		menuBar = new JMenuBar();
		
		nameLabel = new JLabel("Name:");
		addressLabel = new JLabel("Address:");
		phoneLabel = new JLabel("Phone Number:");
		
		nameField = new JTextField();
		addressField = new JTextField();
		phoneField = new JTextField();
		
		listView = new JList<>(book.getListModel());
		
		fieldsPanel.add(nameLabel);
		fieldsPanel.add(nameField);
		fieldsPanel.add(addressLabel);
		fieldsPanel.add(addressField);
		fieldsPanel.add(phoneLabel);
		fieldsPanel.add(phoneField);
		
		
		save = new JMenuItem("Save");
		save.addActionListener(
				al->{this.save();}
		);
		
		create = new JMenuItem("Create");
		create.addActionListener(
				al->{this.create();}
				);
		
		addBuddy = new JMenuItem("Add Buddy");
		addBuddy.addActionListener(
				al->{this.addBuddy();}
				);
		
		removeBuddy = new JMenuItem("Remove Buddy");
		removeBuddy.addActionListener(
				al->{this.removeBuddy();}
				);
		
		editBuddy = new JMenuItem("edit Buddy");
		editBuddy.addActionListener(
				al->{this.editBuddy();}
				);
		
		
		addressMenu = new JMenu("Address Book");
		addressMenu.add(save);
		addressMenu.add(create);
		addressMenu.add(addBuddy);
		addressMenu.add(removeBuddy);
		addressMenu.add(editBuddy);
		
		menuBar.add(addressMenu);
		
		listView.setBorder(BorderFactory.createEtchedBorder());
		
		mainPanel.add(fieldsPanel, BorderLayout.SOUTH);
		mainPanel.add(listView,BorderLayout.CENTER);
		
		mainFrame.setContentPane(mainPanel);
		mainFrame.setJMenuBar(menuBar);
		
		this.initialize();
	}
	
	private void save() {
		String s = book.toString();
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(nameField.getText()+".txt"));
			out.write(s);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void addBuddy() {
		book.addBuddy(new BuddyInfo(nameField.getText(), 
				addressField.getText(), phoneField.getText())); 		
	}

	private void removeBuddy() {
		book.removeBuddy((BuddyInfo)listView.getSelectedValue());
		
	}
	
	private void editBuddy() {
		
		BuddyInfo buddy = (BuddyInfo)listView.getSelectedValue();
		buddy.setAddress(addressField.getText());
		buddy.setName(nameField.getText());
		buddy.setPhoneNumber(phoneField.getText());
		listView.clearSelection();
		
	}


	private void initialize(){
		mainFrame.setSize(600, 600);
		mainFrame.setVisible(true);
	}
	
	public MainWindow(){
		this(new AddressBook());
	}
	
	public static void main(String[] args){
		AddressBook book = new AddressBook();
		book.addBuddy(new BuddyInfo("Reid","111","ddd"));
		new MainWindow(book);
	}
	
	private void create(){
		book = new AddressBook();

	}
	
}



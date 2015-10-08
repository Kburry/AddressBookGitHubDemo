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
	private JTextArea textArea;
	private JMenuBar menuBar;
	private JMenu addressMenu;
	private JMenuItem save;
	private JMenuItem create;
	private JMenuItem display;
	private JMenuItem addBuddy;
	private JMenuItem removeBuddy;
	private JTextField nameField;
	private JTextField addressField;
	private JTextField phoneField;
	private JLabel nameLabel;
	private JLabel addressLabel;
	private JLabel phoneLabel;
	
	
	private AddressBook book;
	
	public MainWindow(AddressBook book){
	
		this.book = book;
		
		mainFrame = new JFrame("Address Book");
		mainPanel = new JPanel(new BorderLayout());
		fieldsPanel = new JPanel(new GridLayout(3,2));
		textArea = new JTextArea("Hello");	
		menuBar = new JMenuBar();
		
		nameLabel = new JLabel("Name:");
		addressLabel = new JLabel("Address:");
		phoneLabel = new JLabel("Phone Number:");
		
		nameField = new JTextField();
		addressField = new JTextField();
		phoneField = new JTextField();
		
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
		
		display = new JMenuItem("display");
		display.addActionListener(
				al->{this.display();}
				);
		
		addBuddy = new JMenuItem("Add Buddy");
		addBuddy.addActionListener(
				al->{this.addBuddy();}
				);
		
		removeBuddy = new JMenuItem("Remove Buddy");
		removeBuddy.addActionListener(
				al->{this.removeBuddy();}
				);
		
		
		
		addressMenu = new JMenu("Address Book");
		addressMenu.add(save);
		addressMenu.add(create);
		addressMenu.add(display);	
		addressMenu.add(addBuddy);
		addressMenu.add(removeBuddy);
		
		menuBar.add(addressMenu);
		
		mainPanel.add(textArea, BorderLayout.CENTER);
		mainPanel.add(fieldsPanel, BorderLayout.SOUTH);
		
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
		book.removeBuddy(new BuddyInfo(nameField.getText(), 
				addressField.getText(), phoneField.getText()));
		
	}


	private void initialize(){
		mainFrame.setSize(300, 400);
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
	
	private void display(){
		textArea.setText(book.toString());
	}
}



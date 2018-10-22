package lab1;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Database.PersonProvider;
import Model.Person;

public class MyFrame extends JFrame implements ActionListener{
	private static JTable table= null;
	private static JButton button=new JButton("Hide");
	private JPanel panel=new JPanel();
	private Boolean k;
	private JFrame frame = new JFrame("Gui");
	private static ArrayList<Person> users=new ArrayList<Person>();

	
	public MyFrame() {
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fillTable();
        addComponentsToPane(frame.getContentPane());
        
        
        frame.pack();
        frame.setVisible(true);
		
	}
	
	public static void addComponentsToPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        table.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	System.out.println(button.getText());
            	if(button.getText().contains("Hide")) {
            		table.setVisible(false);
            		button.setText("Show");
            		
            	}else{
            		
            		table.setVisible(true);
            		button.setText("Hide");
            		
            	}
            	fillTable();
            }
        });
        pane.add(table);
        pane.add(button);
    }
	//messed up while creating the repository
	//creating merge request
	public static void fillTable() {
		
		PersonProvider p =new PersonProvider();
		try {
			users=p.getPersons();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int rc=0;
		for(Person pers :users) {rc++;}
		DefaultTableModel model = new DefaultTableModel(rc+1,4 );
		
		for(Person pers :users )
		{
			System.out.println(pers.getEmail());
			Object[] row = {pers.getId(),pers.getName(), pers.getAge(), pers.getEmail()};
			model.addRow(row);
		}
		table = new JTable(model);
		table.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}

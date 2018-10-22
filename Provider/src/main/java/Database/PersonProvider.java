package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Person;

public class PersonProvider {
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	public PersonProvider(){
	try{
	Class.forName("com.mysql.jdbc.Driver");  
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mankind?useSSL=false","root","1234");  
	stmt = con.createStatement();  
	rs = stmt.executeQuery("select * from Idde.Users");  
	} catch(Exception e) { 
		System.out.println(e);
	}
	}
	
	public ArrayList<Person> getPersons() throws SQLException{
		ResultSet resultset = rs;
		ArrayList<Person> arrayList = new ArrayList<Person>(); 
		while (resultset.next()) {              
		        
				Person m=new Person();
				m.setId(Integer.parseInt(resultset.getString(4)));
		        m.setAge(Integer.parseInt(resultset.getString(2)));
		        m.setName(resultset.getString(1));
		        m.setEmail(resultset.getString(3));		        
		        arrayList.add(m);
		}
		return arrayList;
	}

	

}

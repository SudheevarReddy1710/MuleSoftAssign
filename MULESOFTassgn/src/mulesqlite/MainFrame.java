package mulesqlite;
import java.io.*;
import java.sql.*;
import java.util.*;

public class MainFrame {

	public static void main(String[] args) throws Exception {
		
		int wtd;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		//Below code is to connect to the database
		
		Sqdb n = new Sqdb();
		Connection C = n.Connection();
		
		
		
		//Taking the operation that a user wanted to perform
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER THE OPERATION TO PERFORM?"
				+ "\n1-Create Table"
				+"\n2-Insert Values"
				+"\n3- Query"
				+"\n4-Update table");
		wtd = sc.nextInt();
		switch(wtd)
		{
		case 1:
			n.CreateTable(C);
			break;
		case 2:
			System.out.println("\nEnter movie name :");
			String movie = bf.readLine();
			System.out.println("\nEnter actor name :");
			String actor = bf.readLine();
			System.out.println("Enter actress name :");
			String actress = bf.readLine();
			System.out.println("Enter release year :");
			int year = Integer.parseInt(bf.readLine());
			n.Insert(movie, actor, actress, year, C);
			break;
		case 3:
			n.show(C);
			break;
		case 4:
			System.out.println("Enter correct year :");
			int year2 = Integer.parseInt(bf.readLine());
			System.out.println("Enter film id :");
			int filmid = Integer.parseInt(bf.readLine());
			n.UpdateTable(C, year2, filmid);
			break;
		}
		
		C.close();
	}

}

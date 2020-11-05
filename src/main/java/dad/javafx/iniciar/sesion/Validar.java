package dad.javafx.iniciar.sesion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;
import javafx.util.Pair;

public class Validar {

	public static BufferedReader bfrcsv;

	public static List<Pair<String, String>> users;

	public static String CargarCsv() {
		String mensaje="";	
			try {
				bfrcsv= new BufferedReader(new FileReader("src/main/resources/users/users.csv") ) ;
				users=new ArrayList<Pair<String, String>>();
				LeerCsv();
			} 
			catch(Exception e){
				mensaje="no se ha cargado el csv";
			}
			return mensaje;
		}
	
	private static void LeerCsv() throws IOException{
		String[] byPass;
		String line= bfrcsv.readLine();
		
		while(line !=null) {
			byPass=line.split(",");
			users.add(new Pair<String, String>(byPass[0], byPass[1]));
			line=bfrcsv.readLine();
		}
	}
	

	public static boolean validarAcceso(String user, String pass){
		String md5 = DigestUtils.md5Hex(pass).toUpperCase();
		return users.contains(new Pair<String, String>(user, md5));
	}
}

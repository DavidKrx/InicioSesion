package dad.javafx.iniciar.sesion;

import javafx.beans.property.SimpleStringProperty;

public class MIniciarsesion {
	
	SimpleStringProperty users;
	SimpleStringProperty passw;
	
	public final SimpleStringProperty usersProperty() {
		return this.users;
	}
	
	public final String getUsers() {
		return this.usersProperty().get();
	}
	
	public final void setUsers(final String users) {
		this.usersProperty().set(users);
	}
	
	public final SimpleStringProperty passwProperty() {
		return this.passw;
	}
	
	public final String getPassw() {
		return this.passwProperty().get();
	}
	
	public final void setPassw(final String passw) {
		this.passwProperty().set(passw);
	}
	
}

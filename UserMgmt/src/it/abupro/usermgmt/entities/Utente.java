package it.abupro.usermgmt.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.Session;

import it.abupro.usermgmt.fun.HibCon;
import it.abupro.usermgmt.entities.*;

@Entity
@Table(name="utente")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="nome")
	private String nome;
	@Column(name="cognome")
	private String cognome;
	@Column(name="email")
	private String email;
	@Column(name="sesso")
	private String sesso;
	@Column(name="tipologia")
	private String tipologia;
	@Column(name="password")
	private String password;

	public Utente (int id, String nome, String cognome, String email, String sesso, String tipologia) {
		setId(id);
		setNome(nome);
		setCognome(cognome);
		setEmail(email);
		setSesso(sesso);
		setTipologia(tipologia);
		setPassword(password);
	}

	public Utente () {}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void creaNuovo(Utente u) {
		HibCon h = new HibCon();
		try (Session s = h.getsFactory().openSession()) {
			s.beginTransaction();
			s.save(u);
			s.getTransaction().commit();
		}
	}

	public boolean confronto(String email, String password) {
		HibCon hC = new HibCon();
		boolean value;
		try (Session s = hC.getsFactory().openSession()) {
			
			Object conPsw = s.createSQLQuery("SELECT password FROM Utente WHERE email='"+email+"';").getSingleResult();
			Object conUsr = s.createSQLQuery("SELECT email FROM Utente WHERE email='"+email+"';").getSingleResult();
			String PswDB = conPsw.toString();
			String UsrDB = conUsr.toString();
			
			System.out.println(conPsw+"  ||  "+conUsr);
			
			if (PswDB.equals(password) && UsrDB.equals(email)) {
				value=true;
			} else {
				value=false;
			}
			return value;
		}
	}
	

	public short tipoUtente (String email) {
		short value;
		HibCon h = new HibCon();

		try(Session s = h.getsFactory().openSession()) {
			Object tipo = s.createSQLQuery("SELECT tipologia FROM Utente WHERE email='"+email+"';").getSingleResult();

			if (tipo.equals("adm")) {
				value=1;
			} else if (tipo.equals("mod")) {
				value=2;
			} else {
				value=3;
			}
		}
		return value;
	}
}



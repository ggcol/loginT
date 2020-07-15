package it.abupro.usermgmt.fun;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibCon {
	
	private SessionFactory sFactory;
	
	
	public void setsFactory(SessionFactory sFactory) {
		this.sFactory = sFactory;
	}

	public SessionFactory getsFactory() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sFactory = metadata.getSessionFactoryBuilder().build();
		return sFactory;
	}
	
	/*
	 * Creare uno Schema "accessi" 
	 * Con Tabella "utente"
	 * id int
	 * nome varchar
	 * cognome varchar
	 * email varchar
	 * sesso varchar
	 * tipologia varchar
	 * password varchar
	 */
}



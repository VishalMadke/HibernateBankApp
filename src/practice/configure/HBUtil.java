package practice.configure;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.MySQL57Dialect;

import practice.model.Account;

public class HBUtil {
 
	public static SessionFactory getsessionFactory()
	{
		Map<String, String> map=new HashMap<>();
		map.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
		map.put(Environment.URL, "jdbc:mysql://localhost:3306/banking");
		map.put(Environment.USER,"root");
		map.put(Environment.PASS, "root");
		
		map.put(Environment.DIALECT, "org.hibernate.dialect.MySQL57Dialect");
		map.put(Environment.HBM2DDL_AUTO, "update");
		map.put(Environment.SHOW_SQL,"true");
		map.put(Environment.FORMAT_SQL, "false");
	
		StandardServiceRegistry reg=new StandardServiceRegistryBuilder().applySettings(map).build();
		
		MetadataSources mds=new MetadataSources(reg);
		
		mds.addAnnotatedClass(Account.class);
		
		Metadata md = mds.getMetadataBuilder().build();
		
		SessionFactory sf = md.buildSessionFactory();
	
		return sf;
	}
}

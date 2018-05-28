package org.kossowski.packon;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.hibernate.Hibernate;
import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kossowski.packon.domain.Jm;
import org.kossowski.packon.domain.ZamowienieMaterialu;
import org.kossowski.packon.domain.Zlecenie;
import org.kossowski.packon.repositories.JmRepository;
import org.kossowski.packon.repositories.ZlecenieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
//@SpringBootTest
@AutoConfigureTestDatabase( replace=Replace.NONE )
//@TestPropertySource("classpath:application-test.properties")

public class PackonApplicationTests {

   @Autowired
   protected JmRepository jmRepository;
   
   @Autowired
   protected ZlecenieRepository zlecRepo;
   
	@Test
	@Transactional
	public void contextLoads() {
	   
	   //System.out.println("Odczutuję Zlecenie#4");
	   //Zlecenie z = zlecRepo.findOne( 4L );
	  
	   
	   //assertNotNull( z );
	   //System.out.println("Po odczycie");
	   
	   //for( ZamowienieMaterialu zm : z.getZamowieniaMaterialu() ) {
	   //      System.out.println( "zm.getDostawy.size() =" + zm.getDostawy().size() );
	   //      assertTrue( "Ilość poz = " + zm.getDostawy().size() , zm.getDostawy().size() < 8 );
	   //}
	}
	
	@Test
	public void Test1() {
	   
	      
	   
	
	}
	
}
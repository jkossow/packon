package org.kossowski.packon;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

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
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
//@AutoConfigureTestDatabase( replace=Replace.AUTO_CONFIGURED)
//@TestPropertySource("classpath:application-test.properties")

public class PackonApplicationTests {

   @Autowired
   protected JmRepository jmRepository;
   
   @Autowired
   protected ZlecenieRepository zlecRepo;
   
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void Test1() {
	   
	  Jm jm = jmRepository.findOne( 1L );
	   
	   System.out.println(  jm );
	}
	
	@Test
	//@Transactional( value=TxType.REQUIRES_NEW)
	public void Test2() {
	   
	   Zlecenie z = zlecRepo.findOne( 1L );
	   
	   ZamowienieMaterialu zm = new ZamowienieMaterialu();
	   
	   z.getZamowieniaMaterialu().add( zm );
	   
	   
	   zlecRepo.save( z );
	}

}

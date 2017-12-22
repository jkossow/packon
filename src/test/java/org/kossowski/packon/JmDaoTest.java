package org.kossowski.packon;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kossowski.packon.domain.Jm;
import org.kossowski.packon.repositories.JmRepository;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith( MockitoJUnitRunner.class)
public class JmDaoTest {

   @Mock   
   private JmRepository jmRepo;
   
   
   public List<Jm> getList() {
      
      List<Jm> l = new ArrayList<>();
      l.add( new Jm() );
      
      return l;
   }
   
   @Test
   public void Test1() {
      System.out.println("Test1");
      
      List<Jm> l = new ArrayList<>();
      l.add( new Jm() );
      l.add( new Jm() );
      
      given( jmRepo.findAll() ).willReturn( l );
      given( jmRepo.findOne( 1L)).willReturn( new Jm( 1, "x", "xxx" ) );
      
      List<Jm> jmList = jmRepo.findAll();
      
      assertEquals( jmRepo.findAll().size() , 2 );
      
      assertEquals( jmRepo.findOne(1L).getNazwa(), "xxx" );
      
      
      
   }
   
}

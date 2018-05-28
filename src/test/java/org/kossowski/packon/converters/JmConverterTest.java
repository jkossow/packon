package org.kossowski.packon.converters;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kossowski.packon.domain.Jm;
import org.kossowski.packon.repositories.JmRepository;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith( MockitoJUnitRunner.class)
public class JmConverterTest {

    @Mock
    protected JmRepository jmRepo;

    private  JmConverter jmConverter;

    private List<Jm> jmList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        jmList.add( new Jm( 1, "szt.", "sztuka") );
        given( jmRepo.findAll() ).willReturn( jmList );
        given( jmRepo.findOne(1L) ).willReturn( jmList.get(0));
        given( jmRepo.findOne( 2L)).willReturn( null );
        given( jmRepo.findOne( 3L)).willReturn( new Jm() );

        jmConverter = new JmConverter();
        jmConverter.setJmRepo( jmRepo );

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAsObject() {
        Jm jm = jmList.get( 0 );
        assertEquals( jmConverter.getAsObject( null, null,  "1"),  jm );

    }

    @Test
    public void getAsObject_if_empty() {

        assertNull( jmConverter.getAsObject( null, null,  "") );

    }

    @Test
    public void getAsObject_if_null() {

        assertNull( jmConverter.getAsObject( null, null,  null) );

    }

    @Test
    public void getAsString() {
        assertEquals( jmConverter.getAsString( null, null, null ), null);
        Jm jm = new Jm( 1, "sct.", "sztuka" );
        assertEquals( jmConverter.getAsString( null, null, jm ), "1" );

    }
}
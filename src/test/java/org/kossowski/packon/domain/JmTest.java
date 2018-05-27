package org.kossowski.packon.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class JmTest {

    private Jm jm1 = new Jm();
    private Jm jm2 = new Jm();

    @Test
    public void test_uuid_setting() {

        Jm jm = new Jm();
        assertNotNull( jm.getUuid() );
        assertNotEquals( "", jm.getUuid().toString() );
    }

    @Test
    public void test_if_is_the_same_hashcode() {

        Jm jm = new Jm();
        int jmHash = jm.hashCode();
        jm.setNazwa( "dummy" );
        assertEquals( jmHash, jm.hashCode() );

    }

    @Test
    public void test_set_get_symbol() {

        String s = "dummy";
        Jm jm = new Jm();
        jm.setSymbol( s );
        assertEquals( s, jm.getSymbol() );
    }

    @Test
    public void test_set_get_nazwa() {

        String s = "dummy";
        Jm jm = new Jm();
        jm.setNazwa( s );
        assertEquals( s, jm.getNazwa() );
    }
}
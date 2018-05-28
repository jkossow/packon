package org.kossowski.packon.controllers;

import org.kossowski.packon.insert.Towar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import javax.faces.bean.ManagedBean;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Controller
@ManagedBean
public class InsertSampleController {

    @Autowired
    @Qualifier( "insertDataSource" )
    protected DataSource insertDataSource;


    public void sample1() {

        JdbcTemplate template = new JdbcTemplate( insertDataSource );

        String sql = "select tw_Id, tw_symbol, tw_Nazwa from tw__Towar";

        List<Towar> towary = template.query( sql, new BeanPropertyRowMapper<>( Towar.class) );

        System.out.println( towary.size() );

        for( Towar t: towary )
            System.out.println(  t.getTw_Id() + " " + t.getTw_Symbol() + " " + t.getTw_Nazwa());
    }
}

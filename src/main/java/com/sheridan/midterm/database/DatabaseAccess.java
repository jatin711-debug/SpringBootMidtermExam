package com.sheridan.midterm.database;

import java.util.List;

import com.sheridan.midterm.beans.Spending;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseAccess implements DATABASE {

    @Autowired
    private NamedParameterJdbcTemplate jdbc;

    @Override
    public void addDataToDatabase(Spending object) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        String query = "INSERT INTO accountInfo(NAME,DESCRIPTION,AMOUNT) VALUES(:name,:desc,:amount)";
        param.addValue("name",object.getName());
        param.addValue("desc",object.getDescription());
        param.addValue("amount",object.getAmount());
        jdbc.update(query, param);
    }

    @Override
    public void searchFromDatabase() {
        
    }

    @Override
    public List<Spending> getAllDatabase() {
        String que = "Select * from accountInfo";
        BeanPropertyRowMapper<Spending> mapper = new BeanPropertyRowMapper<Spending>(Spending.class);
        List<Spending> object = (List<Spending>)(jdbc.query(que,mapper));
        return object;
    }

    
    
}

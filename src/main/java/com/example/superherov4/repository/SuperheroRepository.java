package com.example.superherov4.repository;

import com.example.superherov4.SuperheroV4Application;
import com.example.superherov4.model.Superhero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperheroRepository {

    @Value("${spring.datasource.url}")
    private String db_url;

    @Value("${spring.datasource.username}")
    private String uid;

    @Value("${spring.datasource.password}")
    private String pwd;


    public List<Superhero> getSuperhero() {
        List<Superhero> superheroes = new ArrayList<Superhero>();
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT * FROM superhero;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                int ID = rs.getInt("superhero_id");
                String superheroName = rs.getString("superhero_name");
                String reelName = rs.getString("reel_name");
                boolean isHuman = rs.getBoolean("is_human");
                String superpower = rs.getString("superpower");
                int creationYear = rs.getInt("creation_year");
                double powerlevel = rs.getDouble("powerlevel");
                String city = rs.getString("city");
                superheroes.add(new Superhero(ID, superheroName, reelName, isHuman, superpower, creationYear, powerlevel, city));
            }
            return superheroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}










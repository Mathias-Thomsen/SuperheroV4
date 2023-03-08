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


    public List<Superhero> getSuperheroes() {
        List<Superhero> superheroes = new ArrayList<Superhero>();
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT superhero_id, superhero_name, reel_name, creation_year FROM superhero;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                int ID = rs.getInt("superhero_id");
                String superheroName = rs.getString("superhero_name");
                String reelName = rs.getString("reel_name");
                int creationYear = rs.getInt("creation_year");
                superheroes.add(new Superhero(ID, superheroName, reelName, creationYear));
            }
            return superheroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Superhero getSuperhero(String superhero) {
        Superhero superhero1 = null;

        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT superhero_id, superhero_name, reel_name, creation_year FROM superhero WHERE superhero_name = ?;";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, superhero);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int ID = rs.getInt("superhero_id");
                String superheroName = rs.getString("superhero_name");
                String reelName = rs.getString("reel_name");
                int creationYear = rs.getInt("creation_year");
                superhero1 = (new Superhero(ID, superheroName, reelName, creationYear));
            }
            return superhero1;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}










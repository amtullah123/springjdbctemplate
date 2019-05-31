package com.stackroute.repository;


import com.stackroute.domain.Movie;
import com.stackroute.mapper.MovieRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class SpringJdbcRepository {
    private JdbcTemplate jdbcTemplate ;

    public SpringJdbcRepository(){

    }

    @Autowired
    public void  setDataSource(final DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Movie> getAll() {
        return jdbcTemplate.query("select * from movies", new MovieRowMapper());
    }

    public int add(Movie movie)
    {
        return  jdbcTemplate.update("insert into movies values(?,?,?,?)",movie.getMovie_id(),movie.getMovie_name(),movie.getRelease_year(),movie.getRating());
    }
    public Movie get(final String movie_name)
    {
        final String query="SELECT * FROM movies WHERE MOVIE_ID=?";
        return jdbcTemplate.queryForObject(query,new Object[] {movie_name},new MovieRowMapper());
    }
    public int update(Movie entity)
    {
        return jdbcTemplate.update("UPDATE movies SET MOVIE_NAME=? WHERE MOVIE_ID=?",entity.getMovie_name(),entity.getMovie_id());
    }
    public int delete(Movie entity)
    {
        return jdbcTemplate.update("DELETE FROM movies WHERE MOVIE_ID=?",entity.getMovie_id());
    }

}

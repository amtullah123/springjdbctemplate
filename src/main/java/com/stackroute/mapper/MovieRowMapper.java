package com.stackroute.mapper;

import org.springframework.jdbc.core.RowMapper;
import com.stackroute.domain.Movie;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie>
{
    @Override
    public Movie mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Movie movie = new Movie();
        movie.setMovie_id(rs.getInt("MOVIE_ID"));
        movie.setMovie_name(rs.getString("MOVIE_NAME"));
        movie.setRelease_year(rs.getInt("RELEASE_YEAR"));
        movie.setRating(rs.getInt("RATING"));
        return movie;
    }

}

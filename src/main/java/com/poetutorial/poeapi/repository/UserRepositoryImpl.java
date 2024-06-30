package com.poetutorial.poeapi.repository;

import com.poetutorial.poeapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void saveUser(User user) {
        String sql = "INSERT INTO users (name, email, created_at) VALUES (?,?,?)";

//         Timestamp createdAt = Timestamp.valueOf(user.getCreatedAt());

        // fix Timestamp
        // jdbcTemplate.update(sql, user.getName(), user.getEmail(), new java.sql.Timestamp(user.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()));
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getCreatedAt());
    }

    @Override
    public User findUserById(Long id) {
        String sql = "SELECT id, name, email, created_at FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setCreatedAt(rs.getObject("created_at", java.time.LocalDateTime.class));
            return user;
        }, id);
    }

    @Override
    public User updateUser(User user) {
        String sql = "UPDATE users SET name = ?, email = ?, created_at = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getCreatedAt(), user.getId());
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<User> findAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new User(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getTimestamp("created_at").toLocalDateTime()
            ));
    }

}

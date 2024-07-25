
package com.crud.user.repository;

import com.crud.user.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements InterfaceUserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<User> findAll() {
        String SQL = "SELECT * FROM users WHERE status = 1";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(User.class));
    }

    @Override
    public int save(User user) {
        String SQL = "INSERT INTO users VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(SQL, new Object[]{user.getId(), user.getFirstName(), user.getLastName(), user.getPhone(), user.getStatus()});
    }

    @Override
    public int update(User user) {
        String SQL = "UPDATE users SET firstName = ?, lastName = ?, phone = ?, status = ? WHERE id = ?";
        return jdbcTemplate.update(SQL, new Object[]{user.getFirstName(), user.getLastName(), user.getPhone(), user.getStatus(), user.getId()});
    }

    @Override
    public int deleteById(int id) {
        String SQL = "UPDATE users SET status = 0 WHERE id = ?";
        return jdbcTemplate.update(SQL, new Object[]{id});
    }
    
}

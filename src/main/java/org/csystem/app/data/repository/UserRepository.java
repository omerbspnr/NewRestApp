package org.csystem.app.data.repository;

import org.csystem.app.data.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
class UserRepository implements IUserRepository {
    private final JdbcTemplate m_jdbcTemplate;
    private final PasswordEncoder m_encoder;

    @Value("${postgresql.users.count}")
    private String m_countSql;

    @Value("${postgresql.users.findAll}")
    private String m_findAllSql;
    @Value("${postgresql.users.findByEmail}")
    private String m_findByEmailSql;
    @Value("${postgresql.users.findById}")
    private String m_findByIdSql;
    @Value("${postgresql.users.findByUsername}")
    private String m_findByUsernameSql;

    @Value("${postgresql.users.save}")
    private String m_saveSql;
    private void fillUsers(ResultSet resultSet, List<User> users) throws SQLException
    {
        do {
            var id = resultSet.getInt(1);
            var username = resultSet.getString(2);
            var email = resultSet.getString(3);
            var password = resultSet.getString(4);
            users.add(new User(id, username, email, password));
        } while (resultSet.next());
    }

    public UserRepository(JdbcTemplate jdbcTemplate, PasswordEncoder encoder)
    {
        m_jdbcTemplate = jdbcTemplate;
        m_encoder = encoder;
    }

    @Override
    public Optional<User> findByUsername(String username)
    {
        ArrayList<User> users = new ArrayList<>();
        m_jdbcTemplate.query(m_findByUsernameSql,new Object[]{username},(ResultSet rs) -> fillUsers(rs, users));
        return users.stream().findFirst();
    }

    @Override
    public Optional<User> findByEmail(String email)
    {
        return Optional.empty();
    }

    @Override
    public boolean existsByUsername(String username)
    {
        return findByUsername(username).isPresent();
    }

    @Override
    public boolean existsByEmail(String email)
    {
        return findByEmail(email).isPresent();
    }

    @Override
    public long count()
    {
        return m_jdbcTemplate.query(m_countSql,(ResultSet rs) -> {rs.next(); return rs.getLong(1);});
    }
    @Override
    public Optional<User> findById(Integer integer)
    {
        var users = new ArrayList<User>();
        m_jdbcTemplate.query(m_findByIdSql,new Object[]{integer}, (ResultSet rs) -> fillUsers(rs, users));
        return users.stream().findFirst();
    }
    @Override
    public boolean existById(Integer integer)
    {
        return findById(integer).isPresent();
    }
    @Override
    public Iterable<User> findAll()
    {
        var users = new ArrayList<User>();
        m_jdbcTemplate.query(m_findAllSql, (ResultSet rs) -> fillUsers(rs, users));
        return users;
    }


    @Override
    public <E extends User> E save(E entity)
    {
        entity.setPassword(m_encoder.encode(entity.getPassword()));
        m_jdbcTemplate.update(m_saveSql, entity.getUsername(), entity.getEmail(), entity.getPassword());
        return entity;
    }

    ////////////////////////
    @Override
    public void delete(User entity)
    {

    }

    @Override
    public void deleteAll()
    {

    }

    @Override
    public void delete(Iterable<? extends User> entities)
    {

    }

    @Override
    public void deleteById(Integer Id)
    {

    }
    @Override
    public <E extends User> E saveAll(Iterable<E> entity)
    {
        return null;
    }
}

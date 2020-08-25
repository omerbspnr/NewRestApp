package org.csystem.app.data.repository;

import org.csystem.app.data.entity.User;
import org.csystem.util.data.wrapper.DbUtil;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDBHelper {
    private final IUserRepository m_userRepository;

    public UserDBHelper(IUserRepository userRepository)
    {
        m_userRepository = userRepository;
    }

    public Optional<User> findByUsername(String username)
    {
        return DbUtil.doWorkForRepository(() ->m_userRepository.findByUsername(username), "findByUsername");
    }

    public Optional<User> findByEmail(String email)
    {
        return DbUtil.doWorkForRepository(() -> m_userRepository.findByEmail(email), "findByEmail");
    }

    public boolean existsByUsername(String username)
    {
        return DbUtil.doWorkForRepository(() ->m_userRepository.existsByUsername(username), "existsByUsername");
    }

    public boolean existsByEmail(String email)
    {
        return DbUtil.doWorkForRepository(() ->m_userRepository.existsByEmail(email), "existsByEmail");
    }
    public User saveUser(User user)
    {
        return DbUtil.doWorkForRepository(() -> m_userRepository.save(user), "saveUser");
    }
}

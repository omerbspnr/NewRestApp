package org.csystem.app.service;

import org.apache.juli.logging.Log;
import org.csystem.app.data.repository.UserDBHelper;
import org.csystem.app.dto.LoginFormDTO;
import org.csystem.util.data.wrapper.DbUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final UserDBHelper m_userDBHelper;
    private final PasswordEncoder m_passwordEncoder;

    public LoginService(UserDBHelper userDBHelper, PasswordEncoder passwordEncoder)
    {
        m_userDBHelper = userDBHelper;
        m_passwordEncoder = passwordEncoder;
    }

    public boolean isUserExist(LoginFormDTO loginFormDTO)
    {
        return DbUtil.doWorkForService(()-> m_userDBHelper.existsByUsername(loginFormDTO.getUsername()), "isUserExist");
    }
    public boolean login(LoginFormDTO loginFormDTO)
    {
        if (!isUserExist(loginFormDTO))
            return false;

        return m_passwordEncoder.matches(loginFormDTO.getPassword(),m_userDBHelper.findByUsername(loginFormDTO.getUsername()).get().getPassword());
    }
}

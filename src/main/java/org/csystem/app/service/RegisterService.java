package org.csystem.app.service;

import org.csystem.app.converter.RegistrationFormConverter;
import org.csystem.app.data.repository.UserDBHelper;
import org.csystem.app.dto.LoginFormDTO;
import org.csystem.app.dto.RegistrationFormDTO;
import org.csystem.util.data.wrapper.DbUtil;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private final UserDBHelper m_userDBHelper;
    private final RegistrationFormConverter m_registrationFormConverter;

    private RegistrationFormDTO saveUserAndConvert(RegistrationFormDTO form)
    {
        return m_registrationFormConverter.UserToRegistrationFormDTO(m_userDBHelper.saveUser(m_registrationFormConverter.RegistrationFormDTOToUser(form)));
    }
    public RegisterService(UserDBHelper userDBHelper, RegistrationFormConverter registrationFormConverter)
    {
        m_userDBHelper = userDBHelper;
        m_registrationFormConverter = registrationFormConverter;
    }

    public boolean isUserExist(RegistrationFormDTO registrationFormDTO)
    {
        return DbUtil.doWorkForService(() -> m_userDBHelper.existsByUsername(registrationFormDTO.getUsername())
                && m_userDBHelper.existsByEmail(registrationFormDTO.getEmail()), "isUserExist");
    }

    public RegistrationFormDTO saveUser(RegistrationFormDTO registrationFormDTO)
    {
        return DbUtil.doWorkForService(() -> saveUserAndConvert(registrationFormDTO) , "saveUser");
    }
}

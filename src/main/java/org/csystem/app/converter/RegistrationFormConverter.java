package org.csystem.app.converter;

import org.csystem.app.data.entity.User;
import org.csystem.app.dto.RegistrationFormDTO;
import org.springframework.stereotype.Component;

@Component
public class RegistrationFormConverter {
    public RegistrationFormDTO UserToRegistrationFormDTO(User user)
    {
        return new RegistrationFormDTO(user.getUsername(),user.getEmail(), "");
    }

    public User RegistrationFormDTOToUser(RegistrationFormDTO registrationFormDTO)
    {
        return new User(0,registrationFormDTO.getUsername(), registrationFormDTO.getEmail(), registrationFormDTO.getPassword());
    }
}

package org.csystem.app.controller;

import org.csystem.app.dto.RegistrationFormDTO;
import org.csystem.app.dto.UserDTO;
import org.csystem.app.service.RegisterService;
import org.csystem.util.exception.ExceptionUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    private final RegisterService m_registerService;

    public RegisterController(RegisterService registerService)
    {
        m_registerService = registerService;
    }

    @GetMapping("/register")
    public String register()
    {
        return "Register page";
    }
    @PostMapping("/register")
    public RegistrationFormDTO saveUser(@RequestBody RegistrationFormDTO registrationFormDTO)
    {
        return ExceptionUtil.subscribe(() -> m_registerService.saveUser(registrationFormDTO), ex ->  {
            registrationFormDTO.setMsg("User Already Exist");return registrationFormDTO;}
            );
    }

}

package org.csystem.app.controller;

import org.csystem.app.dto.LoginFormDTO;
import org.csystem.app.service.LoginService;
import org.csystem.util.exception.ExceptionUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final LoginService m_loginService;
    private ResponseEntity<LoginFormDTO> controlForLogin(LoginFormDTO loginFormDTO)
    {
        if (m_loginService.login(loginFormDTO))
            return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION, "/hello").body(loginFormDTO);

        loginFormDTO.setMsg("Username or password wrong");
        return ResponseEntity.status(401).body(loginFormDTO);
    }
    private ResponseEntity<LoginFormDTO> exceptionForLogin(LoginFormDTO loginFormDTO)
    {
        loginFormDTO.setMsg("User Not Found");
        return ResponseEntity.status(401).body(loginFormDTO);
    }
    public LoginController(LoginService loginService)
    {
        m_loginService = loginService;
    }

    @GetMapping("/login")
    public String loginPage()
    {
        return "login.html";
    }

    @PostMapping("/login")
    public ResponseEntity<LoginFormDTO> login(@RequestBody LoginFormDTO loginFormDTO)
    {
        return ExceptionUtil.subscribe(() -> controlForLogin(loginFormDTO), ex -> exceptionForLogin(loginFormDTO));
    }
}

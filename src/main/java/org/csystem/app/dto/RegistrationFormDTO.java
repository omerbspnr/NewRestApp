package org.csystem.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationFormDTO {
    private String m_username;
    private String m_email;
    private String m_password;
    private String m_msg;

    public RegistrationFormDTO(String username, String email, String password)
    {
        m_username = username;
        m_email = email;
        m_password = password;
    }

    public String getUsername()
    {
        return m_username;
    }

    public void setUsername(String username)
    {
        m_username = username;
    }

    public String getEmail()
    {
        return m_email;
    }

    public void setEmail(String email)
    {
        m_email = email;
    }

    public String getPassword()
    {
        return m_password;
    }

    public void setPassword(String password)
    {
        m_password = password;
    }

    public String getMsg()
    {
        return m_msg;
    }

    public void setMsg(String msg)
    {
        m_msg = msg;
    }
}

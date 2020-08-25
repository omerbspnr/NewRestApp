package org.csystem.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("User")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginFormDTO {
    private String m_username;
    private String m_password;

    private String m_msg;

    public LoginFormDTO(String username, String password)
    {
        m_username = username;
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

    public String getUsername()
    {
        return m_username;
    }

    public void setUsername(String username)
    {
        m_username = username;
    }

    public String getPassword()
    {
        return m_password;
    }

    public void setPassword(String password)
    {
        m_password = password;
    }
}

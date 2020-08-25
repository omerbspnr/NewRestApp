package org.csystem.app.data.entity;

import com.fasterxml.jackson.annotation.JsonRootName;

public class User {
    private int m_id;
    private String m_username;
    private String m_email;
    private String m_password;

    public User(int id, String username, String email, String password)
    {
        m_id = id;
        m_username = username;
        m_email = email;
        m_password = password;
    }

    public int getId()
    {
        return m_id;
    }

    public void setId(int id)
    {
        m_id = id;
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
}

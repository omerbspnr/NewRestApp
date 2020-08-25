package org.csystem.app.exception.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RestAppError {
    private final String m_message;
    private final HttpStatus m_httpStatus;
    private final LocalDateTime m_timestamp;
    private final String m_debugMessage;
    private final Object m_rejectedValue;

    public RestAppError(String message, HttpStatus httpStatus, String debugMessage, Object rejectedValue)
    {
        m_message = message;
        m_httpStatus = httpStatus;
        m_timestamp = LocalDateTime.now();
        m_debugMessage = debugMessage;
        m_rejectedValue = rejectedValue;
    }

    public String getMessage()
    {
        return m_message;
    }

    public HttpStatus getHttpStatus()
    {
        return m_httpStatus;
    }
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/YYYY hh:mm:ss")
    public LocalDateTime getTimestamp()
    {
        return m_timestamp;
    }

    public String getDebugMessage()
    {
        return m_debugMessage;
    }

    public Object getRejectedValue()
    {
        return m_rejectedValue;
    }
}

package ru.javaproject.threatmodel.util;

import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateTimeFormatter implements Formatter<LocalDateTime>
{
    @Override
    public LocalDateTime parse(String s, Locale locale) throws ParseException
    {
        if (s == null) {
            return null;
        }
        return DateTimeUtil.parseLocalDateTime(s, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    @Override
    public String print(LocalDateTime dateTime, Locale locale) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.toString();
    }
}

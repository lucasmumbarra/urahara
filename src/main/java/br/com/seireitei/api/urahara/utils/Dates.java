package br.com.seireitei.api.urahara.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.*;
import java.util.Date;
import java.util.TimeZone;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class Dates {
  
  private static final String INITIAL_TIMESTAMP = "T00:00:00";
  private static final String FINAL_TIMESTAMP = "T23:59:59";
  private static final int FIRST_DAY_OF_MONTH = 1;

  public static String getFormattedDate(LocalDateTime localDateTime, String pattern) {
    if (isNull(localDateTime) || isBlank(pattern)) {
      return null;
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    return localDateTime.format(formatter);
  }

  public static String getFormattedDate(ZonedDateTime localDateTime, String pattern) {
    if (isNull(localDateTime) || isBlank(pattern)) {
      return null;
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    return localDateTime.format(formatter);
  }

  public static String getFormattedDate(LocalDate localDate, String pattern) {
    if (isNull(localDate) || isBlank(pattern)) {
      return null;
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    return localDate.format(formatter);
  }

  public static LocalDate getFormattedDate(String date, String pattern) {
    if (isNull(date) || isBlank(pattern)) {
      return null;
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    return LocalDate.parse(date, formatter);
  }

  public static LocalDateTime dateToLocalDateTime(Date date) {
    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
  }

  public static String localDateTimetoDate(LocalDateTime date) {
    Date finalDate = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
    DateFormat dateFormat = new SimpleDateFormat(DatePatterns.YYYY_MM_DD);
    return dateFormat.format(finalDate);
  }

  public static String getFormattedDate(YearMonth yearMonth, String pattern) {
    if (isNull(yearMonth) || isBlank(pattern)) {
      return null;
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    return yearMonth.format(formatter);
  }

  public static LocalDateTime toLocalDateTimeFromGmt(Date gmtDate) {
    if (isNull(gmtDate)) {
      return null;
    }
    Date localDate = new Date();
    Date localDateFromGmt = new Date(gmtDate.getTime() + TimeZone.getDefault().getOffset(localDate.getTime()));
    return localDateFromGmt.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
  }

  public static LocalDateTime getInitialTimestampOfDay(LocalDate localDate) {
    if (isNull(localDate)) {
      return null;
    }
    CharSequence fromText = localDate.toString() + INITIAL_TIMESTAMP;
    return LocalDateTime.parse(fromText, DateTimeFormatter.ISO_DATE_TIME);
  }

  public static LocalDateTime getFinalTimestampOfDay(LocalDate localDate) {
    CharSequence fromText = localDate.toString() + FINAL_TIMESTAMP;
    return LocalDateTime.parse(fromText, DateTimeFormatter.ISO_DATE_TIME);
  }

  public static LocalDateTime getInitialTimestampOfDay(YearMonth yearMonth) {
    LocalDate localDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), FIRST_DAY_OF_MONTH);
    return getInitialTimestampOfDay(localDate);
  }

  public static LocalDateTime getFinalTimestampOfDay(YearMonth yearMonth) {
    int lastDayOfMonth = yearMonth.atEndOfMonth().lengthOfMonth();
    LocalDate localDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), lastDayOfMonth);
    return getFinalTimestampOfDay(localDate);
  }
}

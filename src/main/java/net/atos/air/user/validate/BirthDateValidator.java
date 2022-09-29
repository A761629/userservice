package net.atos.air.user.validate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BirthDateValidator implements ConstraintValidator<BirthDate, Date> {
  @Override
  public boolean isValid(final Date valueToValidate, final ConstraintValidatorContext context) {
    	  
	  Calendar calendar = GregorianCalendar.getInstance();
	  calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 18);
	  return calendar.getTime().after(valueToValidate);
  }
  
  }
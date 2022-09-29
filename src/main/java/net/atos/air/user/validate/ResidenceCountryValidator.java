package net.atos.air.user.validate;

	import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

	public class ResidenceCountryValidator implements ConstraintValidator<ResidenceCountry, String> {
		
		private static String residenceCountry ="French";

	  @Override
	  public boolean isValid(final String valueToValidate, final ConstraintValidatorContext context) {
	  	    return valueToValidate.equalsIgnoreCase(residenceCountry);
	  }
	}
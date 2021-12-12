package pe.com.spring.strut.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberUtils {

    /** The Constant ONE_HUNDRED: {{@value} */
    public static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100L);

    /**
     * To big decimal.
     * @param string the string
     * @return the big decimal
     */
    public static BigDecimal toBigDecimal(final String string) {

        return toBigDecimal(string, null);
    }

    /**
     * To big decimal.
     * @param string the string
     * @param defaultValue the default value
     * @return the big decimal
     */
    public static BigDecimal toBigDecimal(final String string, final BigDecimal defaultValue) {

        if (string == null) {
            return defaultValue;
        }

        try {
            return new BigDecimal(string);

        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }
    }

    /**
     * Null-safe {@link Integer#longValue()}
     * @param number the number
     * @return the long
     */
    public static Long toLong(final Integer number) {

        // (sanity-check)
        if (number == null) {
            return null;
        }

        return number.longValue();
    }

    /**
     * Null-safe {@link Long#valueOf(String)}
     * @param number the number
     * @return the long
     */
    public static Long toLong(final String number) {

        // (sanity-check)
        if (number == null) {
            return null;
        }

        return Long.valueOf(number);
    }

    /**
     * Null safe {@link Long#intValue()}
     * @param number the number
     * @return the integer
     */
    public static Integer toInteger(final Long number) {

        // (sanity-check)
        if (number == null) {
            return null;
        }

        return number.intValue();
    }

    /**
     * Format the current number to a localized number.
     * @param number number
     * @return the string
     */
    public static String toLocalizedNumber(final Number number) {

        // (sanity-check)
        if (number == null) {
            return null;
        }

        return NumberFormat.getInstance(new Locale("ES", "es")).format(number);
    }

    /**
     * Instantiates a new number utils.
     */
    private NumberUtils() {
    }
}

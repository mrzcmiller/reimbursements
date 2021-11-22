package com.revature.reimbursements.formatting;

import java.text.NumberFormat;
import java.util.Locale;

public interface Currency {
	Locale currentLocale = Locale.getDefault();

	static public String displayCurrency(Locale currentLocale, double amount) {
		NumberFormat nFinstance = NumberFormat.getCurrencyInstance(currentLocale);
		String result = nFinstance.format(amount);
		return result;
	}

}


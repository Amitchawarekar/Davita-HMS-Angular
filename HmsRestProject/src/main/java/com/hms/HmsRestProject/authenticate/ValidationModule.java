package com.hms.HmsRestProject.authenticate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hms.HmsRestProject.exception.InvalidCredentialsException;

public class ValidationModule {

	public static boolean validatePassword(String password) throws InvalidCredentialsException {

		Matcher matcher = Pattern.compile("[A-Z]+[a-z]*\\d").matcher(password);

		if (password.length() > 5 && password.length() < 15) {
			if (matcher.matches()) {
				return true;
			} else {
				throw new InvalidCredentialsException("at least 1 uppercase char & at least one numeric char");
			}

		} else {
			throw new InvalidCredentialsException("at least 5 chars and not more than 15");
		}
	}

	public static boolean validateEmail(String email) throws InvalidCredentialsException {

		Matcher matcher = Pattern.compile("^(.+)@(\\S+)$").matcher(email);

		if(matcher.matches()) {
			return true;
		} else {
			throw new InvalidCredentialsException("Please entered valid email");
		}

	}

}

package com.validation;

import javax.servlet.http.Part;

public class validation {

	private String result;

	@SuppressWarnings("finally")
	public String validateMessage(String name, String email, String message) {

		// 2<=name length<=30 ->valid
		// 10<=email length<=20 ->valid
		// 2<=email length<=200 ->valid

		try {
			if (name.length() < 2 || name.length() > 30) {
				result = "invalid name";
			} else if (email.length() < 10 || email.length() > 20) {
				result = "invalid email";
			} else if (message.length() < 2 || message.length() > 200) {
				result = "invalid message";
			} else {
				result = "valid";
			}
		} catch (Exception e) {
			System.out.println("Validation:validateMessage" + e);
			result = "exp";
		} finally {
			return result;
		}
	}

	@SuppressWarnings("finally")
	public String validateResume(Part part) {
		try {
			String ct = part.getContentType();
			long size = part.getSize();
  
			if (!(ct.endsWith("pdf") || ct.endsWith("document"))) {
				result = "invalid file format";
			} else if (size > 102400 || size < 1) {
				result = "invalid size";
			} else {
				result = "valid";
			}
		} catch (Exception e) {
			System.out.println("Validation:validateResume" + e);
			result = "exp";

		} finally {
			return result;
		}
	}
}

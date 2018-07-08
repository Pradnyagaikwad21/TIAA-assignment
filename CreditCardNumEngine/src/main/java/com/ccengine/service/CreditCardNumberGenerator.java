package com.ccengine.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

import org.springframework.stereotype.Service;

import com.ccengine.bean.CCNumberBean;
import com.ccengine.bean.CCNumberResponseBean;

@Service
public class CreditCardNumberGenerator {

	public static final String AMEX_PREFIX = "37";
	public static final String VISA_PREFIX = "4";
	public static final String MASTERCARD_PREFIX = "5";
	public static final String DISCOVER_PREFIX = "6";

	public CCNumberResponseBean generateCardNumber(String cardtype, int no) {

		

		String[] arrccnum = null;

		switch (cardtype) {
		case "MASTERCARD":
			arrccnum = creditCardNumber(MASTERCARD_PREFIX, 16, no);
			break;
		case "AMEX":
			arrccnum = creditCardNumber(AMEX_PREFIX, 16, no);
			break;
		case "VISA":
			arrccnum = creditCardNumber(VISA_PREFIX, 16, no);
			break;
		case "DISCOVER":
			arrccnum = creditCardNumber(DISCOVER_PREFIX, 16, no);
			break;
		default:
		}
		CCNumberBean[] arrCreaditCard = new CCNumberBean[no];
		
		int i = 0;
		for (String ccnum : arrccnum) {
			CCNumberBean cc = new CCNumberBean(ccnum,LocalDate.now());
		}
		CCNumberResponseBean response = new CCNumberResponseBean(arrCreaditCard);
		response.setCreaditCard(arrCreaditCard);
		return response;
	}

	private static String[] creditCardNumber(String prefix, int length, int noOfCard) {
		Stack<String> result = new Stack<String>();
		for (int i = 0; i < noOfCard; i++) {
			result.push(completedNumber(prefix, length));
		}

		return result.toArray(new String[result.size()]);

	}

	static String strrev(String str) {
		if (str == null)
			return "";
		StringBuilder sb =new StringBuilder(str);
		return sb.reverse().toString();
	}

	private static String completedNumber(String prefix, int length) {
		String ccnumber = prefix;
		// generate digits
		while (ccnumber.length() < (length - 1)) {
			ccnumber += new Double(Math.floor(Math.random() * 10)).intValue();
			System.out.println("ccnumber :: "+ccnumber);
		}

		// reverse number and convert to int

		String reversedCCnumberString = strrev(ccnumber);

		List<Integer> reversedCCnumberList = new ArrayList<>();
		for (int i = 0; i < reversedCCnumberString.length(); i++) {
			reversedCCnumberList.add(new Integer(String.valueOf(reversedCCnumberString.charAt(i))));
		}

		// calculate sum

		int sum = 0;
		int pos = 0;

		Integer[] reversedCCnumber = reversedCCnumberList.toArray(new Integer[reversedCCnumberList.size()]);
		while (pos < length - 1) {

			int odd = reversedCCnumber[pos] * 2;
			if (odd > 9) {
				odd -= 9;
			}

			sum += odd;

			if (pos != (length - 2)) {
				sum += reversedCCnumber[pos + 1];
			}
			pos += 2;
		}

		// calculate check digit

		int checkdigit = new Double((((sum / 10) + 1) * 10 - sum) % 10).intValue();
		ccnumber += checkdigit;

		return ccnumber;
	}
}

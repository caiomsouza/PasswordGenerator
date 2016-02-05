/*!
 * This program is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software
 * Foundation.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 * or from the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * Copyright (c) 2016-2016 AI4biz Corporation..  All rights reserved.
 */


package org.caiomsouza;

import org.caiomsouza.GenaratePassword;
import org.caiomsouza.PassGen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class GPApp {

	private static Scanner keyboard;

	public static void main(String[] args) {

		keyboard = new Scanner(System.in);
		
		
		try {
			
			
			File file = new File("res/messages.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			java.util.Enumeration<Object> enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);

				//System.out.println(key + ": " + value);

			}

			// get the property value and print it out
			String PASSWORD_NUMBER = properties.getProperty("PASSWORD_NUMBER");
			String STRONG_PASSWORD_OPTION = properties.getProperty("STRONG_PASSWORD_OPTION");
			String STRONG_PASSWORD_NOT_CREATED = properties.getProperty("STRONG_PASSWORD_NOT_CREATED");


			//System.out.println(PASSWORD_NUMBER);
			//System.out.println(STRONG_PASSWORD_OPTION);
			//System.out.println(STRONG_PASSWORD_NOT_CREATED);
			
			
//			System.out.println("Please, enter the number of your password (must be an integer)");
			System.out.println(PASSWORD_NUMBER);
			
			int passwordlenght = keyboard.nextInt();		

			//int passwordlenght = 6;

			// Letter Password
			String resultset = GenaratePassword.randomWord(passwordlenght);
			System.out.println(resultset);


//			System.out.println("Please, type 1 to create also a strong password option");
			System.out.println(STRONG_PASSWORD_OPTION);
			
			int StrongPasswordChoice = keyboard.nextInt();

			if (StrongPasswordChoice != 1) {

//				System.out.println("Password was not created because you did not type 1 to create a Strong password.");				
				System.out.println(STRONG_PASSWORD_NOT_CREATED);

			} else {

				//Strong Password 
				String strongPassword = PassGen.buildPassword();
				System.out.println(strongPassword);
			}		

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
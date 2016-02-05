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

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;


public class PassGen {

	static String str;
	static int randInt;
	static StringBuilder sb;
	static List<Integer> l;


	public static String buildPassword() {


		l = new ArrayList<>();
		sb = new StringBuilder();


		//Add ASCII numbers of characters commonly acceptable in passwords
		for (int i = 33; i < 127; i++) {
			l.add(i);
		}

		//Remove characters /, \, and " as they're not commonly accepted
		l.remove(new Integer(34));
		l.remove(new Integer(47));
		l.remove(new Integer(92));

		/*Randomise over the ASCII numbers and append respective character
          values into a StringBuilder*/
		for (int i = 0; i < 10; i++) {
			randInt = l.get(new SecureRandom().nextInt(91));
			sb.append((char) randInt);
		}

		str = sb.toString();

		return str;

	}


}

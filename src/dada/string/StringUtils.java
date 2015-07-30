package dada.string;

public class StringUtils {

	public static boolean isNullOrEmpty(String s) {
		return (s == null) || (s.length() == 0);
	}

	public static String UnEscapeStr(String s) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '\\':
				if (i == s.length() - 1) { // independent \ at the end of the
											// string
					buffer.append('\\');
					break;
				}
				switch (s.charAt(i + 1)) {
				case '\\':
					buffer.append('\\');
					buffer.append('\\');
					++i;
					break;
				case '^':
					 buffer.append('^');
					++i;
					break;
				case 'x':
					if (i > s.length() - 4) {
						buffer.append('\\');
						break;
					}
					int code = Integer.parseInt(s.substring(i + 2, 2), 16);
					buffer.append((char)code);
					i += 3;
					break;
				default:
					buffer.append('\\');
				}
				break;
			case '^':
				if(i == s.length()-1) { // independent ^ at the end of the string
//	                result += '^';
					buffer.append('^');
	                break;
	            }
	            if('@' <= s.charAt(i+1) && s.charAt(i+1) <= '_') {
	                int code = s.charAt(i+1) - 64;
//	                result += String.fromCharCode(code);
	                buffer.append((char)code);
	                i++;
	            } else if(s.charAt(i+1) == '?') {
	            	buffer.append((char)0x7f);
//	                result += '\x7f';
	                i++;
	            } else {
	            	buffer.append('^');
//	                result += '^';
	            }
				break;
			default:
				buffer.append(s.charAt(i));
			}
		}
		return buffer.toString();
	}
	
	public static String fixedLengthString(String str, int length) {
		if (str.length() >= length)
			return str;
		StringBuilder builder = new StringBuilder();
		builder.append(str);
		for (int i=str.length(); i<length; i++)
			builder.append(" ");
	    return builder.toString();
	}
}

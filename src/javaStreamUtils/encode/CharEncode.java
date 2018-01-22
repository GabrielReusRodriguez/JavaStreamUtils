package javaStreamUtils.encode;

import java.nio.charset.Charset;

import javaStreamUtils.exceptions.JavaStreamUtilsException;

public enum CharEncode {

	UNKNOWN(0), UTF8(1), ISO_8859_1(2);

	private int value;

	private CharEncode(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		String encode = "UNKNOWN";
		switch (value) {
		case 1:
			encode = "UTF-8";
			break;
		case 2:
			encode ="ISO-8859-1";
			break;
		case 0:
		default:
			break;
		}
		return encode;
	}
	
	public Charset toCharset() throws JavaStreamUtilsException{
		Charset encode =  null;
		switch (value) {
		case 1:
			encode = Charset.forName("UTF-8");
			break;
		case 2:
			encode = Charset.forName("ISO-8859-1");
			break;
		case 0:
		default:
			break;
		}
		if(encode == null){
			throw new JavaStreamUtilsException("Charset Not Found");
		}else{
			return encode;
		}
	}
}

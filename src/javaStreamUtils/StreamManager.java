package javaStreamUtils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import javaStreamUtils.encode.CharEncode;
import javaStreamUtils.exceptions.JavaStreamUtilsException;

public abstract class StreamManager {
	
	private static String _stream2String(InputStream is, CharEncode encode)
			throws IOException, JavaStreamUtilsException {
		Reader reader = null;
		if (is != null) {
			Writer writer = new StringWriter();
			char[] buffer = new char[1024];
			try {
				reader = encode == null ? new BufferedReader(
						new InputStreamReader(is)) : new BufferedReader(
						new InputStreamReader(is, encode.toString()));
				int n;
				while ((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}

			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				throw new JavaStreamUtilsException(e.getMessage(), e);
			} catch (IOException e) {
				e.printStackTrace();
				throw new JavaStreamUtilsException(e.getMessage(), e);
			} finally {
				is.close();
			}
			return writer.toString();
		} else {
			return "";
		}
	}
	
	public static String stream2String(InputStream is)
			throws JavaStreamUtilsException {
		
		String retorno = null;
		try{
			retorno = _stream2String(is, null);
			return retorno;
		}catch(IOException e){
			throw new JavaStreamUtilsException(e.getMessage(),e);
		}
	}

	public static String stream2String(InputStream is, CharEncode encode)
			throws JavaStreamUtilsException {
		
		String retorno = null;
		try{
			retorno = _stream2String(is, encode);
			return retorno;
		}catch(IOException e){
			throw new JavaStreamUtilsException(e.getMessage(),e);
		}
	}

	public static InputStream string2Stream(String input, CharEncode encode)
			throws IOException {
		InputStream stream = new ByteArrayInputStream(input.getBytes(encode
				.toString()));
		return stream;
	}
	
	public static InputStream getInputStreamFromClasspath(String resourcePath,Class classFromClasspath) {
		return classFromClasspath.getClassLoader().getResourceAsStream(resourcePath);
	}
}

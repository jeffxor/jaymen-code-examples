package com.jaymen.java.certification.chp11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TextEncoder {
	private static final String DEFAULT_SOURCE_ENCODING = "8859_1";
	private static final String DEFAULT_DESTINATION_ENCODING = "UTF8";

	/**
	 * Simple application that takes for arguments the following optional arguments
	 * in the following order:
	 * 
	 * 1, input encoding type 
	 * 2, output encoding type
	 * 3, file to read from 
	 * 4, file to write to
	 *
	 * Using these arguments the application reads from the input file (or system.in) using the
	 * optional defined encoding and then writes to the output file (or system.out) in the output
	 * encoding type.
	 * 
	 * @param args String array containing the following 1, input encoding type 2, output encoding type 
	 * 3, file to read from 4, file to write to
	 */
	public static void main(String[] args) {

		try {
			String sourceEncoding = (args.length > 0) ? args[0] : DEFAULT_SOURCE_ENCODING;
			String destinationEncoding = (args.length > 1) ? args[1] : DEFAULT_DESTINATION_ENCODING;
			InputStream inputStream = (args.length > 2) ? new FileInputStream(args[2]) : System.in;
			OutputStream ouputStream = (args.length > 2) ? new FileOutputStream(args[2]) : System.out;

			encode(sourceEncoding, destinationEncoding, inputStream, ouputStream);
		} catch (FileNotFoundException e) {
			System.err.println("File not found " + e.getLocalizedMessage());
		} catch (IOException e) {
			System.err.println("I/O error occurred " + e.getLocalizedMessage());
		}

	}

	/**
	 * Takes a input steam with defined encoding and then copies the contents of the
	 * stream to the output stream re-encoding the data on output. 
	 * 
	 * @param sourceEncoding String containing the source encoding.
	 * @param destinationEncoding String containing the destination encoding.
	 * @param inputStream InputStream to read from.
	 * @param ouputStream OutputStream to write to.
	 * @throws IOException Thrown if an error occurs while reading or writing to the input or output streams.
	 */
	public static void encode(String sourceEncoding, String destinationEncoding,
			InputStream inputStream, OutputStream ouputStream) throws IOException{

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, sourceEncoding));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(ouputStream, destinationEncoding));

		// Transfer 512 chars at a time.
		char[] cbuf = new char[512];
		while (true) {
			int bytesLastRead = bufferedReader.read(cbuf);
			if (bytesLastRead == -1) break;
			bufferedWriter.write(cbuf, 0, bytesLastRead);
		}
		bufferedReader.close();
		bufferedWriter.close();
	}
}

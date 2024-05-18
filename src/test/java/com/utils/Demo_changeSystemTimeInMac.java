package com.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo_changeSystemTimeInMac {
	public static void main(String[] args) {
		// Set the new date (format: mmddHHMM[[cc]yy][.ss])
		String newDate = "051409302024"; // Change this to your desired date

		// Build the command to change the system date
		ProcessBuilder builder = new ProcessBuilder("/usr/bin/sudo", "-S", "date", newDate);

		// Redirect error stream to output stream
		builder.redirectErrorStream(true);

		try {
			// Start the process
			Process process = builder.start();

			// Provide the password to sudo
			String password = "nexon6751"; // Change this to your actual password
			process.getOutputStream().write((password + "\n").getBytes());
			process.getOutputStream().flush();

			// Read output stream
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

			// Wait for the process to finish
			int exitValue = process.waitFor();

			// Check the exit value to ensure the command was successful
			if (exitValue == 0) {
				System.out.println("System date changed successfully to " + newDate);
			} else {
				System.err.println("Failed to change system date. Exit code: " + exitValue);
			}
		} catch (IOException | InterruptedException e) {
			System.err.println("Failed to change system date: " + e.getMessage());
		}
	}
}

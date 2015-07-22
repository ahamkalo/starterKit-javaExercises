package com.capgemini.nodes;

import java.util.LinkedList;
import java.util.List;

public class ExceptionContainer extends Exception{
	private static final long serialVersionUID = 1L;
	private static List<Exception> exceptions = new LinkedList<Exception>();
	
	public static void addException(Exception exception){
		exceptions.add(exception);
	}
	
	public static boolean isNotEmpty(){
		if(exceptions.size() > 0){
			return true;
		}
		return false;
	}

	public static void removeContainExceptions() {
		exceptions.removeAll(exceptions);
	}
	
	public List<String> getErrorMessagesAndEmptyExceptionList() {
		List<String> messages = new LinkedList<String>();
		for (Exception exception : exceptions){
			messages.add(exception.getMessage());
		}
		removeContainExceptions();
		return messages;
	}

	public static List<Exception> getExceptions() {
		return exceptions;
	}
}

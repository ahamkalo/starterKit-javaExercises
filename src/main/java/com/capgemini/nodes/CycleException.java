package com.capgemini.nodes;

public class CycleException extends Exception{
	private static final long serialVersionUID = 1L;

	public String getMessage(){
		return "CycleException";
	}
}

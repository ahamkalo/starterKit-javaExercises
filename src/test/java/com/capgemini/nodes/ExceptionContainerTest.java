package com.capgemini.nodes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ExceptionContainerTest {

	@Test
	public void shouldAddIdException() {
		ExceptionContainer.addException(new IdException());
		assertEquals("IdException", ExceptionContainer.getExceptions().get(0).getMessage());
		assertEquals(1, ExceptionContainer.getExceptions().size());
		ExceptionContainer.removeContainExceptions();
	}
	@Test
	public void shouldNotBeEmpty() {
		ExceptionContainer.addException(new IdException());
		assertTrue(ExceptionContainer.isNotEmpty());
		ExceptionContainer.removeContainExceptions();
	}
	@Test
	public void shouldBeEmpty() {
		assertFalse(ExceptionContainer.isNotEmpty());
	}
	@Test
	public void shouldRemoveContainingException() {
		ExceptionContainer.addException(new IdException());
		assertTrue(ExceptionContainer.isNotEmpty());
		ExceptionContainer.removeContainExceptions();
		assertFalse(ExceptionContainer.isNotEmpty());
	}
	@Test
	public void shouldGetIdAndDescriptionExceptionsMessages() {
		List<String> errorMessages; 
		
		ExceptionContainer.addException(new IdException());
		ExceptionContainer.addException(new DescriptionException());

		errorMessages = new ExceptionContainer().getErrorMessagesAndEmptyExceptionList();
		
		assertTrue(errorMessages.contains("IdException"));
		assertTrue(errorMessages.contains("DescriptionException"));
	}
}

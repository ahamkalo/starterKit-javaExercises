package com.capgemini.nodes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class NodeValidatorsTest {
	List<Node> nodes = new ArrayList<Node>();
	NodeValidators nodeValidator = new NodeValidators();

	@Before
	public void before() {
		nodes.add(new Node("0001", "random description", "0000"));
		nodes.add(new Node("0002", "random description", "0001"));
		nodes.add(new Node("0003", "random description", "0002"));
		nodes.add(new Node("0004", "random description", "0003"));
		nodes.add(new Node("0005", "random description", "0004"));
	}

	@Test
	public void shouldNotThrowExceptionFor_Linear_Graph()
			throws ExceptionContainer {
		try {
			nodeValidator.validateMethod(nodes);
		} catch (ExceptionContainer exceptionContainer) {
			fail("should not throw exception");
		}
	}

	@Test
	public void shouldNotThrowExceptionFor_NonLinear_Graph()
			throws ExceptionContainer {
		nodes.add(new Node("0006", "random description", "0004"));
		try {
			nodeValidator.validateMethod(nodes);
		} catch (ExceptionContainer exceptionContainer) {
			fail("should not throw exception");
		}
	}

	@Test
	public void shouldThrow_Id_Exception() throws ExceptionContainer {
		nodes.get(0).setId("0");
		nodes.get(1).setPredecessorId("0");
		try {
			nodeValidator.validateMethod(nodes);
			fail("Not recognized exception: IdException");
		} catch (ExceptionContainer exceptionContainer) {
			List<String> errorMessages = exceptionContainer.getErrorMessagesAndEmptyExceptionList();

			assertTrue(errorMessages.contains("IdException"));

			assertFalse(errorMessages.contains("DescriptionException"));
			assertFalse(errorMessages.contains("CycleException"));
			assertFalse(errorMessages.contains("PenultimateException"));
		}
	}

	@Test
	public void shouldThrow_Description_Exception() throws ExceptionContainer {
		nodes.get(1).setDescription(longDescription());
		try {
			nodeValidator.validateMethod(nodes);
			fail("Not recognized exception: DescriptionException");
		} catch (ExceptionContainer exceptionContainer) {
			List<String> errorMessages = exceptionContainer.getErrorMessagesAndEmptyExceptionList();

			assertTrue(errorMessages.contains("DescriptionException"));

			assertFalse(errorMessages.contains("IdException"));
			assertFalse(errorMessages.contains("CycleException"));
			assertFalse(errorMessages.contains("PenultimateException"));
		}
	}
	
	@Test
	public void shouldThrow_Cycle_Penultimate_Exceptions() throws ExceptionContainer {
		nodes.get(0).setPredecessorId("0005");
		try {
			nodeValidator.validateMethod(nodes);
			fail("Not recognized exceptions: CycleException, PenultimateException");
		} catch (ExceptionContainer exceptionContainer) {
			List<String> errorMessages = exceptionContainer.getErrorMessagesAndEmptyExceptionList();

			assertTrue(errorMessages.contains("CycleException"));
			assertTrue(errorMessages.contains("PenultimateException"));
			
			assertFalse(errorMessages.contains("DescriptionException"));
			assertFalse(errorMessages.contains("IdException"));
		}
	}
	
	@Test
	public void shouldThrow_Penultimate_ExceptionWhenNotPenultimateHas2Subsequents() throws ExceptionContainer {
		nodes.add(new Node("0006", "random description", "0002"));
		try {
			nodeValidator.validateMethod(nodes);
			fail("Not recognized exception: PenultimateException");
		} catch (ExceptionContainer exceptionContainer) {
			List<String> errorMessages = exceptionContainer.getErrorMessagesAndEmptyExceptionList();

			assertTrue(errorMessages.contains("PenultimateException"));
			
			assertFalse(errorMessages.contains("CycleException"));
			assertFalse(errorMessages.contains("DescriptionException"));
			assertFalse(errorMessages.contains("IdException"));
		}
	}
	
	@Test
	public void shouldThrow_Penultimate_ExceptionWhenPenultimateHas3Subsequents() throws ExceptionContainer {
		nodes.add(new Node("0006", "random description", "0004"));
		nodes.add(new Node("0007", "random description", "0004"));
		try {
			nodeValidator.validateMethod(nodes);
			fail("Not recognized exception: PenultimateException");
		} catch (ExceptionContainer exceptionContainer) {
			List<String> errorMessages = exceptionContainer.getErrorMessagesAndEmptyExceptionList();

			assertTrue(errorMessages.contains("PenultimateException"));
			
			assertFalse(errorMessages.contains("CycleException"));
			assertFalse(errorMessages.contains("DescriptionException"));
			assertFalse(errorMessages.contains("IdException"));
		}
	}
	
	@Test
	public void shouldThrow_All_Exceptions() throws ExceptionContainer {
		nodes.get(0).setId("0");
		nodes.get(1).setPredecessorId("0");
		nodes.get(1).setDescription(longDescription());
		nodes.get(0).setPredecessorId("0005");
		try {
			nodeValidator.validateMethod(nodes);
			fail("Not recognized exceptions: PenultimateException, CycleException, DescriptionException, IdException");
		} catch (ExceptionContainer exceptionContainer) {
			List<String> errorMessages = exceptionContainer.getErrorMessagesAndEmptyExceptionList();

			assertTrue(errorMessages.contains("PenultimateException"));
			assertTrue(errorMessages.contains("CycleException"));
			assertTrue(errorMessages.contains("DescriptionException"));
			assertTrue(errorMessages.contains("IdException"));
		}
	}
	
	private String longDescription(){
		String description = "random description";
		while (description.length() <= 180) {
			description += description;
		}
		return description;
	}
}

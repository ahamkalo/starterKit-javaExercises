package com.capgemini.nodes;

import static org.junit.Assert.*;

import org.junit.Test;

public class NodeTest {

	@Test
	public void shouldProperlyCreateNode() {
		Node node = new Node("0001", "random description", "0000");
		assertEquals("0001", node.getId());
		assertEquals("random description", node.getDescription());
		assertEquals("0000", node.getPredecessorId());
	}

}

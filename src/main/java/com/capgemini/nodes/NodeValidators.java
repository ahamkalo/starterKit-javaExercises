package com.capgemini.nodes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldrygala on 2015-02-09.
 * <p/>
 * Write validate for
 * <ul>
 * <li>node id should have 4 characters</li>
 * <li>node description can have maximal 128 characters</li>
 * <li>no cycle</li>
 * <li>only penultimate can have two subsequent</li>
 * </ul>
 */
public class NodeValidators {

	public void validateMethod(List<Node> nodes) throws ExceptionContainer {
		validateIdLength(nodes);
		validateDescriptionLength(nodes);
		validateCycle(nodes);
		validatePenultimate(nodes);

		if (ExceptionContainer.isNotEmpty()) {
			throw new ExceptionContainer();
		}
	}

	private void validateIdLength(List<Node> nodes) {
		try {
			if (isNodeWithWrongIdLengthAmong(nodes)) {
				throw new IdException();
			}
		} catch (IdException e) {
			ExceptionContainer.addException(e);
		}
	}

	private void validateDescriptionLength(List<Node> nodes) {
		try {
			if (isNodeWithTooLongDescriptionAmong(nodes)) {
				throw new DescriptionException();
			}
		} catch (DescriptionException e) {
			ExceptionContainer.addException(e);
		}

	}

	private void validateCycle(List<Node> nodes) {
		try {
			if (isCycle(nodes)) {
				throw new CycleException();
			}
		} catch (CycleException e) {
			ExceptionContainer.addException(e);
		}

	}
	
	private void validatePenultimate(List<Node> nodes) {
		try {
			if (isCycle(nodes)) {
				throw new PenultimateException();
			}
			
			List<Node> nodesWithNoSubsequents = getNodesWithNoSubsequentsFrom(nodes);

			switch (nodesWithNoSubsequents.size()) {
			case 2:
				if (nodesHaveDifferentPredecessorId(nodesWithNoSubsequents)) {
					throw new PenultimateException();
				}
				break;
			case 1:
				break;
			default:
				throw new PenultimateException();
			}
		} catch (PenultimateException e) {
			ExceptionContainer.addException(e);
		}
	}
	
	private boolean isNodeWithWrongIdLengthAmong(List<Node> nodes) {
		for (Node node : nodes) {
			if (node.getId().length() != 4) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isNodeWithTooLongDescriptionAmong(List<Node> nodes) {
		for (Node node : nodes) {
			if (node.getDescription().length() > 180) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isCycle(List<Node> nodes) {
		for (Node node : nodes) {
			if (node.getPredecessorId().equals("0000")) {
				return false;
			}
		}
		return true;
	}
	
	//poprawic
	
	private List<Node> getNodesWithNoSubsequentsFrom(List<Node> nodes){
		List<Node> nodesWithNoSubsequents = new ArrayList<Node>();
		boolean isPredecessor = false;
		for (Node node : nodes) {
			for (Node node2 : nodes) {
				if ((node.getId().equals(node2.getPredecessorId()))) {
					isPredecessor = true;
				}
			}
			if (!isPredecessor) {
				nodesWithNoSubsequents.add(node);

			}
			isPredecessor = false;
		}
		return nodesWithNoSubsequents;
	}
	
	private boolean nodesHaveDifferentPredecessorId(List<Node> nodes){
		if (nodes.get(0).getPredecessorId() != nodes.get(1).getPredecessorId()){
			return true;
		}
		return false;
	}
}

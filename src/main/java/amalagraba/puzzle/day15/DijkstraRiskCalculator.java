package amalagraba.puzzle.day15;

import amalagraba.common.grid.Grid;
import amalagraba.common.grid.IntPoint;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class DijkstraRiskCalculator {

    private final Grid<IntPoint> grid;
    private final Map<IntPoint, Node> nodes;

    private final Set<Node> settledNodes = new HashSet<>();
    private final Set<Node> unsettledNodes = new HashSet<>();

    public DijkstraRiskCalculator(Grid<IntPoint> grid) {
        this.grid = grid;
        this.nodes = new HashMap<>(grid.size());
    }

    public long calculateLowestRisk() {
        getNode(0, 0).ifPresent(this::computeNodeDistances);

        return getLastNodeDistance();
    }

    private void computeNodeDistances(Node sourceNode) {
        sourceNode.setDistance(0);
        unsettledNodes.add(sourceNode);

        computeNodeDistances();
    }

    private void computeNodeDistances() {
        Node node;

        while ((node = getClosestNode()) != null) {
            removeUnsettled(node);
            evaluateAdjacentNodes(node);
            settle(node);
        }
    }

    private Long getLastNodeDistance() {
        return getNode(grid.rows() - 1, grid.columns() - 1).map(Node::getDistance).orElse(0L);
    }

    private Node getClosestNode() {
        return unsettledNodes.stream().min(Comparator.comparing(Node::getDistance)).orElse(null);
    }

    private void evaluateAdjacentNodes(Node node) {
        for (Node adjacentNode : node.getAdjacentNodes()) {
            if (!settledNodes.contains(adjacentNode)) {
                calculateMinimumDistance(adjacentNode, node);
                unsettledNodes.add(adjacentNode);
            }
        }
    }

    private void calculateMinimumDistance(Node adjacentNode, Node node) {
        Long sourceDistance = node.getDistance();
        Integer nextDistance = adjacentNode.getPoint().getValue();

        if (sourceDistance + nextDistance < adjacentNode.getDistance()) {
            adjacentNode.setDistance(sourceDistance + nextDistance);
        }
    }

    private void settle(Node node) {
        settledNodes.add(node);
    }

    private void removeUnsettled(Node node) {
        unsettledNodes.remove(node);
    }

    private Optional<Node> getNode(int x, int y) {
        if (nodes.isEmpty() && !grid.isEmpty()) {
            initializeNode();
        }
        return grid.pointAt(x, y).map(nodes::get);
    }

    private void initializeNode() {
        for (IntPoint point : grid) {
            nodes.computeIfAbsent(point, Node::new);
        }
        setAdjacentNodes();
    }

    private void setAdjacentNodes() {
        for (IntPoint point : grid) {
            nodes.get(point).setAdjacentNodes(grid.getHorizontalAndVerticalNeighbours(point).stream()
                    .map(nodes::get)
                    .collect(Collectors.toSet()));
        }
    }

    @Data
    @EqualsAndHashCode(of = "point")
    private static class Node {

        private final IntPoint point;
        private Set<Node> adjacentNodes;

        private long distance = Long.MAX_VALUE;
    }
}
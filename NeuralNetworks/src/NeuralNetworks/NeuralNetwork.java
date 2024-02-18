package NeuralNetworks;

import java.util.Scanner;

public class NeuralNetwork{
	private int layers;
    private int[] nodesInLayer;
    private Edge[][] edges;

    public NeuralNetwork(int layers, int[] nodesInLayer) {
        this.layers = layers;
        this.nodesInLayer = nodesInLayer;
        this.edges = new Edge[layers - 1][];
        for (int i = 0; i < layers - 1; i++) {
            edges[i] = new Edge[nodesInLayer[i] * nodesInLayer[i + 1]];
            for (int j = 0; j < nodesInLayer[i]; j++) {
                for (int k = 0; k < nodesInLayer[i + 1]; k++) {
                    int sourceNode = i * nodesInLayer[i] + j + 1;
                    int destinationNode = (i + 1) * nodesInLayer[i + 1] + k + 1;
                    edges[i][j * nodesInLayer[i + 1] + k] = new Edge(sourceNode, destinationNode);
                }
            }
        }
    }
    public void setWeight(int sourceNode, int destinationNode, double weight) {
        for (int i = 0; i < layers - 1; i++) {
            for (int j = 0; j < nodesInLayer[i] * nodesInLayer[i + 1]; j++) {
                if (edges[i][j].getSourceNode() == sourceNode && edges[i][j].getDestinationNode() == destinationNode) {
                    edges[i][j].setWeight(weight);
                    return;
                }
            }
        }
    }
    public void setWeightsUser(Scanner scanner) {
    	for (int i = 0; i < layers - 1; i++) {
            for (int j = 0; j < nodesInLayer[i]; j++) {
                for (int k = 0; k < nodesInLayer[i + 1]; k++) {
                    System.out.printf("Enter weight for edge (%d, %d): ",
                            i * nodesInLayer[i] + j + 1,
                            (i + 1) * nodesInLayer[i + 1] + k + 1);
                    double weight = scanner.nextDouble();
                    setWeight(i * nodesInLayer[i] + j + 1,
                            (i + 1) * nodesInLayer[i + 1] + k + 1, weight);
                }
            }
        }
    }


    public static int getLayerIndex(int node, int[] nodesInLayer) {
        for (int i = 0; i < nodesInLayer.length - 1; i++) {
            int layerSize = nodesInLayer[i];
            if (node <= layerSize) {
                return i;
            }
            node -= layerSize;
        }
        return nodesInLayer.length - 1;
    }
    public double getWeight(int sourceNode, int destinationNode) {
        int layerOfSourceNode = getLayerIndex(sourceNode, nodesInLayer);
        int layerOfDestinationNode = getLayerIndex(destinationNode, nodesInLayer);
        if (layerOfSourceNode == layerOfDestinationNode) {
            throw new IllegalArgumentException("Source and destination nodes are in the same layer.");
        }
        int layerSizeSource = nodesInLayer[layerOfSourceNode];
        int layerSizeDestination = nodesInLayer[layerOfDestinationNode];
        
        int index = (destinationNode - layerSizeSource - 1) * nodesInLayer[layerOfDestinationNode] + (sourceNode - 1);
        
        if (layerOfSourceNode < layerOfDestinationNode) {
            return edges[layerOfSourceNode][index].getWeight();
        } else {
            return edges[layerOfDestinationNode][index].getWeight();
        }
    }}

    

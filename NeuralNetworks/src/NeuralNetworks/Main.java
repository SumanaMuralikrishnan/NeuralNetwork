package NeuralNetworks;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter the number of layers: ");
	        int layers = scanner.nextInt();

	        int[] nodesInLayer = new int[layers];
	        for (int i = 0; i < layers; i++) {
	            System.out.printf("Enter the number of nodes in layer %d: ", i + 1);
	            nodesInLayer[i] = scanner.nextInt();
	        }

	        NeuralNetwork neuralNetwork = new NeuralNetwork(layers, nodesInLayer);

	        
	        neuralNetwork.setWeightsUser(scanner);

	        System.out.print("Enter source node: ");
	        int sourceNode = scanner.nextInt();

	        System.out.print("Enter destination node: ");
	        int destinationNode = scanner.nextInt();

	        double edgeWeight = neuralNetwork.getWeight(sourceNode, destinationNode);
	        System.out.printf("Weight of edge (%d, %d): %.2f\n", sourceNode, destinationNode, edgeWeight);
	    }

	}



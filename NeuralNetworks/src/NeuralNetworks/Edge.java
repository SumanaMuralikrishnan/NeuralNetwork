package NeuralNetworks;
public class Edge {
	 private int sourceNode;
	    private int destinationNode;
	    private double weight;

	    public Edge(int sourceNode, int destinationNode) {
	        this.sourceNode = sourceNode;
	        this.destinationNode = destinationNode;
	        this.weight = 0.0; 
	    }

	    public void setWeight(double weight) {
	        this.weight = weight;
	    }

	    public double getWeight() {
	        return weight;
	    }
	    public int getSourceNode() {
	        return sourceNode;
	    }

	    public int getDestinationNode() {
	        return destinationNode;
	    }


}

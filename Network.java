/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package annproj;


import java.util.ArrayList;

/**
 *
 * @author conlejd
 */
public final class Network {
    private ArrayList<Double> inputs;
    private ArrayList<Double> output;
    private ArrayList<ArrayList<Node>> network;
    private int inputSize,layerSize,layers,numOutputs;
    Network(int numInputs, int layers, int layerSize,int numOutputs){
        this.layers = layers;
        this.numOutputs = numOutputs;
        this.layerSize = layerSize;
        this.inputSize = numInputs;
        
        inputs = new ArrayList(numInputs);
        output = new ArrayList<Double>(numOutputs);
        for(int i = 0; i<numOutputs; i++){
            output.add(0d);
        }
        network = new ArrayList<ArrayList<Node>>(layers);
        
        network.add(new ArrayList<Node>(inputSize));
        for(int i = 1; i < layers-1; i++){
            network.add( new ArrayList<Node>(layerSize));
        }
        network.add( new ArrayList<Node>(numOutputs));
        //TIE INTO THE MATRIX
        connectNodes();
    }
   /**
     * setInput - set the list of inputs for the network
     * @param inputs 
     */
    public boolean setInput(ArrayList<Double> inputs){
        if(inputs.size() != inputSize)return false;
        this.inputs = inputs;
        return true;
    }
    /**
     * TIE INTO THE MATRIX
     */
    public void connectNodes(){
        for(int i = 0; i < inputSize; i++){
            network.get(0).add(new InputNode());
        }
        
        for(int i = 1; i < layers; i++){
            
            for(int j = 0; j < layerSize; j++){
                
                network.get(i).add(new Node(network.get(i-1)));
            }
            
        }
        
    }
    // Set the inputs of all the input nodes to match the inputs arraylist in this class,and then
    // Calculate the outputs for the network
    public ArrayList<Double> calculateOutput(){
        for(int i = 0; i < inputSize; i++){
            network.get(0).get(i).setInput(inputs.get(i));
        }
        //Make it go through each node in the network and calculate output for each of them top down
        for(int i = 0; i < numOutputs; i++){
            output.set(i, network.get(layers-1).get(i).calculateOutput());
        }
        return output;
    }
    public int getSize(){
        return network.size();
    }
    public ArrayList<Double> getOutput(){
        return output;
    }
    public void setInput(int index, double value){
        inputs.set(index, value);
    }
    public boolean training(ArrayList<Double> testInputs, ArrayList<Double> testOutputs){
        if((testInputs.size() != inputSize) || (testOutputs.size() != numOutputs))return false;
        //Outputs nodes
        return true;
    }
    
}

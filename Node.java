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
public class Node {
    ArrayList<Double> weights = new ArrayList();
    ArrayList<Node> inputs;
    private double output;
    /**
     * 
     * @param inputs 
     */
    Node(){   
    }
    Node(ArrayList<Node> inputs){
        
        this.inputs = inputs;
        for(int i = 0; i < inputs.size(); i++){
            weights.add(1D);
        }
    }
    public double calculateOutput(){
        double temp = 0;
        for(int i = 0; i < inputs.size(); i++){
            temp+=inputs.get(i).emit() * weights.get(i);
        }
//        System.out.println(inputs.get(0) + " and " + inputs.size());
        temp/=inputs.size();
        temp = activationFunction(temp);
        output = temp;
        return output;
    }
    public double emit(){
        return output;
    }
    public void setInput(double i){
        
    }
    /**
     * Activation Function for the node in the node in the network - default a signmoid function
     * @param input - the average of the weighted sum of the inputs to the node
     * @return - the output of the activation function
     */
    public double activationFunction(double input){
        return 1/(1+Math.pow(Math.E, -input));
        
    }
    /**
     * Gets the number of inputs for this node
     * @return - int - the number of inputs
     */
    public int getSize(){
        return inputs.size();
    }
    /**
     * Set the weight for 
     * @param node
     * @param weight
     * @return 
     */
    public boolean setWeight(Node node, double weight){
        if(inputs.indexOf(node) == -1)return false;
        weights.set(inputs.indexOf(node), weight);
        return true;
    }
}

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
public class ANNProj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Network net = new Network(5,5,5,5);
        System.out.println(net.getSize());
        ArrayList<Double> inputs = new ArrayList<Double>();
        for(int i = 0; i < 5; i++){
            inputs.add(.5);
        }
        net.setInput(inputs);
        ArrayList<Double> output = net.calculateOutput();
        for(Double num : output){
            System.out.println(num.doubleValue());
        }
    }
}

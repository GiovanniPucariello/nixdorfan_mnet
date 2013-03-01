/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bite.framework.bootstrap.impl;

/**
 *
 * @author nixdorfan
 */
public class ConsoleValuesPreparator {
    
    public static String prepare(String[] args){
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<args.length;i++){
            if(i==0){
                builder.append(args[i]);
            } else {
                builder.append("@@@" + args[i] );
            }
        }
        return builder.toString();
    }
}

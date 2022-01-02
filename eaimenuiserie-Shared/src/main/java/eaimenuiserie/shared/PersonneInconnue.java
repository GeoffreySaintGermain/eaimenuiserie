/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eaimenuiserie.shared;

/**
 *
 * @author Kevin
 */
public class PersonneInconnue extends Exception {

    /**
     * Creates a new instance of <code>PersonneInconnue</code> without detail
     * message.
     */
    public PersonneInconnue() {
    }

    /**
     * Constructs an instance of <code>PersonneInconnue</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PersonneInconnue(String msg) {
        super(msg);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admon;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Carlos Loaeza
 */
@Named(value = "cAlimento")
@SessionScoped
public class CAlimento implements Serializable {

    /**
     * Creates a new instance of CAlimento
     */
    public CAlimento() {
    }
    
}

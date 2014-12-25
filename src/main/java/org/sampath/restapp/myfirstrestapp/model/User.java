/*
 * Project : MyFirstRestApp
 * Description: First JAX-RS application , Imported JAXB
 * Date: 7/12/2014
 */

package org.sampath.restapp.myfirstrestapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SAMPATH
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class User {

    private Integer id;
    private String name;

    public User() {
        super();
    }

    public User(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

}

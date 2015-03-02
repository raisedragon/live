/**
 * 
 */
package com.winit.common.spi.command;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * @author Liuye
 *
 */
public class IdCommand<ID extends Serializable> extends SPICommand {
    @NotNull
    private ID id;

    public IdCommand(){}

    public IdCommand(ID id){
        this.id=id;
    }

    public ID getId() {
        return id;
    }


    public void setId(ID id) {
        this.id = id;
    }
}

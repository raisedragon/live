/**
 * 
 */
package com.winit.common.spi.command;

import java.io.Serializable;

/**
 * @author Liuye
 *
 */
public class DeleteCommand<ID extends Serializable> extends IdCommand<ID> {
    public DeleteCommand(){}

    public DeleteCommand(ID id){
        super(id);
    }
}

/**
 * 
 */
package com.winit.common.spi.command;

import java.io.Serializable;

/**
 * @author Liuye
 *
 */
public class GetCommand<ID extends Serializable> extends IdCommand<ID> {
    public GetCommand(){}

    public GetCommand(ID id){
        super(id);
    }
}

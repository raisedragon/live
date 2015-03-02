package com.winit.common.spi.command;

public class UpdateCommand<VO> extends VOCommand<VO> {
    public UpdateCommand(){}

    public UpdateCommand(VO vo){
        super(vo);
    }
}

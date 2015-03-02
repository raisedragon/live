package com.winit.common.spi.command;

public class CreateCommand<VO> extends VOCommand<VO> {
    public CreateCommand(){}

    public CreateCommand(VO vo){
        super(vo);
    }
}

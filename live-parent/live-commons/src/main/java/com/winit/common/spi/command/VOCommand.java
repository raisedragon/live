package com.winit.common.spi.command;

import javax.validation.constraints.NotNull;

public class VOCommand<VO> extends SPICommand {
    @NotNull
    private VO vo;
    public VOCommand(){}

    public VOCommand(VO vo){
        this.vo=vo;
    }

    public VO getVo() {
        return vo;
    }


    public void setVo(VO vo) {
        this.vo = vo;
    }
}

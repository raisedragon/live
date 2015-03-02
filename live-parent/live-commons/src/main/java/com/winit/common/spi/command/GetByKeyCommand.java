package com.winit.common.spi.command;

import java.io.Serializable;

import com.winit.common.spi.command.SPICommand;

/**
 * 根据关键字查询 服务命令
 * 
 * @author yu.zhang
 * @param <SearchKey>
 */
public class GetByKeyCommand<SearchKey extends Serializable> extends SPICommand {

    private static final long serialVersionUID = -7514731221303306792L;
    // 查询关键字
    private SearchKey         searchKey;

    public SearchKey getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(SearchKey searchKey) {
        this.searchKey = searchKey;
    }

}

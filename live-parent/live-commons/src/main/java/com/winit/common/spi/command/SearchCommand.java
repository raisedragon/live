package com.winit.common.spi.command;

import com.winit.common.query.Searchable;

public class SearchCommand extends SPICommand {

	private Searchable searchable;
    public SearchCommand(){}

    public SearchCommand(Searchable searchable){
        this.searchable=searchable;
    }

    public Searchable getSearchable() {
        return searchable;
    }

    public void setSearchable(Searchable searchable) {
        this.searchable = searchable;
    }
}

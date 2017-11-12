package com.cs4227.ui.models;

public class ExplorerSaveStrategyModel implements ExplorerModel{
    boolean isExplorerOpen;

    public void open() {
        isExplorerOpen = true;
    }

    public void close() {
        isExplorerOpen = false;
    }

    public boolean getIsExplorerOpen(){
        return isExplorerOpen;
    }
}

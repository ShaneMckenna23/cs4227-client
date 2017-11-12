package com.cs4227.framework.filters;

public class FilterFactory {

    public Filter createFilter(String filterType){
        switch (filterType){
            case "Monochrome":
                Filter monochrome = new Monochrome();
                return monochrome;
        }
        return null;
    }
}

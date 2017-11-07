package com.cs4227.framework.filters;

import com.cs4227.framework.filters.Monochrome;

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

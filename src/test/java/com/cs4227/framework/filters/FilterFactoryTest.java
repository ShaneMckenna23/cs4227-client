package com.cs4227.framework.filters;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

public class FilterFactoryTest {

    FilterFactory filterFactory;

    @Before
    public void setup(){
        filterFactory = new FilterFactory();
    }

    @Test
    public void createMonochromeFilter(){
        Filter monochromeFilter = filterFactory.createFilter("Monochrome");
        assertThat(monochromeFilter.filterAPI, instanceOf(Monochrome.class));
    }

    @Test
    public void createRedFilter(){
        Filter redFilter = filterFactory.createFilter("Monochrome");
        assertThat(redFilter.filterAPI, instanceOf(RedFilter.class));
    }

    @Test
    public void createBlueFilter(){
        Filter blueFilter = filterFactory.createFilter("Monochrome");
        assertThat(blueFilter.filterAPI, instanceOf(BlueFilter.class));
    }

    @Test
    public void createGreenFilter(){
        Filter greenFilter = filterFactory.createFilter("Monochrome");
        assertThat(greenFilter.filterAPI, instanceOf(GreenFilter.class));
    }
}

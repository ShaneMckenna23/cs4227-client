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
    public void createMonochtromeFilter(){
        Filter monochromeFilter = filterFactory.createFilter("Monochrome");
        assertThat(monochromeFilter, instanceOf(Monochrome.class));
    }
}

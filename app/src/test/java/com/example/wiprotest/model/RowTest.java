package com.example.wiprotest.model;

import com.example.wiprotest.ui.main.model.Row;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

/**
 * Created by jbathula on 22,November,2019
 */
@RunWith(JUnit4.class)
public class RowTest {
    @Test
    public void testTitle(){
        Row row = new Row();
        row.setTitle("Beavers ");
        assertEquals(row.getTitle(), "Beavers ");
    }
    @Test
    public void testDescription(){
        Row row = new Row();
        row.setTitle("Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony");
        assertEquals(row.getTitle(), "Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony");
    }

    @Test
    public void testImageUrl(){
        Row row = new Row();
        row.setImageHref("http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg");
        assertEquals(row.getImageHref(), "http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg");
    }


}

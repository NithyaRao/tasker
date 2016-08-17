package com.nrmj.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.text.SimpleDateFormat;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class TaskTest {
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateAnInstanceOfTask() throws Exception {
        Task t = new Task();
        assertThat(t, instanceOf(Task.class));
        assertTrue(t.getCreatedAt().getTime() > 0);
        assertTrue(t.getUpdatedAt().getTime() > 0);
    }

    @Test
    public void shouldGetAndSetIdOnTask() throws Exception {

        Task t = new Task();
        t.setId(3);
        assertEquals(3, t.getId());
    }

    @Test
    public void shouldGetAndSetNameOnTask() throws Exception {

        Task t = new Task();
        t.setName("Get Milk");
        assertEquals("Get Milk", t.getName());
    }

    @Test
    public void shouldGetAndSetCategoryOnTask() throws Exception {

        Task t = new Task();
        t.setCategory("Home");
        assertEquals("Home", t.getCategory());
    }

    @Test
    public void shouldGetAndSetDueOnTask() throws Exception {

        Task t = new Task();
        t.setDue(format.parse("2015-03-11"));
        assertEquals("Wed Mar 11 00:00:00 CDT 2015", t.getDue().toString());
    }

    @Test
    public void shouldGetAndSetIsCompleteOnTask() throws Exception {

        Task t = new Task();
        t.setComplete(true);
        assertEquals(true, t.getComplete());
    }

    @Test
    public void shouldGetAndSetCreatedAtOnTask() throws Exception {

        Task t = new Task();
        t.setCreatedAt(format.parse("2015-03-11"));
        assertEquals("Wed Mar 11 00:00:00 CDT 2015", t.getCreatedAt().toString());
    }

    @Test
    public void shouldGetAndSetUpdatedAtOnTask() throws Exception {

        Task t = new Task();
        t.setUpdatedAt(format.parse("2015-03-11"));
        assertEquals("Wed Mar 11 00:00:00 CDT 2015", t.getUpdatedAt().toString());
    }

    @Test
    public void shouldUpdateTheTimeOnTask() throws Exception {

        Task t = new Task();
        t.setUpdatedAt(null);
        t.updateTime();
        assertTrue(t.getUpdatedAt().getTime() > 0);
    }


}
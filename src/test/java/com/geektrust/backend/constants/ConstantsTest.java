package com.geektrust.backend.constants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;


public class ConstantsTest {

    @Test
    public void testGetValues(){
        assertEquals("ACCEPTED", Constants.getValue("ACCEPTED"));
        assertEquals("REJECTED", Constants.getValue("REJECTED"));
        assertNotEquals("ADD-COURSE-OFFERING", Constants.getValue("ALLOT-COURSE"));
        assertEquals("ALLOT-COURSE",Constants.getValue("ALLOT-COURSE"));
        assertEquals("ADD-COURSE-OFFERING",Constants.getValue("ADD-COURSE-OFFERING"));
    }
}

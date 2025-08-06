package com.api.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.api.utils.Log;

public class Hooks {

    @Before
    public void setUp() {
        Log.info("Test Started");
    }

    @After
    public void tearDown(Scenario scenario) {
        Log.info("Test Finished: " + scenario.getName());
    }
}

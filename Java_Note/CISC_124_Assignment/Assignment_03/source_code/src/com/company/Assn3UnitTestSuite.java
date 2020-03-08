package com.company;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses( { PizzaTest.class, LineItemTest.class } )
public class Assn3UnitTestSuite {

}

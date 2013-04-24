package com.wonders.utils;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) 
public abstract class AbstractSpringTest extends AbstractTestNGSpringContextTests{

}
 
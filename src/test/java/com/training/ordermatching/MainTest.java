package com.training.ordermatching;

import com.training.ordermatching.controller.FileControllerTest;
import com.training.ordermatching.controller.OrderControllerTest;
import com.training.ordermatching.controller.SymbolControllerTest;
import com.training.ordermatching.controller.UserControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses(value = { UserControllerTest.class,FileControllerTest.class, OrderControllerTest.class, SymbolControllerTest.class })
public class MainTest {
}

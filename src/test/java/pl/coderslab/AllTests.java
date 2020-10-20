package pl.coderslab;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.coderslab.Services.BookServiceTest;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CalculatorTest.class, BookServiceTest.class, BookServiceTest.class })
public class AllTests {
}

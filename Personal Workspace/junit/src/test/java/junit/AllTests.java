package junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ArrayCompareTest.class, StringHelperParameterizedTest.class })
public class AllTests {
	/*
	 * ArrayCompareTest.class, StringHelperParameterizedTest.class are the test
	 * classes that would run in this suite
	 */
}
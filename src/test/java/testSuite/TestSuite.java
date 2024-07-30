package testSuite;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import category.SanityTests;
import category.SmokeTest;
import testCases.DeliveryChallanTestCases;

@RunWith(Categories.class)
@Categories.IncludeCategory({SmokeTest.class, SanityTests.class})
@Suite.SuiteClasses({DeliveryChallanTestCases.class})
public class TestSuite {

}

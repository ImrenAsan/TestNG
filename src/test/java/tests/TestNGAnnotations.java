package tests;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeMethod

    public void beforeMethod (){
        System.out.println("This is Before Method!");
    }

    @BeforeClass
    public void beforeClass (){
        System.out.println("This is Before Class only once");
    }

    @Ignore
    @Test (priority = 1) // oncelik olarak bu testi calistirir.
    public void test1(){
        System.out.println("This is test1 method");
    }

    @Test
    public void test2(){
        System.out.println("This is test 2 method");
    }

    @Ignore
    @Test
    //How do you skip the tests? We use @Ignore Annotation to skip certain cases.
    public void test3(){
        System.out.println("This is test3 method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("This is after class and runs only once");
    }

}

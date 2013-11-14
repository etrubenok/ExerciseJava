package javaTest;



import com.etrubenok.java.LanguageChecks;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class LanguageChecksTest {

    LanguageChecks languageChecks = null;

    @Before
    public void before() throws Exception {
        languageChecks = new LanguageChecks();
    }

    @After
    public void after() throws Exception {

    }

    @Test
    public void overloadTest() throws Exception {
        int i1 = 10;
        int r1 = languageChecks.overload(i1);
        assert(r1 == 10);
        assert(i1 == 10);
    }

    @Test
    public void overloadTest2() throws Exception {

        int i1 = 10;
        int r2 = languageChecks.overload(i1,3);
        assert(r2 == 30);
        assert(i1 == 10);
    }

    @Test
    public void multiplyTest() throws Exception {
        AtomicInteger i1 = new AtomicInteger(10);
        AtomicInteger r = languageChecks.multiply(i1, new AtomicInteger(3));
        assert(r.get() == 30);
        assert(i1.get() == 5);
    }
}

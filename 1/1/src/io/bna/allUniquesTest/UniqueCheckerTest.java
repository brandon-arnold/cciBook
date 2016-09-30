package io.bna.allUniquesTest;

import io.bna.allUniques.UniqueChecker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by brandon on 3/23/16.
 */
public class UniqueCheckerTest {

    UniqueChecker checker = new UniqueChecker();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void aaIsFalse() throws Exception {
        assertEquals(checker.check("aa"), false);
    }

    @Test
    public void abIsTrue() throws Exception {
        assertEquals(checker.check("ab"), true);
    }

    @Test
    public void abcdefghijklmnopqrstuvwxyzIsTrue() throws Exception {
        assertEquals(checker.check("abcdefghijklmnopqrstuvwxyz"), true);
    }

    @Test
    public void aabcdefghijklmnopqrstuvwxyzIsFalse() throws Exception {
        assertEquals(checker.check("aabcdefghijklmnopqrstuvwxyz"), false);
    }
}
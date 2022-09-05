import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void CheckAllLitteralSymbols() {
        assertEquals("fwdkgjwep", Solution.splitIsNeeded("pewjgkdwf",false));
    }

    @Test
    void CheckAllNonLitteralSymbols() {
        assertEquals("432412805#$*()@(!)вацвпцупцйу74192#)($&*!@($&!@($($@&!)$*@!", Solution.splitIsNeeded("432412805#$*()@(!)вацвпцупцйу74192#)($&*!@($&!@($($@&!)$*@!",false));
    }

    @Test
    void CheckStringWithLitteralAndNonLitteralSymbols() {
        assertEquals("d1cba", Solution.splitIsNeeded("a1bcd", false));
    }
    @Test
    void CheckMoreThanOneWordWithSplit() {
        assertEquals("d1cba hgf!e", Solution.splitIsNeeded("a1bcd efg!h",true));
    }

    @Test
    void CheckMoreThanOneWordWithOutSplit() {
        assertEquals("h1gfe dcb!a", Solution.splitIsNeeded("a1bcd efg!h",false));
    }
}
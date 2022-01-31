import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class TestResultLogger implements TestWatcher {
    Log log =new Log();

    @Override
    public void testSuccessful(ExtensionContext context) {
    String testName=context.getDisplayName();
    log.info(testName+"Passed");
    }



    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName=context.getDisplayName();
        String testFailCause=cause.getMessage();
        log.error(testName+"Failed with cause: "+testFailCause);
    }
}

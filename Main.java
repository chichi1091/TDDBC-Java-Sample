import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.engine.discovery.ClassNameFilter.*;
import java.io.PrintWriter;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import org.junit.platform.launcher.TestExecutionListener;

public class Main {
  // public static void main(String[] args) {
  //   // TestRunner tr = new TestRunner();
  //   // tr.main();
    
  // }

    public static void main(String... args) {
            LauncherDiscoveryRequest request =
            LauncherDiscoveryRequestBuilder
                .request()
                   .selectors(selectPackage("com"))
                // .selectors(selectPackage("com"),selectPackage("sample"))
                // .selectors(selectClass(sample.SampleTest.class))
                // .selectors(selectClass(SampleTest2.class))
                //  .selectors(selectClass(com.SampleTest3.class))
                // .selectors(selectPackage("com.xyz.s3util"),
                //            selectClass(S3ManualTest.class),
                //            selectMethod(S3ManualTest.class, "happyPath")
                // )
                .build();

        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        launcher.execute(request, listener);
    

        // System.out.println("# of containers found: " + summary.getContainersFoundCount());
        // System.out.println("# of containers skipped: " + summary.getContainersSkippedCount());
        // System.out.println("# of tests found: " + summary.getTestsFoundCount());
        // System.out.println("# of tests skipped: " + summary.getTestsSkippedCount());

        // Launcher launcher = LauncherFactory.create();
// TestExecutionListener listener = new SummaryGeneratingListener();
// launcher.registerTestExecutionListeners(listener);
// launcher.execute(request);

    TestExecutionSummary summary = listener.getSummary();
  
   summary.printTo(new PrintWriter(System.out));
        summary.printFailuresTo(new PrintWriter(System.err));
       
  }
}
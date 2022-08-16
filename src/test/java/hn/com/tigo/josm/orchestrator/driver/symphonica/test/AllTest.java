package hn.com.tigo.josm.orchestrator.driver.symphonica.test;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({SymphonicaWorkflowOrderOperationTest.class,
	SymphonicaServiceOrderOperationTest.class,	
	EventBrokerNotificationOperationTest.class,
	            })

public class AllTest {

	@AfterClass
	public static void tearDownAfterClass() throws IOException {
		EjbContainerContext.INSTANCE.close();
	}
}

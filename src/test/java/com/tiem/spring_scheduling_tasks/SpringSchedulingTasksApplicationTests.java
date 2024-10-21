package com.tiem.spring_scheduling_tasks;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

import org.awaitility.Durations;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest
class SpringSchedulingTasksApplicationTests {

	@SpyBean
	ScheduleTasks tasks;

	@Test
	public void reportCurrentTime() {
		await().atMost(Durations.TEN_SECONDS).untilAsserted(() -> {
			verify(tasks, atLeast(2)).reportCurrentTime();
		});
	}
}

/*
 * This annotation tells Spring Boot to load the full application context for
 * the test. It allows for integration testing by starting the application
 * context, making it useful when you need to test more than just a simple unit
 * (e.g., when you need to test scheduled tasks, database interactions, or other
 * Spring-managed components). 2. Class Declaration: java Copy code class
 * SpringSchedulingTasksApplicationTests { This is a test class that tests the
 * behavior of a Spring Boot application. The class name indicates it is focused
 * on testing tasks related to scheduling in a Spring Boot application.
 * 3. @SpyBean Annotation java Copy code
 * 
 * @SpyBean ScheduleTasks tasks;
 * 
 * @SpyBean is a Spring annotation used to inject a spy of a Spring-managed bean
 * into the test. Spies allow you to mock parts of the object’s behavior while
 * still allowing the original object to function as normal. In this case,
 * ScheduleTasks is a Spring-managed bean, likely representing a class that
 * performs scheduled tasks (e.g., using @Scheduled). The spy is used to monitor
 * the behavior of the reportCurrentTime() method to ensure it behaves as
 * expected during the test. 4. Test Method: reportCurrentTime() java Copy code
 * 
 * @Test public void reportCurrentTime() { The @Test annotation indicates that
 * this is a test method. This method will be executed as part of the test
 * suite. The purpose of the test is to verify that the reportCurrentTime()
 * method from ScheduleTasks is called at least twice within a specified period
 * (10 seconds). 5. Awaitility await() Statement java Copy code
 * await().atMost(Durations.TEN_SECONDS).untilAsserted(() -> { This line uses
 * the Awaitility library to wait for a condition to become true. Awaitility is
 * often used in testing scenarios where asynchronous operations (like
 * scheduling) are involved. In this case, the test waits for up to 10 seconds
 * for the verification to succeed. Durations.TEN_SECONDS is a constant provided
 * by Awaitility to specify a maximum wait time of 10 seconds. untilAsserted()
 * is a method that retries the assertion (the verify() call) until the
 * condition becomes true or the maximum time elapses. 6. Verifying the Method
 * Call with Mockito verify() java Copy code verify(tasks,
 * atLeast(2)).reportCurrentTime(); Mockito’s verify() method checks whether a
 * particular method was called on a mock or spy object during the test. Here,
 * the test verifies that the reportCurrentTime() method of the tasks object
 * (which is a spy of the ScheduleTasks bean) was called at least 2 times within
 * the 10-second window. atLeast(2) is a Mockito matcher that ensures the method
 * was called at least 2 times, meaning it could be called more, but 2 is the
 * minimum requirement. Full Explanation: The test aims to ensure that the
 * reportCurrentTime() method of the ScheduleTasks class is invoked at least
 * twice within 10 seconds. This likely involves testing the scheduled task
 * feature of Spring (@Scheduled), where reportCurrentTime() is scheduled to run
 * periodically. Using Awaitility, the test waits up to 10 seconds for this
 * condition to be satisfied. The @SpyBean allows the test to monitor the actual
 * ScheduleTasks bean, ensuring the method is being called in the background by
 * the Spring scheduler. Key Technologies: Spring Boot: The test is for a Spring
 * Boot application, so the @SpringBootTest annotation loads the application
 * context. Mockito: @SpyBean and verify() come from the Mockito library,
 * allowing you to spy on and verify method calls. Awaitility: Helps to deal
 * with asynchronous behavior by allowing the test to wait for conditions to be
 * met. Example Use Case: This test might be part of an application that has
 * scheduled tasks, like generating reports or checking the system status. The
 * test ensures that the task (reportCurrentTime()) is invoked the expected
 * number of times, ensuring that the scheduling logic works correctly.
 */

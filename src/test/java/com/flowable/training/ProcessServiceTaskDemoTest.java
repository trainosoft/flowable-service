package com.flowable.training;

import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.test.FlowableRule;
import org.junit.Rule;
import org.junit.Test;

public class ProcessServiceTaskDemoTest {

	private String filename = "src/main/resources/diagrams/Service_Task_Demo.bpmn";

	@Rule
	public FlowableRule activitiRule = new FlowableRule();

	@Test
	public void startProcess() throws Exception {
		RepositoryService repositoryService = activitiRule.getRepositoryService();
		System.out.println("Repository Service Started");
		repositoryService.createDeployment().addInputStream("Service_Task_Demo.bpmn20.xml",
				new FileInputStream(filename)).deploy();
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		System.out.println("Runtime Service Started");
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("name", "Activiti");
		variableMap.put("abc",6);
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("serviceTaskDemo", variableMap);
		System.out.println("Process is deployed");
		assertNotNull(processInstance.getId());
		System.out.println("id " + processInstance.getId() + " "+processInstance.getProcessDefinitionId());
		System.out.println("Service Task Execution Completed");
	}
}
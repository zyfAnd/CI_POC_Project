package com.citi.util;

import org.drools.core.process.instance.WorkItemHandler;
import org.jbpm.bpmn2.handler.ServiceTaskHandler;
import org.kie.api.runtime.process.WorkItem;

import org.kie.api.runtime.process.WorkItemManager;

public class MyTaskHandler extends ServiceTaskHandler{
	
	
	
	
	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		// TODO Auto-generated method stub

		System.out.println("entry excute work item====");
		
		manager.completeWorkItem(workItem.getId(), null);
		
		System.out.println("end excute work item====");
	}

	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		// TODO Auto-generated method stub
		
		System.out.println("entry abort work item====");
		
		manager.abortWorkItem(workItem.getId());
		
		System.out.println("aborting process====");
		
	}

	

}

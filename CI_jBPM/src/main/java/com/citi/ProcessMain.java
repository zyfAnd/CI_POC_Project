package com.citi;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jbpm.bpmn2.handler.ServiceTaskHandler;
import org.jbpm.test.JBPMHelper;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeEnvironmentBuilder;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.manager.RuntimeManagerFactory;

import com.citi.model.InputData;
import com.citi.model.RequestData;
import com.citi.util.Constant;
import com.citi.util.MyTaskHandler;

public class ProcessMain {

	public static void main(String[] args) {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieBase kbase = kContainer.getKieBase("kbase");
		RuntimeManager manager = createRuntimeManager(kbase);
		RuntimeEngine engine = manager.getRuntimeEngine(null);
		KieSession ksession = engine.getKieSession();
		
		ksession.getWorkItemManager().registerWorkItemHandler("Service Task", new ServiceTaskHandler());
//		InputData InputData = new InputData("123","23");
//		Map<String, Object> param  = new HashMap<String, Object>();
//		param.put("in", InputData);
		
		
		Map<String, Object> param1  = new HashMap<String, Object>();
		RequestData data = new RequestData("123333");
		param1.put("var1", Constant.NESS);
		param1.put("var2",Constant.FMESYNC);
		param1.put("var3", Constant.CREDITBUREAU);
		param1.put("var4", Constant.INETERNAL_ACCOUNTPULL);    
		
//		
//		param1.put("var4", Constant.CREDITANALYSIS_CREDITDECISION);
//		param1.put("var5", Constant.INETERNAL_ACCOUNTPULL);    
		
		
		
		ksession.startProcess("com.sample.bpmn.credit3",param1);
//		ksession.startProcess("com.sample.test");
		manager.disposeRuntimeEngine(engine);
		
		System.exit(0);
	}

	private static RuntimeManager createRuntimeManager(KieBase kbase) {
		JBPMHelper.startH2Server();
		JBPMHelper.setupDataSource();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.jbpm.persistence.jpa");
		RuntimeEnvironmentBuilder builder = RuntimeEnvironmentBuilder.Factory.get()
			.newDefaultBuilder().entityManagerFactory(emf)
			.knowledgeBase(kbase);
		return RuntimeManagerFactory.Factory.get()
			.newSingletonRuntimeManager(builder.get(), "com.sample:example:1.0");
	}

}
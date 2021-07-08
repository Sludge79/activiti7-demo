package org.activiti.training.activiti7apibasicprocessusertaskservicetaskevents;


import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.security.SecurityManager;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.Date;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRoot {

    @Test
    public void testGenTable() {
        //创建ProcessEngineProcessEngine
        ProcessEngineConfiguration processEngineConfigurationFromResource = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");

        //创建processEngine
        ProcessEngine processEngine = processEngineConfigurationFromResource.buildProcessEngine();

        System.out.println(processEngine);

    }

    @Autowired
    private ProcessRuntime processRuntime;

    @Autowired
    SecurityUtil securityUtil;

    @Test
    public void startProcess() {

        securityUtil.logInAs("testuser");
        ProcessInstance processInstance = processRuntime.start(ProcessPayloadBuilder
                .start()
                .withProcessDefinitionKey("mailTask")
                .withProcessInstanceName("Sample Process: " + new Date())
                .withVariable("someProcessVar", "1844938266@qq.com")
                .withVariable("attachments",new File("D:\\workspace\\activiti7-api-basic-process\\src\\main\\resources\\processes\\mailTask.bpmn20.xml"))
                .build());

        System.out.println(processInstance);
    }
}

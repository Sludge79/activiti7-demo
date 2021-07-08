package org.activiti.training.activiti7apibasicprocessusertaskservicetaskevents.listeners;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MobileTextListener implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        //短信发送实现
        log.info("======text=======");

    }
}

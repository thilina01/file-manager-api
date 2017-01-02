package com.trendsmixed.fma;

import com.trendsmixed.fma.entity.Status;
import com.trendsmixed.fma.service.StatusService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Strater {

    @Autowired
    private StatusService statusService;

    @PostConstruct
    public void afterStarted() {
        List<Status> statuses = statusService.findAll();
        if (statuses.isEmpty()) {
            Status active = new Status();
            active.setName("active");
            Status inactive = new Status();
            inactive.setName("inactive");

            statuses.add(active);
            statuses.add(inactive);

            statusService.save(statuses);
        }
    }
}

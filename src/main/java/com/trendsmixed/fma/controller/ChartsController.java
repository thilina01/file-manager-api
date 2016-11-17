package com.trendsmixed.fma.controller;

import com.trendsmixed.fma.dao.Duration;
import com.trendsmixed.fma.dao.Column;
import com.trendsmixed.fma.dao.ChartData;
import com.trendsmixed.fma.dao.ChartOptions;
import com.trendsmixed.fma.entity.ControlPoint;
import com.trendsmixed.fma.entity.ControlPointRun;
import com.trendsmixed.fma.service.ControlPointPlanJobService;
import com.trendsmixed.fma.service.ControlPointRunJobService;
import com.trendsmixed.fma.service.ControlPointRunManpowerService;
import com.trendsmixed.fma.service.ControlPointRunService;
import com.trendsmixed.fma.service.ControlPointService;
import com.trendsmixed.fma.service.JobService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/charts")
public class ChartsController {

    @Autowired
    ControlPointRunService controlPointRunService;
    @Autowired
    ControlPointService controlPointService;
    @Autowired
    JobService jobService;
    @Autowired
    ControlPointRunManpowerService controlPointRunManpowerService;
    @Autowired
    ControlPointPlanJobService controlPointPlanJobService;
    @Autowired
    ControlPointRunJobService controlPointRunJobService;

    @GetMapping("/test")
    public ChartData test() {

        ArrayList<Column> columns = new ArrayList<>();
        columns.add(new Column("string", "Control Point"));
        columns.add(new Column("number", "MTBF"));
        columns.add(new Column("number", "CCC"));

        ArrayList rows = new ArrayList();
        rows.add(new Object[]{"CP-32", 200, 45});
        rows.add(new Object[]{"CP-33", 250, 60});
        rows.add(new Object[]{"CP-34", 100, 30});
        rows.add(new Object[]{"CP-35", 230, 22});

        return new ChartData("Control Point", "MTBF", columns, rows);
    }

    /*  */
    @GetMapping("/x")
    public ChartData test2() {

        ArrayList dataArray = new ArrayList();

        dataArray.add(new Object[]{"Control Point", "MTBF", "RRRR"});

        dataArray.add(new Object[]{"CP-32", 200, 45});
        dataArray.add(new Object[]{"CP-33", 250, 60});
        dataArray.add(new Object[]{"CP-34", 100, 30});
        dataArray.add(new Object[]{"CP-35", 230, 22});

        return new ChartData("Control Point", "MTBF", dataArray);
    }

    @GetMapping("/controlPointRun")
    public ChartData controlPointRun() {
        try {
            ArrayList dataArray = new ArrayList();

            dataArray.add(new Object[]{"Date", "CP-01", "CP-02", "CP-03"});
            dataArray.add(new Object[]{"10-10", 100, 150, 130});
            dataArray.add(new Object[]{"10-11", 100, 150, 130});
            dataArray.add(new Object[]{"10-12", 100, 150, 130});
            dataArray.add(new Object[]{"10-13", 100, 150, 130});
            dataArray.add(new Object[]{"10-14", 100, 150, 130});
            /*
            List<ControlPoint> controlPoints = controlPointService.findAll();
            for (ControlPoint controlPoint : controlPoints) {
            List<ControlPointRun> controlPointRuns = controlPoint.getControlPointRunList();
            for (ControlPointRun controlPointRun : controlPointRuns) {
                
            }
            }
             */
 /*
            List<ControlPointRun> controlPointRuns = controlPointRunService.findAll();
            for (ControlPointRun controlPointRun : controlPointRuns) {
            controlPointRun.getWorkingDuration();
            dataArray.add(new Object[]{controlPointRun.getControlPoint().getCode(), controlPointRun.getWorkingDuration()});
            }
             */
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse("2016-09-01");
            Date endDate = sdf.parse("2016-10-01");
            List<ControlPointRun> controlPointRuns = controlPointRunService.findByRunDateBetween(startDate, endDate);
            for (ControlPointRun controlPointRun : controlPointRuns) {
                // System.out.println(controlPointRun.getControlPoint().getCode());
            }
            return new ChartData("Control Point", "Duration", dataArray);
        } catch (ParseException ex) {
            Logger.getLogger(ChartsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @PostMapping("/x")
    public ChartData x(@RequestBody Duration duration) {
        if (duration.getStartDate() == null) {
            duration.thisMonth();
        }
        ArrayList dataArrayList = new ArrayList();
        ArrayList titleArrayList = new ArrayList();
        List l = jobService.findX(duration.getStartDate(), duration.getEndDate(), new PageRequest(0, 10));

        dataArrayList.add(new Object[]{"Item", "Quantity"});
        dataArrayList.addAll(l);
        return new ChartData("Items", "quantity", dataArrayList);
    }

    @PostMapping("/attendance")
    public ChartData attendance(@RequestBody Duration duration) {
        if (duration.getStartDate() == null) {
            duration.thisMonth();
        }
        ArrayList dataArrayList = new ArrayList();
        List l = controlPointRunManpowerService.findSumByManpowerTypeAndDateBetween(duration.getStartDate(), duration.getEndDate(), new PageRequest(0, 10));

        dataArrayList.add(new Object[]{"Type", "Count"});
        dataArrayList.addAll(l);
        return new ChartData("Type", "Count", dataArrayList);
    }

    @PostMapping("/controlPointRun")
    public ChartData controlPointRunWithDuration(@RequestBody Duration duration) {
        if (duration.getStartDate() == null) {
            duration.thisMonth();
        }
        ArrayList dataArrayList = new ArrayList();
        ArrayList titleArrayList = new ArrayList();

        String date = "";
        List<ControlPointRun> controlPointRunDistincts = controlPointRunService.findControlPointDistinctByRunDateBetweenOrderByRunDate(duration.getStartDate(), duration.getEndDate());
        int size = controlPointRunDistincts.size();
        titleArrayList.add("Date");
        for (ControlPointRun controlPointRunDistinct : controlPointRunDistincts) {
            String code = controlPointRunDistinct.getControlPoint().getCode();
            titleArrayList.add(code);
        }
        dataArrayList.add(titleArrayList.toArray());
        Object[] row = new Object[size + 1];
        for (int i = 0; i <= size; i++) {
            row[i] = 0;
        }
        List<ControlPointRun> controlPointRuns = controlPointRunService.findByRunDateBetweenOrderByRunDate(duration.getStartDate(), duration.getEndDate());
        for (ControlPointRun controlPointRun : controlPointRuns) {
            String runDate = controlPointRun.getRunDate().toString();
            ControlPoint controlPoint = controlPointRun.getControlPoint();
            int workingDuration = controlPointRun.getWorkingDuration();

            if (date.equals("")) {
                date = runDate;
            }

            if (!date.equals(runDate)) {
                date = runDate;
                dataArrayList.add(row);
                row = new Object[size + 1];
                for (int i = 0; i <= size; i++) {
                    row[i] = 0;
                }
                row[0] = runDate;
            }

            row[0] = runDate;
            int index = titleArrayList.indexOf(controlPoint.getCode());
            row[index] = workingDuration;
            // System.out.println(controlPoint.getCode() + " ~ " + runDate);
        }
        dataArrayList.add(row);
        return new ChartData("Control Point", "Duration", dataArrayList);
    }

    @PostMapping("/scheduleAdherence")
    public ChartData scheduleAdherence(@RequestBody Duration duration) {
        if (duration.getStartDate() == null) {
            duration.thisMonth();
        }

        ArrayList dataArrayList = new ArrayList();
        dataArrayList.add(new Object[]{"Section", "Value", new ChartOptions()});
        ArrayList<Object[]> planList = controlPointPlanJobService.findSectionWiseQuantityInPlanDateBetween(duration.getStartDate(), duration.getEndDate());

        for (Object[] row : planList) {
            Rows.fillPlanned((String) row[0], Double.valueOf(row[1].toString()));
        }
        ArrayList<Object[]> achieveList = controlPointRunJobService.findSectionWiseQuantityInRunDateBetween(duration.getStartDate(), duration.getEndDate());

        for (Object[] row : achieveList) {
            Rows.fillAchieved((String) row[0], Double.valueOf(row[1].toString()));
        }

        for (Rows aa : Rows.a) {
            double value = Math.round((aa.achieved / aa.planned) * 10000) / 100;
            ArrayList al = new ArrayList();
            al.add(aa.section);
            al.add(value);
            al.add(value + "%");

            //dataArrayList.add(new Object[]{aa.section, value, value + "%"});
            dataArrayList.add(al);
        }
        return new ChartData("Section", "Schedule Adherence", dataArrayList);
    }

    @PostMapping("/mttr")
    public ChartData mttr(@RequestBody Duration duration) {
        if (duration.getStartDate() == null) {
            duration.thisMonth();
        }

        ArrayList dataArrayList = new ArrayList();
        dataArrayList.add(new Object[]{"Section", "MTTR"});
        ArrayList result = controlPointRunService.findSectionWiseMttrDateBetween(duration.getStartDate(), duration.getEndDate());
        dataArrayList.addAll(result);
        return new ChartData("Section", "MTTR", dataArrayList);
    }

    @PostMapping("/mtbf")
    public ChartData mtbf(@RequestBody Duration duration) {
        if (duration.getStartDate() == null) {
            duration.thisMonth();
        }

        ArrayList dataArrayList = new ArrayList();
        dataArrayList.add(new Object[]{"Section", "MTBF"});
        ArrayList result = controlPointRunService.findSectionWiseMtbfDateBetween(duration.getStartDate(), duration.getEndDate());
        dataArrayList.addAll(result);
        return new ChartData("Section", "MTBF", dataArrayList);
    }
    
    @PostMapping("/mdt")
    public ChartData mdt(@RequestBody Duration duration) {
        if (duration.getStartDate() == null) {
            duration.thisMonth();
        }

        ArrayList dataArrayList = new ArrayList();
        dataArrayList.add(new Object[]{"Section", "MDT"});
        ArrayList result = controlPointRunService.findSectionWiseMdtDateBetween(duration.getStartDate(), duration.getEndDate());
        dataArrayList.addAll(result);
        return new ChartData("Section", "MDT", dataArrayList);
    }
}

class Rows {

    String section;
    double planned, achieved;
    static ArrayList<Rows> a = new ArrayList();

    static void fillPlanned(String aSection, double aPlanned) {
        boolean found = false;
        for (Rows rows : a) {
            if (rows.section.equals(aSection)) {
                found = true;
                rows.planned = aPlanned;
                break;
            }
        }
        if (!found) {
            Rows r = new Rows();
            r.section = aSection;
            r.planned = aPlanned;
            r.achieved = 0;
            a.add(r);
        }
    }

    static void fillAchieved(String aSection, double anAchieved) {
        boolean found = false;
        for (Rows rows : a) {
            if (rows.section.equals(aSection)) {
                found = true;
                rows.achieved = anAchieved;
                break;
            }
        }
        if (!found) {
            Rows r = new Rows();
            r.section = aSection;
            r.achieved = anAchieved;
            r.planned = 0;
            a.add(r);
        }
    }
}

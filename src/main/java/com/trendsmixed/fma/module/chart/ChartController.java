package com.trendsmixed.fma.module.chart;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.BreakdownChart;
import com.trendsmixed.fma.dao.BreakdownSixMonthsChart;
import com.trendsmixed.fma.dao.view.*;
import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.employee.EmployeeView;
import com.trendsmixed.fma.module.location.Location;
import com.trendsmixed.fma.module.lossreason.LossReason;
import com.trendsmixed.fma.module.losstype.LossType;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.shift.Shift;
import com.trendsmixed.fma.utility.Format;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/chart")
public class ChartController {

    private final ChartService chartService;

    @GetMapping("/monthlyOnTimeDelivery")
    public List getMonthlyOnTimeDelivery(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getMonthlyOnTimeDelivery(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @GetMapping("/monthlyOnTimeDeliveryByCustomer")
    public List getMonthlyOnTimeDeliveryByCustomer(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText,
            @RequestParam(value = "customer") String customerId) {
        return chartService.getMonthlyOnTimeDeliveryByCustomer(Format.toStartDate(startDateText), Format.toEndDate(endDateText), new Customer(Integer.valueOf(customerId)));
    }

    @GetMapping("/scheduleAdherence")
    public List getScheduleAdherence(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getScheduleAdherence(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }
    
    @GetMapping("/scrap")
    public List getScrap(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getScrap(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }
    
    @JsonView(ScrapReasonSummaryView.All.class)
    @GetMapping("/scrapReasonSummary")
    public List getScrapReasonSummary(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getScrapReasonSummary(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @JsonView(ScrapReasonSummaryView.All.class)
    @GetMapping("/scrapReasonSummaryBySection")
    public List getScrapReasonSummaryBySection(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText,
            @RequestParam(value = "section") String sectionId) {
        return chartService.getScrapReasonSummaryBySection(Format.toStartDate(startDateText), Format.toEndDate(endDateText), new Section(Integer.valueOf(sectionId)));
    }

    @JsonView(ScrapReasonSummaryView.All.class)
    @GetMapping("/scrapReasonSummaryBySectionAndLossReason")
    public List getScrapReasonSummaryBySectionAndLossReason(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText,
            @RequestParam(value = "section") String sectionId,
            @RequestParam(value = "lossReason") String lossReasonId) {
        return chartService.getScrapReasonSummaryBySectionAndLossReason(Format.toStartDate(startDateText), Format.toEndDate(endDateText), new Section(Integer.valueOf(sectionId)), new LossReason(Integer.valueOf(lossReasonId)));
    }

    @JsonView(ScrapReasonSummaryView.All.class)
    @GetMapping("/scrapReasonSummaryByLossReason")
    public List getScrapReasonSummaryByLossReason(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText,
            @RequestParam(value = "lossReason") String lossReasonId) {
        return chartService.getScrapReasonSummaryByLossReason(Format.toStartDate(startDateText), Format.toEndDate(endDateText), new LossReason(Integer.valueOf(lossReasonId)));
    }

    @GetMapping("/scrapBySection")
    public List getScrapBySection(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText,
            @RequestParam(value = "section") String sectionId) {
        return chartService.getScrapBySection(Format.toStartDate(startDateText), Format.toEndDate(endDateText), new Section(Integer.valueOf(sectionId)));
    }

    @GetMapping("/scheduleAdherenceBySection")
    public List getScheduleAdherenceBySection(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText,
            @RequestParam(value = "section") String sectionId) {
        return chartService.getScheduleAdherenceBySection(Format.toStartDate(startDateText), Format.toEndDate(endDateText), new Section(Integer.valueOf(sectionId)));
    }

    @GetMapping("/lossReasonSummaryBySection")
    public List getLossReasonSummaryBySection(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText,
            @RequestParam(value = "section") String sectionId) {
        return chartService.getLossReasonSummaryBySection(Format.toStartDate(startDateText), Format.toEndDate(endDateText), new Section(Integer.valueOf(sectionId)));
    }

    @GetMapping("/lossReasonSummaryByLossType")
    public List getLossReasonSummaryByLossType(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText,
            @RequestParam(value = "lossType") String lossTypeId) {
        return chartService.getLossReasonSummaryByLossType(Format.toStartDate(startDateText), Format.toEndDate(endDateText), new LossType(Integer.valueOf(lossTypeId)));
    }

    @GetMapping("/lossReasonSummary")
    public List getLossReasonSummary(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getLossReasonSummary(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @GetMapping("/lossReasonDailyCountBySection")
    public List getLossReasonDailyCountBySection(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText,
            @RequestParam(value = "section") String sectionId) {
        return chartService.getLossReasonDailyCountBySection(Format.toStartDate(startDateText), Format.toEndDate(endDateText), new Section(Integer.valueOf(sectionId)));
    }

    @GetMapping("/lossReasonDailyCountByLossType")
    public List getLossReasonDailyCountByLossType(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText,
            @RequestParam(value = "lossType") String lossTypeId) {
        return chartService.getLossReasonDailyCountByLossType(Format.toStartDate(startDateText), Format.toEndDate(endDateText), new LossType(Integer.valueOf(lossTypeId)));
    }

    @GetMapping("/lossReasonDailyCountBySectionAndLossType")
    public List getLossReasonDailyCountBySectionAndLossType(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText,
            @RequestParam(value = "section") String sectionId,
            @RequestParam(value = "lossType") String lossTypeId) {
        return chartService.getLossReasonDailyCountBySectionAndLossType(Format.toStartDate(startDateText), Format.toEndDate(endDateText), new Section(Integer.valueOf(sectionId)), new LossType(Integer.valueOf(lossTypeId)));
    }

    @GetMapping("/lossReasonDailyCount")
    public List getLossReasonDailyCountBySection(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getLossReasonDailyCount(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @GetMapping("/lossReasonDailyCountBySectionAndLossReason")
    public List getLossReasonDailyCountBySectionAndLossReason(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText,
            @RequestParam(value = "section") String sectionId,
            @RequestParam(value = "lossReason") String lossReasonId) {
        return chartService.getLossReasonDailyCountBySectionAndLossReason(Format.toStartDate(startDateText), Format.toEndDate(endDateText), new Section(Integer.valueOf(sectionId)), new LossReason(Integer.valueOf(lossReasonId)));
    }

    @GetMapping("/lossReasonDailyCountByLossReason")
    public List getLossReasonDailyCountBySectionAndLossReason(@RequestParam(value = "startDate") String startDateText,
                                                              @RequestParam(value = "endDate") String endDateText,
                                                              @RequestParam(value = "lossReason") String lossReasonId) {
        return chartService.getLossReasonDailyCountByLossReason(Format.toStartDate(startDateText), Format.toEndDate(endDateText), new LossReason(Integer.valueOf(lossReasonId)));
    }

    @JsonView(LossReasonSectionCountView.All.class)
    @GetMapping("/lossReasonSectionCountByLossReason")
    public List getLossReasonSectionCountByLossReason(@RequestParam(value = "startDate") String startDateText,
                                                                @RequestParam(value = "endDate") String endDateText,
                                                                @RequestParam(value = "lossReason") String lossReasonId) {
        return chartService.getLossReasonSectionCountByLossReason(Format.toStartDate(startDateText), Format.toEndDate(endDateText), new LossReason(Integer.valueOf(lossReasonId)));
    }

    @JsonView(LossReasonControlPointCountView.All.class)
    @GetMapping("/lossReasonControlPointCountByLossReasonAndSection")
    public List getLossReasonControlPointCountByLossReasonAndSection(@RequestParam(value = "startDate") String startDateText,
                                                                @RequestParam(value = "endDate") String endDateText,
                                                                     @RequestParam(value = "lossReason") String lossReasonId,
                                                                     @RequestParam(value = "section") String sectionId) {
        return chartService.getLossReasonControlPointCountByLossReasonAndSection(Format.toStartDate(startDateText), Format.toEndDate(endDateText), new LossReason(Integer.valueOf(lossReasonId)), new Section(Integer.valueOf(sectionId)));
    }

    @GetMapping("/lossReasonSummaryBySectionAndLossType")
    public List getLossReasonSummaryBySectionAndLossType(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText,
            @RequestParam(value = "section") String sectionId,
            @RequestParam(value = "lossType") String lossTypeId) {
        return chartService.getLossReasonSummaryBySectionAndLossType(Format.toStartDate(startDateText), Format.toEndDate(endDateText), new Section(Integer.valueOf(sectionId)), new LossType(Integer.valueOf(lossTypeId)));
    }

    @GetMapping("/breakdown")
    public List<BreakdownChart> getBreakdown(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        List<BreakdownChart> breakdownChartList = new ArrayList<>();
        List resultList = chartService.getBreakdown(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
        for (Object object : resultList) {
            Object[] rowData = (Object[]) object;
            breakdownChartList.add(new BreakdownChart(rowData[0], rowData[1], rowData[2], rowData[3], rowData[4], rowData[5], rowData[6], rowData[7], rowData[8], rowData[9]));
        }
        return breakdownChartList;
    }

    @GetMapping("/breakdownSixMonths")
    public List<BreakdownSixMonthsChart> getBreakdownSixMonths() {
        List<BreakdownSixMonthsChart> BreakdownSixMonthsChartData = new ArrayList<>();
        for (Object object : chartService.getBreakdownSixMonths()) {
            Object[] rowData = (Object[]) object;
            BreakdownSixMonthsChartData.add(
                new BreakdownSixMonthsChart(
                    rowData[0].toString(),
                    (Number)rowData[1], 
                    (Number)rowData[2], 
                    (Number)rowData[3], 
                    (Number)rowData[4], 
                    (Number)rowData[5], 
                    (Number)rowData[6]
                )
            );
        }
        return BreakdownSixMonthsChartData;
    }

    // @GetMapping("/breakdown6Months")
    // public Map<String,Double> getBreakdown6Months() {

    //     List<BreakdownChart> breakdownChartList =getBreakdown("2018-05-01", "2018-05-31");
    //     double totalRunDuration = 0;
    //     double totalBreakdownDuration = 0;
    //     double totalBreakdownCount = 0;
    //     // double totalMTBF = 0;
    //     // double totalMTTR = 0;
    //     // double totalMDT = 0;

    //     for (BreakdownChart breakdownChart : breakdownChartList) {
    //         totalRunDuration += breakdownChart.getRunDuration();
    //         totalBreakdownDuration += breakdownChart.getBreakdownDuration();
    //         totalBreakdownCount += breakdownChart.getBreakdownCount();
    //         // totalMTBF += breakdownChart.getMtbf();
    //         // totalMTTR += breakdownChart.getMttr();
    //         // totalMDT += breakdownChart.getMdt();            
    //     }
    //     Map<String,Double> result = new HashMap<>();
    //     result.put("totalRunDuration", totalRunDuration);
    //     result.put("totalBreakdownDuration", totalBreakdownDuration);
    //     result.put("totalBreakdownCount", totalBreakdownCount);
    //     result.put("MTBF", totalRunDuration/totalBreakdownCount);
    //     result.put("totalMTTR", totalBreakdownDuration/totalBreakdownCount);
    //     result.put("totalMDT", (totalBreakdownDuration/totalRunDuration)*100);
    //     return result;
    // }

//    @GetMapping("/test")
//    public List test(@RequestParam(value = "startDate") String startDateText,
//            @RequestParam(value = "endDate") String endDateText) {
//        return chartService.test(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
//    }

    @GetMapping("/monthlyScheduleAdherenceBySection")
    public List getMonthlyScheduleAdherenceBySection(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText,
            @RequestParam(value = "section") String sectionId) {
        return chartService.getMonthlyScheduleAdherenceBySection(Format.toStartDate(startDateText), Format.toEndDate(endDateText), new Section(Integer.valueOf(sectionId)));
    }

    @GetMapping("/monthlyScrapValue")
    public List getMonthlyScrapValue(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getMonthlyScrapValue(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @GetMapping("/monthlyScheduleAdherence")
    public List getMonthlyScheduleAdherence(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getMonthlyScheduleAdherence(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @GetMapping("/monthlyEnergyConsumptionByLocation")
    public List getMonthlyEnergyConsumptionByLocation(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText,
            @RequestParam(value = "location") String locationId) {
        return chartService.getMonthlyEnergyConsumptionByLocation(Format.toStartDate(startDateText), Format.toEndDate(endDateText), new Location(Integer.valueOf(locationId)));
    }

    @GetMapping("/monthlyLabourTurnover")
    public List getMonthlyLabourTurnover(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getMonthlyLabourTurnover(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @GetMapping("/monthlyAbsenteeism")
    public List getMonthlyAbsenteeism(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getMonthlyAbsenteeism(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @GetMapping("/monthlySalesValue")
    public List getMonthlySalesValue(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getMonthlySalesValue(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @GetMapping("/monthlySalesWeight")
    public List getMonthlySalesWeight(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getMonthlySalesWeight(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @GetMapping("/monthlyLabourCostPerKg")
    public List getMonthlyLabourCostPerKg(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getMonthlyLabourCostPerKg(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @GetMapping("/monthlyCumulativeSalesPerKg")
    public List getMonthlyCumulativeSalesPerKg(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getMonthlyCumulativeSalesPerKg(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @GetMapping("/monthlyProductionOverheadCostPerKg")
    public List getMonthlyProductionOverheadCostPerKg(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getMonthlyProductionOverheadCostPerKg(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @GetMapping("/monthlySalesPerKg")
    public List getMonthlySalesPerKg(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getMonthlySalesPerKg(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @GetMapping("/monthlyConsumableCostPerKg")
    public List getMonthlyConsumableCostPerKg(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getMonthlyConsumableCostPerKg(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @GetMapping("/monthlyMaterialCostPerKg")
    public List getMonthlyMaterialCostPerKg(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getMonthlyMaterialCostPerKg(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @GetMapping("/monthlyElectricityCostPerKg")
    public List getMonthlyElectricityCostPerKg(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getMonthlyElectricityCostPerKg(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @GetMapping("/monthlyScrapCostPerKg")
    public List getMonthlyScrapCostPerKg(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getMonthlyScrapCostPerKg(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @GetMapping("/monthlyRevenue")
    public List getMonthlyRevenue(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getMonthlyRevenue(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @GetMapping("/monthlyEbitda")
    public List getMonthlyEbitda(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getMonthlyEbitda(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @GetMapping("/monthlyGrossProfit")
    public List getMonthlyGrossProfit(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getMonthlyGrossProfit(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @GetMapping("/monthlyNetProfit")
    public List getMonthlyNetProfit(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.getMonthlyNetProfit(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @JsonView(ManpowerSummaryView.All.class)
    @GetMapping("/manpowerSummary")
    public List getManpowerSummary(@RequestParam(value = "startDate") long startDate,
            @RequestParam(value = "endDate") long endDate) {
        return chartService.getManpowerSummary(new Date(startDate), new Date(endDate));
    }

    @JsonView(ManpowerSummaryView.All.class)
    @GetMapping("/manpowerSummaryBySection")
    public List getManpowerSummaryBySection(@RequestParam(value = "startDate") long startDate,
            @RequestParam(value = "endDate") long endDate,
            @RequestParam(value = "section") String sectionId) {
        return chartService.getManpowerSummaryBySection(new Date(startDate), new Date(endDate), new Section(Integer.valueOf(sectionId)));
    }

    @JsonView(ManpowerSummaryView.All.class)
    @GetMapping("/manpowerSummaryByShift")
    public List getManpowerSummaryByShift(@RequestParam(value = "startDate") long startDate,
            @RequestParam(value = "endDate") long endDate,
            @RequestParam(value = "shift") String shiftId) {
        return chartService.getManpowerSummaryByShift(new Date(startDate), new Date(endDate), new Shift(Integer.valueOf(shiftId)));
    }

    @JsonView(ManpowerSummaryView.All.class)
    @GetMapping("/manpowerSummaryBySectionAndShift")
    public List getManpowerSummaryBySectionAndShift(@RequestParam(value = "startDate") long startDate,
            @RequestParam(value = "endDate") long endDate,
            @RequestParam(value = "section") String sectionId,
            @RequestParam(value = "shift") String shiftId) {
        return chartService.getManpowerSummaryBySectionAndShift(new Date(startDate), new Date(endDate), new Section(Integer.valueOf(sectionId)), new Shift(Integer.valueOf(shiftId)));
    }

    @JsonView(EmployeeView.All.class)
    @GetMapping("/resourceUtilizationDistinctEmployeeBySectionAndStartTimeBetween")
    public List getResourceUtilizationDistinctEmployeeBySectionAndStartTimeBetween(@RequestParam(value = "startDate") long startDate,
            @RequestParam(value = "endDate") long endDate,
            @RequestParam(value = "section") String sectionId) {
        return chartService.getResourceUtilizationDistinctEmployeeBySectionAndStartTimeBetween(new Section(Integer.valueOf(sectionId)), new Date(startDate), new Date(endDate));
    }
    
    @JsonView(EmployeeView.All.class)
    @GetMapping("/resourceUtilizationDistinctEmployeeByControlPointAndStartTimeBetween")
    public List getResourceUtilizationDistinctEmployeeByControlPointAndStartTimeBetween(
        @RequestParam(value = "controlPoint") String controlPointId, 
        @RequestParam(value = "startDate") long startDate,
        @RequestParam(value = "endDate") long endDate) {
        return chartService.getResourceUtilizationDistinctEmployeeByControlPointAndStartTimeBetween(new ControlPoint(Integer.valueOf(controlPointId)), new Date(startDate), new Date(endDate));
    }

    @JsonView(OperationProgressSummaryView.All.class)
    @GetMapping("/operationProgressSummaryBySection/{id}")
    public List getOperationProgressSummaryBySection(@PathVariable("id") int id,
                     @RequestParam(value = "productionDate") long productionDate) {
        return chartService.getOperationProgressSummaryBySection(new Section(id), new Date(productionDate));
    }

    @JsonView(OperationProgressSummaryView.All.class)
    @GetMapping("/operationProgressSummaryBySectionAndShift/{sectionId}/{shiftId}")
    public List getOperationProgressSummaryBySection(@PathVariable("sectionId") int sectionId,
                                                     @PathVariable("shiftId") int shiftId,
                                                     @RequestParam(value = "productionDate") long productionDate) {
        return chartService.getOperationProgressSummaryBySectionAndShift(new Section(sectionId), new Shift(shiftId), new Date(productionDate));
    }

    @JsonView(OperationProgressSummaryView.All.class)
    @GetMapping("/operationProgressSummary")
    public List getOperationProgressSummary(@RequestParam(value = "productionDate") long productionDate) {
        return chartService.getOperationProgressSummary(new Date(productionDate));
    }
}

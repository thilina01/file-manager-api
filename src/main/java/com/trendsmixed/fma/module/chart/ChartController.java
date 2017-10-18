package com.trendsmixed.fma.module.chart;

import com.trendsmixed.fma.dao.BreakdownChart;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.location.Location;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.module.lossreason.LossReason;
import com.trendsmixed.fma.module.losstype.LossType;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.utility.Format;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/chart")
public class ChartController {

    @Autowired
    private ChartService chartService;

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

    @GetMapping("/test")
    public List test(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText) {
        return chartService.test(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
    }

    @GetMapping("/monthlyScheduleAdherenceBySection")
    public List getMonthlyScheduleAdherenceBySection(@RequestParam(value = "startDate") String startDateText,
            @RequestParam(value = "endDate") String endDateText,
            @RequestParam(value = "section") String sectionId) {
        return chartService.getMonthlyScheduleAdherenceBySection(Format.toStartDate(startDateText), Format.toEndDate(endDateText), new Section(Integer.valueOf(sectionId)));
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

}

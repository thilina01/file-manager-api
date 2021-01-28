package com.trendsmixed.fma.module.chart;

import com.trendsmixed.fma.dao.BreakdownSixMonthsChart;
import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.location.Location;
import com.trendsmixed.fma.module.lossreason.LossReason;
import com.trendsmixed.fma.module.losstype.LossType;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.shift.Shift;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class ChartService {

    private ChartRepository chartRepository;

    public List getScrap(Date startDate, Date endDate) {
        return chartRepository.getScrap(startDate, endDate);
    }
    
    public List getScrapReasonSummary(Date startDate, Date endDate) {
        return chartRepository.getScrapReasonSummary(startDate, endDate);
    }

    public List getScrapReasonSummaryBySection(Date startDate, Date endDate, Section section) {
        return chartRepository.getScrapReasonSummaryBySection(startDate, endDate, section);
    }

    public List getScrapReasonSummaryBySectionAndLossReason(Date startDate, Date endDate, Section section, LossReason lossReason) {
        return chartRepository.getScrapReasonSummaryBySectionAndLossReason(startDate, endDate, section, lossReason);
    }
    public List getScrapReasonSummaryByLossReason(Date startDate, Date endDate, LossReason lossReason) {
        return chartRepository.getScrapReasonSummaryByLossReason(startDate, endDate, lossReason);
    }
    public List getScrapBySection(Date startDate, Date endDate, Section section) {
        return chartRepository.getScrapBySection(startDate, endDate, section);
    }
    
    public List getScheduleAdherence(Date startDate, Date endDate) {
        return chartRepository.getScheduleAdherence(startDate, endDate);
    }

    public List getScheduleAdherenceBySection(Date startDate, Date endDate, Section section) {
        return chartRepository.getScheduleAdherenceBySection(startDate, endDate, section);
    }

    public List getLossReasonSummaryBySection(Date startDate, Date endDate, Section section) {
        return chartRepository.getLossReasonSummaryBySection(startDate, endDate, section);
    }

    public List getLossReasonSummaryByLossType(Date startDate, Date endDate, LossType lossType) {
        return chartRepository.getLossReasonSummaryByLossType(startDate, endDate, lossType);
    }

    public List getLossReasonSummary(Date startDate, Date endDate) {
        return chartRepository.getLossReasonSummary(startDate, endDate);
    }

    public List getLossReasonDailyCountBySection(Date startDate, Date endDate, Section section) {
        return chartRepository.getLossReasonDailyCountBySection(startDate, endDate, section);
    }

    public List getLossReasonDailyCountBySectionAndLossType(Date startDate, Date endDate, Section section, LossType lossType) {
        return chartRepository.getLossReasonDailyCountBySectionAndLossType(startDate, endDate, section, lossType);
    }

    public List getLossReasonDailyCountByLossType(Date startDate, Date endDate, LossType lossType) {
        return chartRepository.getLossReasonDailyCountByLossType(startDate, endDate, lossType);
    }

    public List getLossReasonDailyCount(Date startDate, Date endDate) {
        return chartRepository.getLossReasonDailyCount(startDate, endDate);
    }

    public List getLossReasonDailyCountBySectionAndLossReason(Date startDate, Date endDate, Section section, LossReason lossReason) {
        return chartRepository.getLossReasonDailyCountBySectionAndLossReason(startDate, endDate, section, lossReason);
    }

    public List getLossReasonDailyCountByLossReason(Date startDate, Date endDate, LossReason lossReason) {
        return chartRepository.getLossReasonDailyCountByLossReason(startDate, endDate, lossReason);
    }

    public List getLossReasonSectionCountByLossReason(Date startDate, Date endDate, LossReason lossReason) {
        return chartRepository.getLossReasonSectionCountByLossReason(startDate, endDate, lossReason);
    }

    public List getLossReasonControlPointCountByLossReasonAndSection(Date startDate, Date endDate, LossReason lossReason, Section section) {
        return chartRepository.getLossReasonControlPointCountByLossReasonAndSection(startDate, endDate, lossReason, section);
    }
    public List getLossReasonSummaryBySectionAndLossType(Date startDate, Date endDate, Section section, LossType lossType) {
        return chartRepository.getLossReasonSummaryBySectionAndLossType(startDate, endDate, section, lossType);
    }

    public List getBreakdown(Date startDate, Date endDate) {
        return chartRepository.getBreakdown(startDate, endDate);
    }

    public List getBreakdownSixMonths() {
        return chartRepository.getBreakdownSixMonths();
    }

    public List getManpowerSummary(Date startDate, Date endDate) {
        return chartRepository.getManpowerSummary(startDate, endDate);
    }

    public List getManpowerSummaryBySection(Date startDate, Date endDate, Section section) {
        return chartRepository.getManpowerSummaryBySection(startDate, endDate, section);
    }

    public List getManpowerSummaryByShift(Date startDate, Date endDate, Shift shift) {
        return chartRepository.getManpowerSummaryByShift(startDate, endDate, shift);
    }

    public List getManpowerSummaryBySectionAndShift(Date startDate, Date endDate, Section section, Shift shift) {
        return chartRepository.getManpowerSummaryBySectionAndShift(startDate, endDate, section, shift);
    }

    public List getResourceUtilizationDistinctEmployeeBySectionAndStartTimeBetween(Section section, Date startDate, Date endDate) {
        return chartRepository.getResourceUtilizationDistinctEmployeeBySectionAndStartTimeBetween(section, startDate, endDate);
    }
    
    public List getResourceUtilizationDistinctEmployeeByControlPointAndStartTimeBetween(ControlPoint controlPoint, Date startDate, Date endDate) {
        return chartRepository.getResourceUtilizationDistinctEmployeeByControlPointAndStartTimeBetween(controlPoint, startDate, endDate);
    }
    
    /**
     * ***********
     */
    public List test(Date startDate, Date endDate) {
        return chartRepository.test(startDate, endDate);
    }

    public List getMonthlyScheduleAdherenceBySection(Date startDate, Date endDate, Section section) {
        return chartRepository.getMonthlyScheduleAdherenceBySection(startDate, endDate, section);
    }

    public List getMonthlyScheduleAdherence(Date startDate, Date endDate) {
        return chartRepository.getMonthlyScheduleAdherence(startDate, endDate);
    }

    public List getMonthlyScrapValue(Date startDate, Date endDate) {
        return chartRepository.getMonthlyScrapValue(startDate, endDate);
    }

    public List getMonthlyOnTimeDelivery(Date startDate, Date endDate) {
        return chartRepository.getMonthlyOnTimeDelivery(startDate, endDate);
    }

    public List getMonthlyOnTimeDeliveryByCustomer(Date startDate, Date endDate, Customer customer) {
        return chartRepository.getMonthlyOnTimeDeliveryByCustomer(startDate, endDate, customer);
    }

    public List getMonthlyEnergyConsumptionByLocation(Date startDate, Date endDate, Location location) {
        return chartRepository.getMonthlyEnergyConsumptionByLocation(startDate, endDate, location);
    }

    public List getMonthlyLabourTurnover(Date startDate, Date endDate) {
        return chartRepository.getMonthlyLabourTurnover(startDate, endDate);
    }

    public List getMonthlyAbsenteeism(Date startDate, Date endDate) {
        return chartRepository.getMonthlyAbsenteeism(startDate, endDate);
    }

    public List getMonthlySalesValue(Date startDate, Date endDate) {
        return chartRepository.getMonthlySalesValue(startDate, endDate);
    }

    public List getMonthlySalesWeight(Date startDate, Date endDate) {
        return chartRepository.getMonthlySalesWeight(startDate, endDate);
    }

    public List getMonthlyLabourCostPerKg(Date startDate, Date endDate) {
        return chartRepository.getMonthlyLabourCostPerKg(startDate, endDate);
    }

    public List getMonthlyCumulativeSalesPerKg(Date startDate, Date endDate) {
        return chartRepository.getMonthlyCumulativeSalesPerKg(startDate, endDate);
    }

    public List getMonthlyProductionOverheadCostPerKg(Date startDate, Date endDate) {
        return chartRepository.getMonthlyProductionOverheadCostPerKg(startDate, endDate);
    }

    public List getMonthlySalesPerKg(Date startDate, Date endDate) {
        return chartRepository.getMonthlySalesPerKg(startDate, endDate);
    }

    public List getMonthlyConsumableCostPerKg(Date startDate, Date endDate) {
        return chartRepository.getMonthlyConsumableCostPerKg(startDate, endDate);
    }

    public List getMonthlyMaterialCostPerKg(Date startDate, Date endDate) {
        return chartRepository.getMonthlyMaterialCostPerKg(startDate, endDate);
    }

    public List getMonthlyElectricityCostPerKg(Date startDate, Date endDate) {
        return chartRepository.getMonthlyElectricityCostPerKg(startDate, endDate);
    }

    public List getMonthlyScrapCostPerKg(Date startDate, Date endDate) {
        return chartRepository.getMonthlyScrapCostPerKg(startDate, endDate);
    }

    public List getMonthlyRevenue(Date startDate, Date endDate) {
        return chartRepository.getMonthlyRevenue(startDate, endDate);
    }

    public List getMonthlyEbitda(Date startDate, Date endDate) {
        return chartRepository.getMonthlyEbitda(startDate, endDate);
    }

    public List getMonthlyGrossProfit(Date startDate, Date endDate) {
        return chartRepository.getMonthlyGrossProfit(startDate, endDate);
    }

    public List getMonthlyNetProfit(Date startDate, Date endDate) {
        return chartRepository.getMonthlyNetProfit(startDate, endDate);
    }

    public List getOperationProgressSummaryBySection(Section section, Date productionDate) {
        return chartRepository.getOperationProgressSummaryBySection(section, productionDate);
    }

    public List getOperationProgressSummaryBySectionAndShift(Section section, Shift shift, Date productionDate) {
        return chartRepository.getOperationProgressSummaryBySectionAndShift(section, shift, productionDate);
    }

    public List getOperationProgressSummary(Date productionDate) {
        return chartRepository.getOperationProgressSummary(productionDate);
    }
}

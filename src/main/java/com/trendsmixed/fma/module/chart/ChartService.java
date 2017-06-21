package com.trendsmixed.fma.module.chart;

import com.trendsmixed.fma.entity.Location;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.entity.LossReason;
import com.trendsmixed.fma.entity.LossType;
import com.trendsmixed.fma.entity.Section;

@Service
public class ChartService {

    @Autowired
    private ChartRepository chartRepository;

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

    public List getLossReasonSummaryBySectionAndLossType(Date startDate, Date endDate, Section section, LossType lossType) {
        return chartRepository.getLossReasonSummaryBySectionAndLossType(startDate, endDate, section, lossType);
    }

    public List getBreakdown(Date startDate, Date endDate) {
        return chartRepository.getBreakdown(startDate, endDate);
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

    public List getMonthlyEnergyConsumptionByLocation(Date startDate, Date endDate, Location location) {
        return chartRepository.getMonthlyEnergyConsumptionByLocation(startDate, endDate, location);
    }
    
    public List getMonthlyLabourTurnover(Date startDate, Date endDate) {
        return chartRepository.getMonthlyLabourTurnover(startDate, endDate);
    }
    public List getMonthlyAbsenteeism(Date startDate, Date endDate) {
        return chartRepository.getMonthlyAbsenteeism(startDate, endDate);
    }

    
}

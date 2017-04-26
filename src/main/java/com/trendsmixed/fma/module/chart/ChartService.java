package com.trendsmixed.fma.module.chart;

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

	public List getScheduleAdherenceBySection(Date startDate, Date endDate, Section section ) {
		return chartRepository.getScheduleAdherenceBySection(startDate, endDate, section);
	}

	public List getLossReasonSummaryBySection(Date startDate, Date endDate, Section section ) {
		return chartRepository.getLossReasonSummaryBySection(startDate, endDate, section);
	}

	public List getLossReasonSummary(Date startDate, Date endDate ) {
		return chartRepository.getLossReasonSummary(startDate, endDate);
	}

	public List getLossReasonDailyCountBySection(Date startDate, Date endDate, Section section ) {
		return chartRepository.getLossReasonDailyCountBySection(startDate, endDate, section);
	}
	
	public List getLossReasonDailyCount(Date startDate, Date endDate) {
		return chartRepository.getLossReasonDailyCount(startDate, endDate);
	}
	
	public List getLossReasonDailyCountBySectionAndLossReason(Date startDate, Date endDate, Section section, LossReason lossReason ) {
		return chartRepository.getLossReasonDailyCountBySectionAndLossReason(startDate, endDate, section, lossReason);
	}
	public List getLossReasonDailyCountByLossReason(Date startDate, Date endDate,LossReason lossReason ) {
		return chartRepository.getLossReasonDailyCountByLossReason(startDate, endDate, lossReason);
	}
	
	public List getLossReasonSummaryBySectionAndLossType(Date startDate, Date endDate, Section section, LossType lossType ) {
		return chartRepository.getLossReasonSummaryBySectionAndLossType(startDate, endDate, section, lossType);
	}
	
}
package com.trendsmixed.fma.module.chart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.LossReason;
import com.trendsmixed.fma.entity.LossType;
import com.trendsmixed.fma.entity.Section;
import com.trendsmixed.fma.utility.Format;

@RestController
@CrossOrigin
@RequestMapping("/chart")
public class ChartController {

	@Autowired
	private ChartService chartService;

	@GetMapping("/scheduleAdherence")
	public List getScheduleAdherence(@RequestParam(value = "startDate") String startDateText,
			@RequestParam(value = "endDate") String endDateText) {
		return chartService.getScheduleAdherence(Format.toStartDate(startDateText), Format.toEndDate(endDateText));
	}

	@GetMapping("/scheduleAdherenceBySection")
	public List getScheduleAdherenceBySection(@RequestParam(value = "startDate") String startDateText,
			@RequestParam(value = "endDate") String endDateText,
			@RequestParam(value = "section") String sectionId) {		
		return chartService.getScheduleAdherenceBySection(Format.toStartDate(startDateText), Format.toEndDate(endDateText),new Section(Integer.valueOf(sectionId)));
	}

	@GetMapping("/lossReasonSummaryBySection")
	public List getLossReasonSummaryBySection(@RequestParam(value = "startDate") String startDateText,
			@RequestParam(value = "endDate") String endDateText,
			@RequestParam(value = "section") String sectionId) {		
		return chartService.getLossReasonSummaryBySection(Format.toStartDate(startDateText), Format.toEndDate(endDateText),new Section(Integer.valueOf(sectionId)));
	}

	@GetMapping("/lossReasonSummaryByLossType")
	public List getLossReasonSummaryByLossType(@RequestParam(value = "startDate") String startDateText,
			@RequestParam(value = "endDate") String endDateText,
			@RequestParam(value = "lossType") String lossTypeId) {		
		return chartService.getLossReasonSummaryByLossType(Format.toStartDate(startDateText), Format.toEndDate(endDateText),new LossType(Integer.valueOf(lossTypeId)));
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
		return chartService.getLossReasonDailyCountBySection(Format.toStartDate(startDateText), Format.toEndDate(endDateText),new Section(Integer.valueOf(sectionId)));
	}

	@GetMapping("/lossReasonDailyCountByLossType")
	public List getLossReasonDailyCountByLossType(@RequestParam(value = "startDate") String startDateText,
			@RequestParam(value = "endDate") String endDateText,
			@RequestParam(value = "lossType") String lossTypeId) {		
		return chartService.getLossReasonDailyCountByLossType(Format.toStartDate(startDateText), Format.toEndDate(endDateText),new LossType(Integer.valueOf(lossTypeId)));
	}

	@GetMapping("/lossReasonDailyCountBySectionAndLossType")
	public List getLossReasonDailyCountBySectionAndLossType(@RequestParam(value = "startDate") String startDateText,
			@RequestParam(value = "endDate") String endDateText,
			@RequestParam(value = "section") String sectionId,
			@RequestParam(value = "lossType") String lossTypeId) {		
		return chartService.getLossReasonDailyCountBySectionAndLossType(Format.toStartDate(startDateText), Format.toEndDate(endDateText),new Section(Integer.valueOf(sectionId)), new LossType(Integer.valueOf(lossTypeId)));
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
		return chartService.getLossReasonDailyCountBySectionAndLossReason(Format.toStartDate(startDateText), Format.toEndDate(endDateText),new Section(Integer.valueOf(sectionId)),new LossReason(Integer.valueOf(lossReasonId)));
	}

	@GetMapping("/lossReasonDailyCountByLossReason")
	public List getLossReasonDailyCountBySectionAndLossReason(@RequestParam(value = "startDate") String startDateText,
			@RequestParam(value = "endDate") String endDateText,
			@RequestParam(value = "lossReason") String lossReasonId) {		
		return chartService.getLossReasonDailyCountByLossReason(Format.toStartDate(startDateText), Format.toEndDate(endDateText),new LossReason(Integer.valueOf(lossReasonId)));
	}
	
	@GetMapping("/lossReasonSummaryBySectionAndLossType")
	public List getLossReasonSummaryBySectionAndLossType(@RequestParam(value = "startDate") String startDateText,
			@RequestParam(value = "endDate") String endDateText,
			@RequestParam(value = "section") String sectionId,
			@RequestParam(value = "lossType") String lossTypeId) {		
		return chartService.getLossReasonSummaryBySectionAndLossType(Format.toStartDate(startDateText), Format.toEndDate(endDateText),new Section(Integer.valueOf(sectionId)),new LossType(Integer.valueOf(lossTypeId)));
	}
	
}

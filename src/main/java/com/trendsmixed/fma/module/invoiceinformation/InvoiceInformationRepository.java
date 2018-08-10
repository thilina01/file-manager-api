package com.trendsmixed.fma.module.invoiceinformation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

import com.trendsmixed.fma.dao.InvoiceInformation;

public interface InvoiceInformationRepository extends JpaRepository<com.trendsmixed.fma.entity.Query, Integer> {

        @Query(value = "SELECT " + " new com.trendsmixed.fma.dao.InvoiceInformation("
                        + " loadingPlanItem.loadingPlan.dispatchNote.invoice.invoiceDate,"
                        + " loadingPlanItem.loadingPlan.dispatchNote.invoice.invoiceNumber,"
                        + " loadingPlanItem.loadingPlan.dispatchNote.invoice.customer.code,"
                        + " loadingPlanItem.loadingPlan.dispatchNote.invoice.customer.name,"
                        + " loadingPlanItem.dispatchSchedule.salesOrderItem.customerItem.code,"
                        + " loadingPlanItem.dispatchSchedule.salesOrderItem.salesOrder.customerPoNumber,"
                        + " loadingPlanItem.dispatchSchedule.job.item.code,"
                        + " loadingPlanItem.dispatchSchedule.job.item.description,"
                        + " loadingPlanItem.dispatchSchedule.job.jobNo,"
                        + " loadingPlanItem.dispatchSchedule.job.item.weight,"
                        + " ( CASE WHEN loadingPlanItem.unitPrice != null THEN loadingPlanItem.unitPrice ELSE loadingPlanItem.dispatchSchedule.salesOrderItem.unitPrice END ),"
                        + " SUM(loadingPlanItem.rejectedQuantity)," + " SUM(loadingPlanItem.quantity))"
                        + " FROM LoadingPlanItem loadingPlanItem"
                        + " WHERE loadingPlanItem.loadingPlan.dispatchNote.invoice.invoiceDate BETWEEN :startDate AND :endDate"
                        + " GROUP BY loadingPlanItem.loadingPlan.dispatchNote.invoice, loadingPlanItem.dispatchSchedule.job, loadingPlanItem.dispatchSchedule.salesOrderItem, loadingPlanItem.unitPrice")
        Page<InvoiceInformation> getInvoiceInformationByDateBetween(@Param("startDate") Date startDate,
                        @Param("endDate") Date endDate, Pageable pageable);

        @Query(value = "SELECT " + " new com.trendsmixed.fma.dao.InvoiceInformation("
                        + " loadingPlanItem.loadingPlan.dispatchNote.invoice.customer,"
                        + " loadingPlanItem.loadingPlan.dispatchNote.invoice.invoiceDate,"
                        + " loadingPlanItem.loadingPlan.dispatchNote.invoice.invoiceNumber,"
                        + " loadingPlanItem.loadingPlan.dispatchNote.invoice.customer.code,"
                        + " loadingPlanItem.loadingPlan.dispatchNote.invoice.customer.name,"
                        + " loadingPlanItem.dispatchSchedule.salesOrderItem.customerItem.code,"
                        + " loadingPlanItem.dispatchSchedule.salesOrderItem.salesOrder.customerPoNumber,"
                        + " loadingPlanItem.dispatchSchedule.job.item.code,"
                        + " loadingPlanItem.dispatchSchedule.job.item.description,"
                        + " loadingPlanItem.dispatchSchedule.job.jobNo,"
                        + " loadingPlanItem.dispatchSchedule.job.item.weight,"
                        + " ( CASE WHEN loadingPlanItem.unitPrice != null THEN loadingPlanItem.unitPrice ELSE loadingPlanItem.dispatchSchedule.salesOrderItem.unitPrice END ),"
                        + " SUM(loadingPlanItem.rejectedQuantity)," + " SUM(loadingPlanItem.quantity))"
                        + " FROM LoadingPlanItem loadingPlanItem"
                        + " WHERE loadingPlanItem.loadingPlan.dispatchNote.invoice.invoiceDate BETWEEN :startDate AND :endDate AND loadingPlanItem.loadingPlan.dispatchNote.invoice.customer.id = :customerId"
                        + " GROUP BY loadingPlanItem.loadingPlan.dispatchNote.invoice, loadingPlanItem.dispatchSchedule.job, loadingPlanItem.dispatchSchedule.salesOrderItem, loadingPlanItem.unitPrice")

        Page<InvoiceInformation> getInvoiceInformationByCustomerId(@Param("startDate") Date startDate,
                        @Param("endDate") Date endDate, @Param("customerId") Integer customerId, Pageable pageable);

        @Query(value = "SELECT " + " new com.trendsmixed.fma.dao.InvoiceInformation("
                        + " loadingPlanItem.dispatchSchedule.job,"
                        + " loadingPlanItem.loadingPlan.dispatchNote.invoice.invoiceDate,"
                        + " loadingPlanItem.loadingPlan.dispatchNote.invoice.invoiceNumber,"
                        + " loadingPlanItem.loadingPlan.dispatchNote.invoice.customer.code,"
                        + " loadingPlanItem.loadingPlan.dispatchNote.invoice.customer.name,"
                        + " loadingPlanItem.dispatchSchedule.salesOrderItem.customerItem.code,"
                        + " loadingPlanItem.dispatchSchedule.salesOrderItem.salesOrder.customerPoNumber,"
                        + " loadingPlanItem.dispatchSchedule.job.item.code,"
                        + " loadingPlanItem.dispatchSchedule.job.item.description,"
                        + " loadingPlanItem.dispatchSchedule.job.jobNo,"
                        + " loadingPlanItem.dispatchSchedule.job.item.weight,"
                        + " ( CASE WHEN loadingPlanItem.unitPrice != null THEN loadingPlanItem.unitPrice ELSE loadingPlanItem.dispatchSchedule.salesOrderItem.unitPrice END ),"
                        + " SUM(loadingPlanItem.rejectedQuantity)," + " SUM(loadingPlanItem.quantity))"
                        + " FROM LoadingPlanItem loadingPlanItem"
                        + " WHERE loadingPlanItem.loadingPlan.dispatchNote.invoice.invoiceDate BETWEEN :startDate AND :endDate AND loadingPlanItem.dispatchSchedule.job.id = :jobId "
                        + " GROUP BY loadingPlanItem.loadingPlan.dispatchNote.invoice, loadingPlanItem.dispatchSchedule.job, loadingPlanItem.dispatchSchedule.salesOrderItem, loadingPlanItem.unitPrice")

        Page<InvoiceInformation> getInvoiceInformationByJobId(@Param("startDate") Date startDate,
                        @Param("endDate") Date endDate, @Param("jobId") Integer jobId, Pageable pageable);

        @Query(value = "SELECT " + " new com.trendsmixed.fma.dao.InvoiceInformation("
                        + " loadingPlanItem.loadingPlan.dispatchNote.invoice.invoiceDate,"
                        + " loadingPlanItem.loadingPlan.dispatchNote.invoice.invoiceNumber,"
                        + " loadingPlanItem.loadingPlan.dispatchNote.invoice.customer.code,"
                        + " loadingPlanItem.loadingPlan.dispatchNote.invoice.customer.name,"
                        + " loadingPlanItem.dispatchSchedule.salesOrderItem.customerItem.code,"
                        + " loadingPlanItem.dispatchSchedule.salesOrderItem.salesOrder.customerPoNumber,"
                        + " loadingPlanItem.dispatchSchedule.job.item.code,"
                        + " loadingPlanItem.dispatchSchedule.job.item.description,"
                        + " loadingPlanItem.dispatchSchedule.job.jobNo,"
                        + " loadingPlanItem.dispatchSchedule.job.item.weight,"
                        + " ( CASE WHEN loadingPlanItem.unitPrice != null THEN loadingPlanItem.unitPrice ELSE loadingPlanItem.dispatchSchedule.salesOrderItem.unitPrice END ),"
                        + " SUM(loadingPlanItem.rejectedQuantity)," + " SUM(loadingPlanItem.quantity))"
                        + " FROM LoadingPlanItem loadingPlanItem"
                        + " WHERE loadingPlanItem.loadingPlan.dispatchNote.invoice.invoiceNumber = :invoiceNumber "
                        + " GROUP BY loadingPlanItem.loadingPlan.dispatchNote.invoice, loadingPlanItem.dispatchSchedule.job, loadingPlanItem.dispatchSchedule.salesOrderItem, loadingPlanItem.unitPrice")

        Page<InvoiceInformation> getInvoiceInformationByInvoiceNumber(@Param("invoiceNumber") String invoiceNumber,
                        Pageable pageable);

}

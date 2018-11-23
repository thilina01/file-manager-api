package com.trendsmixed.fma.module.creditnote;

import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Date;
import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CreditNoteRepository extends PagingAndSortingRepository<CreditNote, Integer> {

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id, '', '')" + " FROM CreditNote o")

        List<Combo> getCombo();

        @Query(value = "SELECT "
                        + " new com.trendsmixed.fma.dao.CreditNoteReport(creditNote.id,creditNote.dateOfCreditNote,creditNote.creditNoteNumber,creditNote.invoice,creditNote.invoiceType,creditNote) "
                        + " FROM CreditNote creditNote"
                        + " WHERE creditNote.dateOfCreditNote BETWEEN :startDate AND :endDate")
        Page<CreditNote> getCreditNoteByDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
                        Pageable pageable);

}
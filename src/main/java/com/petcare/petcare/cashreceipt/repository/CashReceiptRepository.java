package com.petcare.petcare.cashreceipt.repository;

import com.petcare.petcare.cashreceipt.model.CashReceipt;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashReceiptRepository extends JpaRepository<CashReceipt, Long> {
    @Query("""
            SELECT c FROM CashReceipt c
            WHERE c.isDeleted = false
             """)
    @NonNull
    List<CashReceipt> findAll();

    @Query("""
            SELECT c FROM CashReceipt  c
            WHERE c.isPaid = true
            AND c.isDeleted = false
            """)
    List<CashReceipt> findAllPaid();

    @Modifying
    @Query("""
            UPDATE CashReceipt c
            SET c.isPaid = true
            WHERE c.id = :id
            """)
    void pay(@Param("id") Long id);

    @Modifying
    @Query("""
           UPDATE CashReceipt c
           SET c.isDeleted = :isDeleted
           WHERE c.id = :id
            """)
    void setDeleteStatus(@Param("id") Long id, @Param("isDeleted") boolean isDeleted);
}

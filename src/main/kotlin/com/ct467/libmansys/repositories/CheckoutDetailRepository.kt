package com.ct467.libmansys.repositories

import com.ct467.libmansys.models.CheckoutDetail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface CheckoutDetailRepository : JpaRepository<CheckoutDetail, Long> {
    fun findAllByCheckout_Id(checkoutId: Long): List<CheckoutDetail>

    fun findByCheckout_IdAndBook_Id(checkoutId: Long, bookId: Long): Optional<CheckoutDetail>

    fun deleteByCheckout_IdAndBook_Id(checkoutId: Long, bookId: Long)

    fun existsByCheckout_IdAndBook_Id(checkoutId: Long, bookId: Long): Boolean
}
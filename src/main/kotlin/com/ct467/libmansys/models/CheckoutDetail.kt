package com.ct467.libmansys.models

import com.ct467.libmansys.models.compositekeys.CheckoutDetailId
import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(name = "checkout_details")
@IdClass(CheckoutDetailId::class)
class CheckoutDetail(
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "checkout_id")
    var checkout: Checkout,

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    var book: Book,

    @Column(name = "note")
    var note: String,

    @Column(name = "returned", nullable = false)
    var returned: Boolean = false,

    @Column(name = "return_date")
    var returnDate: LocalDate? = null
): Serializable  {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CheckoutDetail) return false

        if (checkout != other.checkout) return false
        if (book != other.book) return false
        if (note != other.note) return false
        if (returned != other.returned) return false
        if (returnDate != other.returnDate) return false

        return true
    }

    override fun hashCode(): Int {
        var result = checkout.hashCode()
        result = 31 * result + book.hashCode()
        result = 31 * result + note.hashCode()
        result = 31 * result + returned.hashCode()
        result = 31 * result + (returnDate?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "CheckoutDetail(checkout=$checkout, book=$book, note='$note', returned=$returned, returnDate=$returnDate)"
    }
}
package com.ct467.libmansys.models

import jakarta.persistence.*

@Entity
@Table(name = "books")
class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "name", nullable = false)
    var bookName: String,

    @Column(name = "year", nullable = false)
    var publicationYear: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    var category: Category?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    var author: Author?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    var publisher: Publisher?,

    @Column(name = "deleted", nullable = false)
    var deleted: Boolean = false
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Book) return false

        if (id != other.id) return false
        if (bookName != other.bookName) return false
        if (publicationYear != other.publicationYear) return false
        if (category != other.category) return false
        if (author != other.author) return false
        if (publisher != other.publisher) return false
        if (deleted != other.deleted) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + bookName.hashCode()
        result = 31 * result + publicationYear
        result = 31 * result + (category?.hashCode() ?: 0)
        result = 31 * result + (author?.hashCode() ?: 0)
        result = 31 * result + (publisher?.hashCode() ?: 0)
        result = 31 * result + deleted.hashCode()
        return result
    }

    override fun toString(): String {
        return "Book(id=$id, bookName='$bookName', publicationYear=$publicationYear, category=$category, author=$author, publisher=$publisher, deleted=$deleted)"
    }

}
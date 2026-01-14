package lld.library_management_system;

import java.util.*;

/**
 * /**
 * | DESIGN A LIBRARY MANAGEMENT SYSTEM |
 * ------------------------------------
 * You are asked to design a system that manages books in a library.
 *
 * Requirements:
 * 1. The library has multiple sections
 * - e.g. Fiction, Science, History
 *
 * 2. Each section contains multiple books
 *
 * 3. Each book:
 * - Has a unique book ID
 * - Has a title
 * - Has one or more authors
 *
 * 4. Members:
 * - Can borrow books
 * - Can return books
 *
 * 5. Rules:
 * - A book can only be borrowed by one member at a time
 * - A member can borrow at most N books (assume N = 5)
 *
 * 6. The system should support:
 * - borrowBook(memberId, bookId)
 * - returnBook(memberId, bookId)
 * - findAvailableBooks(section)
 *
 * Constraints:
 * - Single process, in-memory
 * - No database or persistence
 * - No UI
 * - No distributed systems
 * - No overengineering
 *
 * Notes:
 * - IDs can be simple strings or integers
 * - Ignore due dates, fines, and reservations
 * - Focus on clean OOP design and correctness
 */

public class LibraryManagementSystem {
    /**
     * Section:
     * - books: List<Book>
     * - borrowBook()
     * - returnBook()
     * - findAvailableBook()
     * 
     * Book:
     * - id: long
     * - title: String
     * - authors: String or List<String>
     * 
     * Member:
     * - id: long
     * - borrow()
     * - return()
     */
    class Member {
        private final long id;
        List<Long> borrowedBookIds;
        private static final int MAX_LIMIT = 5;

        public Member(long id) {
            this.id = id;
        }

        public long getMemberId() { return id; }

        public int getBorrowedBooksCount() {
            return borrowedBookIds.size();
        }

        boolean canBorrow() { return borrowedBookIds.size() < MAX_LIMIT; }
        void addBook(long bookId) {
            if (!borrowedBookIds.contains(bookId)) {
                borrowedBookIds.add(bookId);
            }
        }

        void removeBook(long bookId) {
            if (borrowedBookIds.contains(bookId)) {
                borrowedBookIds.remove(bookId);
            }
        }
    }

    enum BookState {
        AVAILABLE,
        UNAVAILABLE
    }

    class Book {
        long id;
        String title;
        List<String> authors;
        BookState availability = BookState.AVAILABLE;

        public long getBookId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public List<String> getAuthors() {
            return authors;
        }

        public BookState getAvailability() {
            return availability;
        }
        public void setAvailability(BookState availability) {
            this.availability = availability;
        }
    }

    class Section {
        private String name;
        private final Map<Long, Book> books = new HashMap<>();

        public Section(String name) {
            this.name = name;
        }

        public String getName() { return name; }

        public void addBook(Book book) {
            books.putIfAbsent(book.getBookId(), book);
        }

        public List<Book> getAvailableBooks() {
            return books.values().stream()
                .filter(b -> b.getAvailability() == BookState.AVAILABLE)
                .toList();
        }
    }

    class LibraryService {
        private final Map<Long, Book> allBooks = new HashMap<>();
        private final Map<Long, Member> members = new HashMap<>();
        private final Map<String, Section> sections = new HashMap<>();

        Optional<List<Book>> findAvailableBooks(String sectionName) {
            Section section = sections.get(sectionName.toLowerCase());
            List<Book> available = section.getAvailableBooks();
            
            if (available != null) {
                return Optional.of(available);
            }

            return Optional.empty();
        }

        public void borrowBook(long memberId, long bookId) {
            Member member = members.get(memberId);
            Book book = allBooks.get(bookId);

            if (member == null || book == null) {
                return;
            }

            if (member.getBorrowedBooksCount() >= 5) {
                return;
            }

            if (book.getAvailability() == BookState.UNAVAILABLE) {
                return;
            }

            book.setAvailability(BookState.UNAVAILABLE);
            member.addBook(bookId);
        }

        public void returnBook(long memberId, long bookId) {
            Member member = members.get(memberId);
            Book book = allBooks.get(bookId);

            if (member != null && book != null) {
                member.removeBook(bookId);
                book.setAvailability(BookState.AVAILABLE);
            }
        }
    }
}

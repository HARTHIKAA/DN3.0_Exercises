@GetMapping("/search")
public ResponseEntity<List<Book>> searchBooks(
        @RequestParam(required = false) String title,
        @RequestParam(required = false) String author) {
    List<Book> books;

    if (title != null && author != null) {
        books = bookRepository.findByTitleContainingAndAuthorContaining(title, author);
    } else if (title != null) {
        books = bookRepository.findByTitleContaining(title);
    } else if (author != null) {
        books = bookRepository.findByAuthorContaining(author);
    } else {
        books = bookRepository.findAll();
    }

    return new ResponseEntity<>(books, HttpStatus.OK);
}

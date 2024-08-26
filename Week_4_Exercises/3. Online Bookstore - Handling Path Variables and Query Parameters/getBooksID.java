@GetMapping("/{id}")
public ResponseEntity<Book> getBookById(@PathVariable Long id) {
    Optional<Book> book = bookRepository.findById(id);
    return book.map(ResponseEntity::ok)
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
}

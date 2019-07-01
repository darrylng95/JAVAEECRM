
package ejb.session.stateless;

import entity.BookEntity;
import java.util.List;
import javax.ejb.Remote;
import util.exception.BookNotFoundException;
/**
 * @author Darryl,Paul,WuLin,ZhiKuan
 */
@Remote
public interface BookEntityControllerRemote {
    
    public BookEntity createNewBook(BookEntity newBookEntity);
    
    public BookEntity retrieveBookByBookId (Long bookId) throws BookNotFoundException;
    
    public void updateBook(BookEntity bookEntity);
    
    public void deleteBook(Long bookId) throws BookNotFoundException;
    
    public List<BookEntity> retrieveAllBooks(); 
    
    public List<BookEntity> retreiveBookByTitle(String title);
    
    public void bruteForceDeleteBook (Long bookId);
}

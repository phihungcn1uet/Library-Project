
package Model;

/**
 *
 * @author admin
 */
public class HistoryBook extends Book {

    /**
     *
     */
    public HistoryBook() {
        this.setCategory("Sách Lịch Sử");
    }

    /**
     *
     * @param id
     * @param name
     * @param author
     * @param quantity
     */
    public HistoryBook(String id, String name, String author, int quantity) {
        this.setId(id);
        this.setName(name);
        this.setAuthor(author);
        this.setQuantity(quantity);
        this.setCategory("Sách Lịch Sử");
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getInfo() {
        String s = "History Book [Name : " + this.getName() + " Author: " + this.getAuthor() + " ID:" + this.getId() ;
        return s;
    }
    
}

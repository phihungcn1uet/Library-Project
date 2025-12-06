
package Model;

/**
 *
 * @author admin
 */
public class TextBook extends Book {

    /**
     *
     */
    public TextBook() {
        this.setCategory("Sách giáo trình");
    }
    
    /**
     *
     * @param id
     * @param name
     * @param author
     * @param quantity
     */
    public TextBook(String id, String name, String author, int quantity) {
        this.setId(id);
        this.setName(name);
        this.setAuthor(author);
        this.setQuantity(quantity);
        this.setCategory("Sách giáo trình");
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getInfo() {
        String s = "Text Book [Name : " + this.getName() + " Author: " + this.getAuthor() + " ID:" + this.getId() ;
        return s;
    }
}

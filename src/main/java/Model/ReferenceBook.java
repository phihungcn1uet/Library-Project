
package Model;

/**
 *
 * @author admin
 */
public class ReferenceBook extends Book{

    /**
     *
     */
    public ReferenceBook() {
        this.setCategory("Sách tham khảo");
    }

    /**
     *
     * @param id
     * @param name
     * @param author
     * @param quantity
     */
    public ReferenceBook(String id, String name, String author, int quantity) {
        this.setId(id);
        this.setName(name);
        this.setAuthor(author);
        this.setQuantity(quantity);
        this.setCategory("Sách tham khảo");
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getInfo() {
        String s = "Reference Book [Name : " + this.getName() + " Author: " + this.getAuthor() + " ID:" + this.getId() ;
        return s;
    }
}



package Model;

/**
 *
 * @author admin
 */
public class StoryBook extends Book {

    /**
     *
     */
    public StoryBook() {
        this.setCategory("Truyện");
    }
    
    /**
     *
     * @param id
     * @param name
     * @param author
     * @param quantity
     */
    public StoryBook(String id, String name, String author, int quantity) {
        this.setId(id);
        this.setName(name);
        this.setAuthor(author);
        this.setQuantity(quantity);
        this.setCategory("Truyện");
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getInfo() {
        String s = "Story Book [Name : " + this.getName() + " Author: " + this.getAuthor() + " ID:" + this.getId() ;
        return s;
    }
}

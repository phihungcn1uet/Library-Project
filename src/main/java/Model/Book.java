package Model;

/**
 *
 * @author admin
 */
public class Book {

    /**
     *
     */
    protected String id;

    /**
     *
     */
    protected String name;

    /**
     *
     */
    protected String author;

    /**
     *
     */
    protected String category;

    /**
     *
     */
    protected int quantity;

    /**
     *
     */
    protected byte[] image; 

    /**
     *
     */
    protected float stars;
    
    /**
     *
     */
    public Book() {
        
    }
    
//    public Book(String id, String name, String author, String category, int quantity) {
//        this.id = id;
//        this.name = name;
//        this.author = author;
//        this.category = category;
//        this.quantity = quantity;
//    }

    /**
     *
     * @return
     */

    public String getId() {
        return this.id;
    }
    
    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     *
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }
    
    /**
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    /**
     *
     * @return
     */
    public byte[] getImage() {
        return image;
    }

    /**
     *
     * @param image
     */
    public void setImage(byte[] image) {
        this.image = image;
    }

    /**
     *
     * @return
     */
    public float getStars() {
        return stars;
    }

    /**
     *
     * @param stars
     */
    public void setStars(float stars) {
        this.stars = stars;
    }
    
    /**
     *
     * @return
     */
    public String getInfo() {
        return "";
    }
}

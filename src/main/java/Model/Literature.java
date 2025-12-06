
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

/**
 *
 * @author d
 */
public class Literature extends Book {

    /**
     *
     */
    public Literature() {
        this.setCategory("Văn học");
    }

    /**
     *
     * @param id
     * @param name
     * @param author
     * @param quantity
     */
    public Literature(String id, String name, String author, int quantity) {
        this.setId(id);
        this.setName(name);
        this.setAuthor(author);
        this.setQuantity(quantity);
        this.setCategory("Văn học");
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getInfo() {
        String s = "Literature [Name : " + this.getName() + " Author: " + this.getAuthor() + " ID:" + this.getId() ;
        return s;
    }
}

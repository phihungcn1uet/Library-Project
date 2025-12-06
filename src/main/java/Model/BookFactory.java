package Model;

/**
 *
 * @author admin
 */
public class BookFactory {

    /**
     *
     * @param category
     * @return
     */
    public static Book getBook(String category) {
        switch (category) {
            case "Sách giáo trình": return new TextBook();
            case "Sách Lịch Sử": return new HistoryBook();
            case "Sách tham khảo": return new ReferenceBook();
            case "Truyện": return new StoryBook();
            case "Văn học": return new Literature();
            default: throw new IllegalArgumentException("Invalid book category: " + category);
        }
    }
}


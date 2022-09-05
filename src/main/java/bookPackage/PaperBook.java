package bookPackage;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PaperBook extends Book{
    public PaperBook(String name, String author, String description) {
        super(name, author, description);
    }

    public PaperBook() {
    }

    @Override
    public String toString() {
        return "PaperBook{" +
                "\nname='" + getName() + '\'' +
                "\nauthor='" + getAuthor() + '\'' +
                "\ndescription='" + getDescription() + '\'' +
                "\n}";
    }
}

package bookPackage;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ElectronicBook extends Book {
    public ElectronicBook(String name, String author, String description) {
        super(name, author, description);
    }

    public ElectronicBook() {
    }

    @Override
    public String toString() {
        return "ElectronicBook{" +
                "\nname='" + getName() + '\'' +
                "\nauthor='" + getAuthor() + '\'' +
                "\ndescription='" + getDescription() + '\'' +
                "\n}";
    }
}

package pl.virtuallibrary.repository.jpa;

import org.springframework.data.annotation.Id;

public class BookInformation {

    @Id
    private String id;

    private String name;
    private String size;
    private String path;

    public BookInformation(String name, String size, String path) {
        this.name = name;
        this.size = size;
        this.path = path;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

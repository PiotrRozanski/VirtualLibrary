package pl.virtuallibrary.domain.book;

public class Ebook {
    //ToDo Poprawic nazwe na title tutaj i w serwisie dropbox
    private final String name;
    private final String id;
    private final String size;
    private final String pathLower;

    public Ebook(final String name,
                 final String id,
                 final String size,
                 final String pathLower) {
        this.name = name;
        this.id = id;
        this.size = size;
        this.pathLower = pathLower;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public String getPathLower() {
        return pathLower;
    }
}

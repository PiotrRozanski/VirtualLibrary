package pl.virtuallibrary.google.books.api.mapper;

import com.google.api.services.books.model.Volume;
import pl.virtuallibrary.domain.book.EbookInformation;
import pl.virtuallibrary.domain.book.vo.*;

import java.util.*;
import java.util.stream.Collectors;

public class EbookInformationMapper {

    private static final String BOOK_COVER_NOT_AVAILABLE_IMAGE_URL = "http://i.imgur.com/J5LVHEL.jpg";

    public EbookInformation mapToEbookInformation(final Volume info) {
        return new EbookInformation(new Title(info.getVolumeInfo().getTitle()),
                                    new ArrayList<>(convertToList(info.getVolumeInfo().getAuthors())),
                                    new PublishedDate(info.getVolumeInfo().getPublishedDate()),
                                    new Description(info.getVolumeInfo().getDescription()),
                                    new ISBN(info.getVolumeInfo().getIndustryIdentifiers().get(0).getType(),
                                             info.getVolumeInfo().getIndustryIdentifiers().get(0).getIdentifier()),
                                    new PageCount(info.getVolumeInfo().getPageCount()),
                                    new ImageURL(chooseImageUrl(info.getVolumeInfo().getImageLinks())));
    }


    private List<Author> convertToList(final List<String> authors) {
        return authors.stream().map(Author::new).collect(Collectors.toList());
    }

    private String chooseImageUrl(final Volume.VolumeInfo.ImageLinks url) {
        if (url.getExtraLarge() != null) {
            return url.getExtraLarge();
        }
        if(url.getLarge() != null) {
            return url.getLarge();
        }
        if(url.getMedium() != null) {
            return url.getMedium();
        }
        if(url.getSmall() != null) {
            return url.getSmall();
        }
        if(url.getThumbnail() != null) {
            return url.getThumbnail();
        }
        else {
           return  BOOK_COVER_NOT_AVAILABLE_IMAGE_URL;
        }
    }

}

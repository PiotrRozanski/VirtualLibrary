package pl.virtuallibrary.google.books.api.mapper;

import com.google.api.services.books.model.Volume;
import pl.virtuallibrary.application.EbookInformationCommand;
import pl.virtuallibrary.domain.book.vo.ISBN;

public class EbookInformationMapper {

    private static final String BOOK_COVER_NOT_AVAILABLE_IMAGE_URL = "http://i.imgur.com/J5LVHEL.jpg";

    public EbookInformationCommand mapToEbookInformation(final Volume info) {
        return new EbookInformationCommand(info.getVolumeInfo().getTitle(),
                                    info.getVolumeInfo().getAuthors(),
                                    info.getVolumeInfo().getPublishedDate(),
                                    info.getVolumeInfo().getDescription(),
                                    new ISBN(info.getVolumeInfo().getIndustryIdentifiers().get(0).getType(),
                                             info.getVolumeInfo().getIndustryIdentifiers().get(0).getIdentifier()),
                                    info.getVolumeInfo().getPageCount(),
                                    chooseImageUrl(info.getVolumeInfo().getImageLinks()));
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

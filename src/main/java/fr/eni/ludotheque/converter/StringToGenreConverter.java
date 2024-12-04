package fr.eni.ludotheque.converter;

import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.bll.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToGenreConverter implements Converter<String, Genre> {

    private final GenreService genreService;

    @Autowired
    public StringToGenreConverter(GenreService genreService) {
        this.genreService = genreService;
    }

    @Override
    public Genre convert(String source) {
        int id = Integer.parseInt(source);
        return genreService.findById(id).orElse(null);
    }
}

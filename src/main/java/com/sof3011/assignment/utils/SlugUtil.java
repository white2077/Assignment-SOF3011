package com.sof3011.assignment.utils;

import java.text.Normalizer;

public class SlugUtil {
    public static String convertNameToSlug(String input){
        String slug = input.toLowerCase();
        slug = Normalizer.normalize(slug, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]+", "");
        slug = slug.replaceAll("[^a-z0-9\\-]+", "-");
        slug = slug.replaceAll("^-+|-+$", "");
        return slug;
    }
}

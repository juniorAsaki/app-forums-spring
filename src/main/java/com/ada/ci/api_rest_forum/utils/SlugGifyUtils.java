package com.ada.ci.api_rest_forum.utils;

import com.github.slugify.Slugify;

import java.util.UUID;

public final class SlugGifyUtils {

    private SlugGifyUtils() {}

    public static String genereSlug(String texte)
    {
        String text = String.format("%s %s" , texte, UUID.randomUUID().toString().substring(0, 8));
        final Slugify SLUG = Slugify.builder().build();

        return SLUG.slugify(text);
    }
}
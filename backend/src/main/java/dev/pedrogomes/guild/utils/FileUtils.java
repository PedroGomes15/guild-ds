package dev.pedrogomes.guild.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class FileUtils {

    public static String FixPath(String originalPath){
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/assets/files/")
                .path(originalPath)
                .toUriString();
    }
}

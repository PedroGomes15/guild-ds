package dev.pedrogomes.guild.dto;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

public record FileDTO(MultipartFile file) {

    public MultipartFile getFile(){
        return file;
    }
}

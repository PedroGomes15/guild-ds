package dev.pedrogomes.guild.controller;

import dev.pedrogomes.guild.dto.FileDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("files")
public class FileController {
    private static final String UPLOAD_DIR = "./src/assets/files/";

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestPart MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Falta o file");
        }

        try {
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            File uploadedFile = new File(UPLOAD_DIR + fileName);

            // Certifique-se de que o diretório de upload existe, se não, crie-o
            if (!uploadedFile.getParentFile().exists()) {
                uploadedFile.getParentFile().mkdirs();
            }

            try (FileOutputStream outputStream = new FileOutputStream(uploadedFile)) {
                outputStream.write(file.getBytes());
            }

            // Crie a URL base usando ServletUriComponentsBuilder
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/assets/files/")
                    .path(fileName)
                    .toUriString();

            return ResponseEntity.ok(fileDownloadUri);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Erro ao fazer upload do arquivo");
        }
    }

}

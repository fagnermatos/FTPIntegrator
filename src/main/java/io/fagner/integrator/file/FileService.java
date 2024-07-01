package io.fagner.integrator.file;

import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class FileService {

    private final FileRepository repository;

    @Transactional
    public File save(FileDTO fileDTO) {
        return repository.save(File.of(fileDTO.name()));
    }

    @Transactional
    public void toProcessed(Long id) {
        var vehicle = repository.findById(id)
                .orElseThrow(() -> new NoResultException(STR."Arquivo de id \{id} não existe."));
        vehicle.toProcessed();
    }

    public List<File> findFilesByProcessedAtIsNull() {
        return repository.findFilesByProcessedAtIsNull();
    }
}

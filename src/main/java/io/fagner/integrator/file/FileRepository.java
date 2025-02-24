package io.fagner.integrator.file;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<File, Long> {

    List<File> findFilesByProcessedAtIsNull();
}

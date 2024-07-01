package io.fagner.integrator;

import io.fagner.integrator.file.FileService;
import io.fagner.integrator.vehicle.VehicleDTO;
import io.fagner.integrator.vehicle.VehicleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;

@Slf4j
@Service
@AllArgsConstructor
public class ProcessService {

    private static final String csvSplitBy = ",";

    private final FileService fileService;
    private final VehicleService vehicleService;
    private final AppConfiguration appConfiguration;

    @Transactional
    @Scheduled(fixedRateString = "${task.fixedRate}")
    public void process() {
        var files = fileService.findFilesByProcessedAtIsNull();
        if (files.isEmpty()) {
            log.info("Nada para processar!");
            return;
        }
        var fileToProcess = files.getFirst();
        var filePath = STR."\{appConfiguration.processingFolder}/\{fileToProcess.getName()}";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String headerLine = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] vehicleInfos = line.split(csvSplitBy);
                var vehicleDTO = new VehicleDTO(vehicleInfos[0], vehicleInfos[1], Integer.valueOf(vehicleInfos[2]));
                log.info("{}", vehicleDTO);
                vehicleService.save(vehicleDTO);
            }
            fileService.toProcessed(fileToProcess.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package io.fagner.integrator.vehicle;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public Vehicle save(VehicleDTO vehicle) {
        return vehicleRepository.save(Vehicle.of(vehicle.plate(), vehicle.brandModel(), vehicle.year()));
    }
}

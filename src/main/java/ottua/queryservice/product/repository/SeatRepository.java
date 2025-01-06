package ottua.queryservice.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ottua.queryservice.product.entity.SeatInfo;

import java.util.List;
import java.util.UUID;

public interface SeatRepository extends JpaRepository<SeatInfo, UUID> {
    List<SeatInfo> findSeatInfosByProductInfoId(UUID id);
}

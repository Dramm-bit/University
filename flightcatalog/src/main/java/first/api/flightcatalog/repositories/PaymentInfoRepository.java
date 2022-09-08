package first.api.flightcatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import first.api.flightcatalog.model.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, Long>{
    
}

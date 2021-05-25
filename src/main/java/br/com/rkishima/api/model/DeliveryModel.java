package br.com.rkishima.api.model;

import br.com.rkishima.domain.entities.DeliveryStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class DeliveryModel {

    private Long id;
    private SimplifiedCustomer customer; //Classe para trazer como resposta somente dois campos de cliente
    private RecipientModel recipient;
    private BigDecimal tax;
    private DeliveryStatus status;
    private OffsetDateTime orderDate;
    private OffsetDateTime endDate;

}

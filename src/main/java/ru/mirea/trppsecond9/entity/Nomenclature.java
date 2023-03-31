package ru.mirea.trppsecond9.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;


/** Сущность Номенклатуры. */
@Getter
@Setter
@ToString
public class Nomenclature {

    /** Идентификатор. */
    @JsonProperty("id")
    @CsvBindByName(column = "id")
    private Long id;
    /** Наименование. */
    @JsonProperty("name")
    @CsvBindByName(column = "name")
    private String name;
    /** Признак способа расчета. */
    @JsonProperty("calculationMethod")
    @CsvBindByName(column = "calculation_method")
    private String calculationMethod;
    /** Признак предмета расчета. */
    @JsonProperty("paymentSubject")
    @CsvBindByName(column = "payment_subject")
    private String paymentSubject;
    /** Код ставки НДС. */
    @JsonProperty("vat")
    @CsvBindByName(column = "vat")
    private String vat;
    /** Цена продажи. */
    @JsonProperty("price")
    @CsvBindByName(column = "price")
    private BigDecimal price;

}

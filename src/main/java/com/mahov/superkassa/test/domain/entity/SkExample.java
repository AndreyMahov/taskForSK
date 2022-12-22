package com.mahov.superkassa.test.domain.entity;


import com.mahov.superkassa.test.domain.util.ConverterJson;
import com.mahov.superkassa.test.domain.dto.ResponseDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "sk_example_table")
@Getter
@Setter
public class SkExample {

    @Id
    @SequenceGenerator(
            name = "sk_example_table_id_seq",
            sequenceName = "sk_example_table_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sk_example_table_id_seq"
    )
    @Column(name = "id")
    private long id;

    @Column(name = "obj", columnDefinition = "jsonb")
    @Convert(converter = ConverterJson.class)
    private ResponseDto responseDto;


}

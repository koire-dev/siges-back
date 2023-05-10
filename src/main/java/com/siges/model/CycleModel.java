package com.siges.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


// Annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cycle")
public class CycleModel {
    @Id
    private String id;
    private String label;
}

package edu.springlabs.product.model;

import edu.springlabs.common.model.UniqueId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product extends UniqueId {

    @Column(name = "name", nullable = false)
    private String name;

}

package edu.springlabs.core.model;

import edu.springlabs.common.model.UniqueId;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user")
public class User extends UniqueId {

}

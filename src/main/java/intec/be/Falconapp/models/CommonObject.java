package intec.be.Falconapp.models;

/*

IT IS SUPER CLASS WHERE OTHER CLASS CAN INHERIT FROM LIKE VEHICLE TYPE, VEHICLE STATE AND VEHICLE MODEL
AND VEHICLE TYPE.

 */

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/*
 @MappedSuperclass : That means spring will know that this class is object not an entity, so we don't have table in the database called commonObject
                     and this is abstract class, and we can't instantiate it, but we only need to use it to inherit other class
 */

@MappedSuperclass
// WE NEED THIS LINE TO AVOID INFINITE REGRESSION
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CommonObject extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private String details;

    public CommonObject() {

    }

    public CommonObject(Integer id, String description, String details) {
        this.id = id;
        this.description = description;
        this.details = details;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "CommonObject [id=" + id + ", description=" + description + ", details=" + details + "]";
    }


}

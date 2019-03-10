package fr.nro.demoservlet.bean;

import java.io.Serializable;

/**
 * 
 * @author nrousseau1
 *
 */
public class ToDoBean implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 4413843134143268179L;

    public enum Status {
        EN_COURS, TERMINE, A_FAIRE
    }
    
    private Long id;
    
    private String label;
    
    private  Status status;

    public ToDoBean(Long id, String label, Status status) {
        super();
        this.id = id;
        this.label = label;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    
}

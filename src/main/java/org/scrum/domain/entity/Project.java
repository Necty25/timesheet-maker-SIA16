package org.scrum.domain.entity;
import jakarta.persistence.*;

@Entity(name="Project")
@Table(name="Project")
public class Project {
    @Id
    @SequenceGenerator(name="project_sequence", allocationSize = 1, sequenceName = "project_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_sequence")
    @Column(
            name="project_id",
            updatable = false
    )
    private long project_id;

    @Column(
            name="chargeCode",
            updatable = false
    )
    private long chargeCode;

    @Column(
            name="project_name_client",
            columnDefinition = "TEXT"
    )
    private String project_name_client;

    @Column(
            name="project_group_name_client",
            columnDefinition = "TEXT"
    )
    private String project_group_name_client;

    public Project(long project_id, long chargeCode, String project_name_client, String project_group_name_client) {
        this.project_id = project_id;
        this.chargeCode = chargeCode;
        this.project_name_client = project_name_client;
        this.project_group_name_client = project_group_name_client;
    }

    public Project() {
    }


    public Long getproject_id() {
        return project_id;
    }

    public Long getchargeCode() {
        return chargeCode;
    }

    public void setchargeCode(Long chargeCode) {
        this.chargeCode = chargeCode;
    }

    public String getproject_name_client() {
        return project_name_client;
    }

    public void setproject_name_client(String project_name_client) {
        this.project_name_client = project_name_client;
    }

    public String getproject_group_name_client() {
        return project_group_name_client;
    }

    public void setproject_group_name_client(String project_group_name_client) {
        this.project_group_name_client = project_group_name_client;
    }

}

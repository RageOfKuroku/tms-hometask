package project.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import project.service.additions.Status;

import javax.persistence.*;
import java.util.UUID;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid_generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID task_id;
    @Column(length = 1024)
    private String taskName;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "user_user_id")
    private UserEntity user;


}

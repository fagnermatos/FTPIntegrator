package io.fagner.integrator.file;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "file")
@EqualsAndHashCode
@ToString
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime processedAt;

    public File() {
    }

    public File(String name) {
        this.name = name;
        this.createdAt = LocalDateTime.now();
    }

    public static File of(String name) {
        return new File(name);
    }

    public void toProcessed() {
        this.processedAt = LocalDateTime.now();
    }
}

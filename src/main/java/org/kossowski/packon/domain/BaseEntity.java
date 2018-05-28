package org.kossowski.packon.domain;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity< PKClass >  implements Serializable {

    private  static final long serialVersionUID = 1L;


    @Id @GeneratedValue( strategy = GenerationType.IDENTITY )
    private PKClass id;

    @Column(name = "uuid")
    private UUID uuid = UUID.randomUUID();

    @Version
    @Column( name = "version")
    private Long version;


    public PKClass getId() {
        return id;
    }

    public void setId(PKClass id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uuid);
    }


    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", uuid=" + uuid +
                ", version=" + version +
                '}';
    }
}

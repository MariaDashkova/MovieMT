package botBase;

import javax.persistence.*;

@Entity
@Table(name = "follower_actor", schema = "public", catalog = "postgres")
@IdClass(FollowerActorEntityPK.class)
public class FollowerActorEntity {
    private int idCustomers;
    private int idActor;
    private CustomersEntity customersByIdCustomers;

    @Id
    @Column(name = "id_customers", nullable = false, insertable = false, updatable = false)
    public int getIdCustomers() {
        return idCustomers;
    }

    public void setIdCustomers(int idCustomers) {
        this.idCustomers = idCustomers;
    }

    @Id
    @Column(name = "id_actor", nullable = false)
    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FollowerActorEntity that = (FollowerActorEntity) o;

        if (idCustomers != that.idCustomers) return false;
        if (idActor != that.idActor) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCustomers;
        result = 31 * result + idActor;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_customers", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public CustomersEntity getCustomersByIdCustomers() {
        return customersByIdCustomers;
    }

    public void setCustomersByIdCustomers(CustomersEntity customersByIdCustomers) {
        this.customersByIdCustomers = customersByIdCustomers;
    }
}

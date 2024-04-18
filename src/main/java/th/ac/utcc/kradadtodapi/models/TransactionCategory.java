package th.ac.utcc.kradadtodapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction_category")
public class TransactionCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_category_id", table = "transaction_category")
    private Long id;

    @Column(name = "transaction_category_name", table = "transaction_category")
    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

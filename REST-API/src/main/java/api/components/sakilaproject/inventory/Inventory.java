package api.components.sakilaproject.inventory;

import api.components.sakilaproject.film.Film;
import api.components.sakilaproject.language.Language;
import api.components.sakilaproject.store.Store;
import jakarta.persistence.*;

@Entity
@Table(name="inventory")
public class Inventory {

    @Id
    @Column(name="inventory_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short inventoryID;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    public short getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(short inventoryID) {
        this.inventoryID = inventoryID;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}

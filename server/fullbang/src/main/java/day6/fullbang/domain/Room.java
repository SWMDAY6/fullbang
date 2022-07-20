package day6.fullbang.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue
    @Column(name = "room_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    private String name;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Image> images;

    private int standardCapacity;
    private int maximumCapacity;

    private String useInfo;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Product> products;

    private LocalDateTime crawledAt;
}

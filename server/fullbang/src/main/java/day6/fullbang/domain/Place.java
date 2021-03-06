package day6.fullbang.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "place")
@NoArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Long id;

    @Column(name = "place_name")
    private String name;

    @Column(name = "place_type")
    private String type;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    private String contactInfo;

    @Column(columnDefinition = "LONGTEXT")
    private String detailInfo;

    private Boolean parkingAvailability;

    @Column(unique = true)
    private Long yanolja_id;
    @Column(unique = true)
    private Long yget_id;

    private LocalDateTime crawledAt;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private final List<Room> rooms = new ArrayList<>();

    public String getName() {
        return name;
    }
}

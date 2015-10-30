package artronics.sdwn.server.model;

import javax.persistence.*;

@Entity
@Table(name = "networks")
public class SdwnNetwork
{
    private Long id;

    private String description;

//    private SdwnNetworkSetting sdwnNetworkSetting;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Column(name = "description")
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

//    @OneToOne(fetch = FetchType.EAGER, mappedBy = "sdwnNetwork", cascade = CascadeType.ALL)
//    public SdwnNetworkSetting getSdwnNetworkSetting()
//    {
//        return sdwnNetworkSetting;
//    }

//    public void setSdwnNetworkSetting(SdwnNetworkSetting sdwnNetworkSetting)
//    {
//        this.sdwnNetworkSetting = sdwnNetworkSetting;
//    }
}

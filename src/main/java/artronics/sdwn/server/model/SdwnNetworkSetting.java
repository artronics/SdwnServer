package artronics.sdwn.server.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "network_setting")
public class SdwnNetworkSetting
{
    private Long id;

    private String description;

    private SdwnNetwork sdwnNetwork;

    @Id
    @GenericGenerator(name = "generator", strategy = "foreign"
            , parameters = @Parameter(name = "property", value = "sdwnNetwork"))
    @GeneratedValue(generator = "generator")
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

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    public SdwnNetwork getSdwnNetwork()
    {
        return sdwnNetwork;
    }

    public void setSdwnNetwork(SdwnNetwork sdwnNetwork)
    {
        this.sdwnNetwork = sdwnNetwork;
    }
}

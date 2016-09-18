package cane.brothers.spring.dpd.web;

/**
 * Created by cane on 18.09.16.
 */
public class DpdFacilityVo {

    private String facilityName;
    private Double cost;
    private Integer delivery;


    /**
     * Default consuctor
     */
    public DpdFacilityVo() {
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DpdFacilityVo{");
        sb.append("facilityName='").append(facilityName).append('\'');
        sb.append(", cost=").append(cost);
        sb.append(", delivery=").append(delivery);
        sb.append('}');
        return sb.toString();
    }
}

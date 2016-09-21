package cane.brothers.spring.dpd.web;

import javax.validation.constraints.NotNull;

/**
 * Created by cane on 11.09.16.
 */
public final class DpdCalcVo {

	@NotNull
    private Long cityPickupId;
    private Boolean cityPickupType = false;
    
    @NotNull
    private Long cityDeliveryId;
    private Boolean cityDeliveryType = false;

    /** Вес, кг */
    @NotNull
    private Double weight;
    
    /** Длина, см */
    @NotNull
    private Double length;
    
    /** Ширина, см */
    @NotNull
    private Double width;
    
    /** Высота, см */
    @NotNull
    private Double height;
    
    /** Количество, шт */
    @NotNull
    private Integer quantity = 1;


    /**
     * Default constructor
     */
    public DpdCalcVo() {
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Long getCityPickupId() {
        return cityPickupId;
    }

    public void setCityPickupId(Long cityPickupId) {
        this.cityPickupId = cityPickupId;
    }

    public Boolean getCityPickupType() {
        return cityPickupType;
    }

    public void setCityPickupType(Boolean cityPickupType) {
        this.cityPickupType = cityPickupType;
    }

    public Long getCityDeliveryId() {
        return cityDeliveryId;
    }

    public void setCityDeliveryId(Long cityDeliveryId) {
        this.cityDeliveryId = cityDeliveryId;
    }

    public Boolean getCityDeliveryType() {
        return cityDeliveryType;
    }

    public void setCityDeliveryType(Boolean cityDeliveryType) {
        this.cityDeliveryType = cityDeliveryType;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DpdCalcVo{");
        sb.append("cityPickupId=").append(cityPickupId);
        sb.append(", cityPickupType=").append(cityPickupType);
        sb.append(", cityDeliveryId=").append(cityDeliveryId);
        sb.append(", cityDeliveryType=").append(cityDeliveryType);
        sb.append(", weight=").append(weight);
        sb.append(", length=").append(length);
        sb.append(", width=").append(width);
        sb.append(", height=").append(height);
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }
}

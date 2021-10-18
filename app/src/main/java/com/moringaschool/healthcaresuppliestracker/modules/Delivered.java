
package com.moringaschool.healthcaresuppliestracker.modules;
/*

public class Delivered {
    private String itemName;
    private String itemQuantity;
    private String itemDescription;
    private String donorEmail;
    private String orderDate;
    private String deliveryDate;

    public Delivered(){}

    public Delivered(String itemName, String itemQuantity, String itemDescription, String donorEmail, String deliveryDate) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemDescription = itemDescription;
        this.donorEmail = donorEmail;
        this.deliveryDate = deliveryDate;
    }

    public Delivered(String itemName, String itemQuantity, String itemDescription, String donorEmail, String orderDate, String deliveryDate) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemDescription = itemDescription;
        this.donorEmail = donorEmail;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }



    public String getItemName() {
        return itemName;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getDonorEmail() {
        return donorEmail;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }
}
*/

import java.io.Serializable;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Generated;

@Generated("jsonschema2pojo")
public class Delivered implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("item_name")
    @Expose
    private String itemName;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("order_status")
    @Expose
    private Integer orderStatus;
    @SerializedName("donor")
    @Expose
    private Object donor;
    @SerializedName("hospital")
    @Expose
    private Object hospital;
    public final static Creator<Delivered> CREATOR = new Creator<Delivered>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Delivered createFromParcel(android.os.Parcel in) {
            return new Delivered(in);
        }

        public Delivered[] newArray(int size) {
            return (new Delivered[size]);
        }

    }
            ;
    private final static long serialVersionUID = 9137358681334398262L;

    protected Delivered(android.os.Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.itemName = ((String) in.readValue((String.class.getClassLoader())));
        this.quantity = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.orderStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.donor = ((Object) in.readValue((Object.class.getClassLoader())));
        this.hospital = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Delivered() {
    }

    /**
     *
     * @param itemName
     * @param quantity
     * @param donor
     * @param description
     * @param orderStatus
     * @param id
     * @param hospital
     */
    public Delivered(Integer id, String itemName, Integer quantity, String description, Integer orderStatus, Object donor, Object hospital) {
        super();
        this.id = id;
        this.itemName = itemName;
        this.quantity = quantity;
        this.description = description;
        this.orderStatus = orderStatus;
        this.donor = donor;
        this.hospital = hospital;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Object getDonor() {
        return donor;
    }

    public void setDonor(Object donor) {
        this.donor = donor;
    }

    public Object getHospital() {
        return hospital;
    }

    public void setHospital(Object hospital) {
        this.hospital = hospital;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(itemName);
        dest.writeValue(quantity);
        dest.writeValue(description);
        dest.writeValue(orderStatus);
        dest.writeValue(donor);
        dest.writeValue(hospital);
    }

    public int describeContents() {
        return 0;
    }

}

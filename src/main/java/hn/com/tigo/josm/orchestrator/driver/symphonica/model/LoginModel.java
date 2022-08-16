
package hn.com.tigo.josm.orchestrator.driver.symphonica.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * LoginModel Class in charge of instantiating an object type, necessary for the DADriver process.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 08-16-2022 09:21:07 AM 2022
 */
@Generated("jsonschema2pojo")
public class LoginModel {

    /** Attribute that determine status. */
    @SerializedName("status")
    @Expose
    private String status;
    
    /** Attribute that determine errcode. */
    @SerializedName("errcode")
    @Expose
    private String errcode;
    
    /** Attribute that determine errmessage. */
    @SerializedName("errmessage")
    @Expose
    private String errmessage;
    
    /** Attribute that determine links. */
    @SerializedName("_links")
    @Expose
    private Links links;
    
    /** Attribute that determine embedded. */
    @SerializedName("_embedded")
    @Expose
    private Embedded embedded;

    /**
     * Gets the status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the errcode.
     *
     * @return the errcode
     */
    public String getErrcode() {
        return errcode;
    }

    /**
     * Sets the errcode.
     *
     * @param errcode the new errcode
     */
    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    /**
     * Gets the errmessage.
     *
     * @return the errmessage
     */
    public String getErrmessage() {
        return errmessage;
    }

    /**
     * Sets the errmessage.
     *
     * @param errmessage the new errmessage
     */
    public void setErrmessage(String errmessage) {
        this.errmessage = errmessage;
    }

    /**
     * Gets the links.
     *
     * @return the links
     */
    public Links getLinks() {
        return links;
    }

    /**
     * Sets the links.
     *
     * @param links the new links
     */
    public void setLinks(Links links) {
        this.links = links;
    }

    /**
     * Gets the embedded.
     *
     * @return the embedded
     */
    public Embedded getEmbedded() {
        return embedded;
    }

    /**
     * Sets the embedded.
     *
     * @param embedded the new embedded
     */
    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }

}

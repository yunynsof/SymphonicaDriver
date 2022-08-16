
package hn.com.tigo.josm.orchestrator.driver.symphonica.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Self__1 Class in charge of instantiating an object type, necessary for the DADriver process.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 08-16-2022 09:21:26 AM 2022
 */
@Generated("jsonschema2pojo")
public class Self__1 {

    /** Attribute that determine href. */
    @SerializedName("href")
    @Expose
    private String href;

    /**
     * Gets the href.
     *
     * @return the href
     */
    public String getHref() {
        return href;
    }

    /**
     * Sets the href.
     *
     * @param href the new href
     */
    public void setHref(String href) {
        this.href = href;
    }

}

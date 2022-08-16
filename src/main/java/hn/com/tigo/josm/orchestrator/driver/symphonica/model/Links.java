
package hn.com.tigo.josm.orchestrator.driver.symphonica.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Links Class in charge of instantiating an object type, necessary for the DADriver process.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 08-16-2022 09:20:39 AM 2022
 */
@Generated("jsonschema2pojo")
public class Links {

    /** Attribute that determine self. */
    @SerializedName("self")
    @Expose
    private Self self;

    /**
     * Gets the self.
     *
     * @return the self
     */
    public Self getSelf() {
        return self;
    }

    /**
     * Sets the self.
     *
     * @param self the new self
     */
    public void setSelf(Self self) {
        this.self = self;
    }

}

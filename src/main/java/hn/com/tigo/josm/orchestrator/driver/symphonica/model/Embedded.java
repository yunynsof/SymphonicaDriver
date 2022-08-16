
package hn.com.tigo.josm.orchestrator.driver.symphonica.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Embedded Class in charge of instantiating an object type, necessary for the DADriver process.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 08-16-2022 09:19:46 AM 2022
 */
@Generated("jsonschema2pojo")
public class Embedded {

    /** Attribute that determine session. */
    @SerializedName("session")
    @Expose
    private Session session;

    /**
     * Gets the session.
     *
     * @return the session
     */
    public Session getSession() {
        return session;
    }

    /**
     * Sets the session.
     *
     * @param session the new session
     */
    public void setSession(Session session) {
        this.session = session;
    }

}

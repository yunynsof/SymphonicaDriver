
package hn.com.tigo.josm.orchestrator.driver.symphonica.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Session Class in charge of instantiating an object type, necessary for the DADriver process.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 08-16-2022 09:21:44 AM 2022
 */
@Generated("jsonschema2pojo")
public class Session {

    /** Attribute that determine token. */
    @SerializedName("token")
    @Expose
    private String token;
    
    /** Attribute that determine created. */
    @SerializedName("created")
    @Expose
    private String created;
    
    /** Attribute that determine ttl. */
    @SerializedName("ttl")
    @Expose
    private String ttl;
    
    /** Attribute that determine user. */
    @SerializedName("user")
    @Expose
    private User user;
    
    /** Attribute that determine links. */
    @SerializedName("_links")
    @Expose
    private Links__1 links;

    /**
     * Gets the token.
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the token.
     *
     * @param token the new token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Gets the created.
     *
     * @return the created
     */
    public String getCreated() {
        return created;
    }

    /**
     * Sets the created.
     *
     * @param created the new created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * Gets the ttl.
     *
     * @return the ttl
     */
    public String getTtl() {
        return ttl;
    }

    /**
     * Sets the ttl.
     *
     * @param ttl the new ttl
     */
    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    /**
     * Gets the user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user.
     *
     * @param user the new user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the links.
     *
     * @return the links
     */
    public Links__1 getLinks() {
        return links;
    }

    /**
     * Sets the links.
     *
     * @param links the new links
     */
    public void setLinks(Links__1 links) {
        this.links = links;
    }

}

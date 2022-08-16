
package hn.com.tigo.josm.orchestrator.driver.symphonica.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * User Class in charge of instantiating an object type, necessary for the DADriver process.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 08-16-2022 09:21:52 AM 2022
 */
@Generated("jsonschema2pojo")
public class User {

    /** Attribute that determine id. */
    @SerializedName("id")
    @Expose
    private Integer id;
    
    /** Attribute that determine name. */
    @SerializedName("name")
    @Expose
    private String name;
    
    /** Attribute that determine lastname. */
    @SerializedName("lastname")
    @Expose
    private String lastname;
    
    /** Attribute that determine username. */
    @SerializedName("username")
    @Expose
    private String username;
    
    /** Attribute that determine email. */
    @SerializedName("email")
    @Expose
    private String email;
    
    /** Attribute that determine idLenguaje. */
    @SerializedName("idLenguaje")
    @Expose
    private Integer idLenguaje;
    
    /** Attribute that determine idSector. */
    @SerializedName("idSector")
    @Expose
    private Integer idSector;
    
    /** Attribute that determine status. */
    @SerializedName("status")
    @Expose
    private String status;
    
    /** Attribute that determine isRoot. */
    @SerializedName("isRoot")
    @Expose
    private Integer isRoot;
    
    /** Attribute that determine isSuperAdmin. */
    @SerializedName("isSuperAdmin")
    @Expose
    private Integer isSuperAdmin;
    
    /** Attribute that determine isAdmin. */
    @SerializedName("isAdmin")
    @Expose
    private Integer isAdmin;
    
    /** Attribute that determine simultaneousConn. */
    @SerializedName("simultaneousConn")
    @Expose
    private Integer simultaneousConn;
    
    /** Attribute that determine idDefaultOrganization. */
    @SerializedName("idDefaultOrganization")
    @Expose
    private Integer idDefaultOrganization;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the lastname.
     *
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the lastname.
     *
     * @param lastname the new lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the id lenguaje.
     *
     * @return the id lenguaje
     */
    public Integer getIdLenguaje() {
        return idLenguaje;
    }

    /**
     * Sets the id lenguaje.
     *
     * @param idLenguaje the new id lenguaje
     */
    public void setIdLenguaje(Integer idLenguaje) {
        this.idLenguaje = idLenguaje;
    }

    /**
     * Gets the id sector.
     *
     * @return the id sector
     */
    public Integer getIdSector() {
        return idSector;
    }

    /**
     * Sets the id sector.
     *
     * @param idSector the new id sector
     */
    public void setIdSector(Integer idSector) {
        this.idSector = idSector;
    }

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
     * Gets the checks if is root.
     *
     * @return the checks if is root
     */
    public Integer getIsRoot() {
        return isRoot;
    }

    /**
     * Sets the checks if is root.
     *
     * @param isRoot the new checks if is root
     */
    public void setIsRoot(Integer isRoot) {
        this.isRoot = isRoot;
    }

    /**
     * Gets the checks if is super admin.
     *
     * @return the checks if is super admin
     */
    public Integer getIsSuperAdmin() {
        return isSuperAdmin;
    }

    /**
     * Sets the checks if is super admin.
     *
     * @param isSuperAdmin the new checks if is super admin
     */
    public void setIsSuperAdmin(Integer isSuperAdmin) {
        this.isSuperAdmin = isSuperAdmin;
    }

    /**
     * Gets the checks if is admin.
     *
     * @return the checks if is admin
     */
    public Integer getIsAdmin() {
        return isAdmin;
    }

    /**
     * Sets the checks if is admin.
     *
     * @param isAdmin the new checks if is admin
     */
    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * Gets the simultaneous conn.
     *
     * @return the simultaneous conn
     */
    public Integer getSimultaneousConn() {
        return simultaneousConn;
    }

    /**
     * Sets the simultaneous conn.
     *
     * @param simultaneousConn the new simultaneous conn
     */
    public void setSimultaneousConn(Integer simultaneousConn) {
        this.simultaneousConn = simultaneousConn;
    }

    /**
     * Gets the id default organization.
     *
     * @return the id default organization
     */
    public Integer getIdDefaultOrganization() {
        return idDefaultOrganization;
    }

    /**
     * Sets the id default organization.
     *
     * @param idDefaultOrganization the new id default organization
     */
    public void setIdDefaultOrganization(Integer idDefaultOrganization) {
        this.idDefaultOrganization = idDefaultOrganization;
    }

}
